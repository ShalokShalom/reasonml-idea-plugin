package com.reason.merlin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reason.Platform;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class MerlinProcess implements Closeable {

    static final String NO_CONTEXT = null;

    private ObjectMapper objectMapper;
    private Process merlin;
    private BufferedWriter writer;
    private BufferedReader reader;
    private BufferedReader errorReader;

    MerlinProcess(String merlinBin) throws IOException {
        List<String> commands;

        if (Platform.isWindows()) {
            commands = singletonList(merlinBin);
        } else {
            String absolutePath = new File(merlinBin).getAbsoluteFile().getParent();
            commands = asList("bash", "-c", "export PATH=" + absolutePath + ":$PATH && ocamlmerlin");
        }

        ProcessBuilder processBuilder = new ProcessBuilder(commands)
                .redirectErrorStream(true);

        this.merlin = processBuilder.start();
        this.writer = new BufferedWriter(new OutputStreamWriter(merlin.getOutputStream()));
        this.reader = new BufferedReader(new InputStreamReader(merlin.getInputStream()));
        this.errorReader = new BufferedReader(new InputStreamReader(merlin.getErrorStream()));

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void close() throws IOException {
        if (merlin != null && merlin.isAlive()) {
            try {
                writer.close();
                reader.close();
                errorReader.close();
            } catch (IOException e) {
                // nothing to do
            }
            merlin.destroyForcibly();
            merlin = null;
        }
    }

    @Nullable
    <R> R makeRequest(TypeReference<R> type, @Nullable String filename, String query) {
        if (this.merlin == null) {
            return null;
        }

        try {
            String request;
            if (filename == NO_CONTEXT) {
                request = query;
            } else {
                request = "{\"context\": [\"auto\", " + this.objectMapper.writeValueAsString(filename) + "], " +
                        "\"query\": " + query + "}";
            }
            //System.out.println("=> " + request);

            this.writer.write(request);
            this.writer.flush();

            if (this.errorReader.ready()) {
                StringBuilder errorBuffer = new StringBuilder();
                this.errorReader.lines().forEach(l -> errorBuffer.append(l).append(System.lineSeparator()));
                throw new RuntimeException(errorBuffer.toString());
            } else {
                String content = this.reader.readLine();
                JsonNode jsonNode = this.objectMapper.readTree(content);
                JsonNode responseNode = extractResponse(jsonNode);
                //System.out.println("<= " + responseNode);

                try {
                    return this.objectMapper.convertValue(responseNode, type);
                } catch (RuntimeException e) {
                    System.err.println("Conversion error of request " + content + "\n  " + e.getMessage());
                    throw e;
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private JsonNode extractResponse(JsonNode merlinResult) {
        JsonNode classField = merlinResult.get("class");
        JsonNode value = merlinResult.get("value");

        String responseType = classField.textValue();
        if ("return".equals(responseType)) {
            return value;
        }

        throw new RuntimeException(value.toString());
    }

    String writeValueAsString(Object value) {
        try {
            return this.objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
