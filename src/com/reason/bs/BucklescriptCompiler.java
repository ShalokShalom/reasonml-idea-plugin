package com.reason.bs;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.KillableColoredProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessListener;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.components.AbstractProjectComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.reason.Platform;
import com.reason.ide.ReasonMLNotification;
import org.jetbrains.annotations.Nullable;

public class BucklescriptCompiler extends AbstractProjectComponent {

    private KillableColoredProcessHandler bsb;
    private GeneralCommandLine commandLine;
    private ProcessListener outputListener;

    protected BucklescriptCompiler(Project project) {
        super(project);
    }

    @Override
    public void projectOpened() {
        String reasonBsb = System.getProperty("reasonBsb");
        if (reasonBsb == null) {
            Notifications.Bus.notify(new ReasonMLNotification("Bsb", "Bsb is disabled, you need to manually launch an external process", NotificationType.WARNING));
            return;
        }

        VirtualFile baseDir = Platform.findBaseRoot(this.myProject);
        VirtualFile bsbBinary = baseDir.findFileByRelativePath(reasonBsb);
        if (bsbBinary == null) {
            Notifications.Bus.notify(new ReasonMLNotification("Bsb", "Can't find bsb using value '" + reasonBsb + "' from property 'reasonBsb'.\nBase directory is '" + baseDir.getCanonicalPath() + "'.\nBe sure that bsb is installed and reachable from base directory.", NotificationType.ERROR));
            // Add notification system that watch node_modules
            return;
        }

        this.commandLine = new GeneralCommandLine(bsbBinary.getCanonicalPath(), "-make-world", "-w");
        commandLine.setWorkDirectory(baseDir.getCanonicalPath());

        this.recreate();
/*
        ProcessBuilder processBuilder = new ProcessBuilder(bsbBinary.getCanonicalPath(), "-make-world", "-w")
                .directory(new File(baseDir.getCanonicalPath()))
                .redirectErrorStream(true);

        try {
            this.bsb = processBuilder.start();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bsb.getInputStream()));
            Notifications.Bus.notify(new ReasonMLNotification("Bsb", "Enabled", "Background compilation is using '" + bsbBinary.getCanonicalPath() + "'", NotificationType.INFORMATION, null));

            this.streamListener = new Thread(() -> {
                String line = null;
                BsbError errorMode = null;

                while (true) {
                    try {
                        line = bufferedReader.readLine();

                        if (errorMode != null) {
                            if (line != null && !line.isEmpty()) {
                                if (line.startsWith("File")) {
                                    errorMode.file = line.substring(5);
                                } else if (line.startsWith("Error")) {
                                    errorMode.errorType = line.substring(7);
                                } else if (line.charAt(0) == ' ') {
                                    // still error
                                } else if (errorMode.errorType != null) {
                                    System.out.println("ERROR DETECTED: " + errorMode);
                                    BucklescriptErrorsManager.getInstance(myProject).setError(errorMode);
                                    errorMode = null;
                                }
                            }
                        } else if (line.startsWith("FAILED")) {
                            errorMode = new BsbError();
                        } else if (line.startsWith(">>>> Start compiling")) {
                            // starts
                            System.out.println("START");
                        } else if (line.startsWith(">>>> Finish compiling")) {
                            System.out.println("STOP");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (line != null && !line.isEmpty()) {
                        if (errorMode != null && errorMode.errorType != null) {
                            errorMode.errors.add(line.trim());
                        }
                        System.out.println("» " + line);
                        // redirect to a console (like wallaby) somewhere ?
                    }
                }
            });
            this.streamListener.start();
        } catch (IOException e) {
            Notifications.Bus.notify(new ReasonMLNotification("Bsb", "Can't run bsb\n" + e.getMessage(), NotificationType.ERROR));
        }
*/
    }

    @Override
    public void projectClosed() {
        killIt();
    }

    @Nullable
    ProcessHandler getHandler() {
        return this.bsb;
    }

    // Wait for the toolwindow to be ready before starting the process
    void startNotify() {
        if (this.bsb != null) {
            this.bsb.startNotify();
        }
    }

    @Nullable
    ProcessHandler recreate() {
        try {
            killIt();
            this.bsb = new KillableColoredProcessHandler(this.commandLine, true);
            if (this.outputListener != null) {
                this.bsb.addProcessListener(this.outputListener);
            }
            return this.bsb;
        } catch (ExecutionException e) {
            Notifications.Bus.notify(new ReasonMLNotification("Bsb", "Can't run bsb\n" + e.getMessage(), NotificationType.ERROR));
        }
        return null;
    }

    private void killIt() {
        if (this.bsb != null) {
            this.bsb.killProcess();
            this.bsb = null;
        }
    }

    void addListener(ProcessListener outputListener) {
        this.outputListener = outputListener;
        if (this.bsb != null) {
            this.bsb.addProcessListener(outputListener);
        }
    }
}
