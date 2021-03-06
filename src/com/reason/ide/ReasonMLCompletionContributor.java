package com.reason.ide;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiFile;
import com.intellij.util.ProcessingContext;
import com.reason.icons.ReasonMLIcons;
import com.reason.merlin.MerlinService;
import com.reason.merlin.types.MerlinCompletion;
import com.reason.merlin.types.MerlinCompletionEntry;
import com.reason.merlin.types.MerlinPosition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ReasonMLCompletionContributor extends CompletionContributor {

    public ReasonMLCompletionContributor() {
        MerlinService merlin = ApplicationManager.getApplication().getComponent(MerlinService.class);

        CompletionProvider<CompletionParameters> completionProvider = new CompletionProvider<CompletionParameters>() {
            @Override
            protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet resultSet) {
                PsiFile originalFile = parameters.getOriginalFile();
                String text = originalFile.getText();
                LineNumbering lineNumbering = new LineNumbering(text);

                String suitablePrefix = findSuitablePrefix(parameters, text);

                MerlinPosition position = lineNumbering.offsetToPosition(parameters.getOffset());
                MerlinCompletion completion = merlin.completions(originalFile.getName(), suitablePrefix, position);

                System.out.println("Completion prefix: " + suitablePrefix);
                for (MerlinCompletionEntry entry : completion.entries) {
                    resultSet.addElement(LookupElementBuilder.
                            create(entry.name).
                            withIcon(getIcon(entry)).
                            withTypeText(entry.desc));
                }
            }
        };

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(), completionProvider);
        extend(CompletionType.SMART, PlatformPatterns.psiElement(), completionProvider);
        extend(CompletionType.CLASS_NAME, PlatformPatterns.psiElement(), completionProvider);
    }

    @Nullable
    private Icon getIcon(MerlinCompletionEntry entry) {
        Icon entryIcon = null;
        if ("Type".equals(entry.kind)) {
            entryIcon = ReasonMLIcons.TYPE;
        } else if ("Value".equals(entry.kind)) {
            entryIcon = ReasonMLIcons.VALUE;
        } else if ("Module".equals(entry.kind)) {
            entryIcon = ReasonMLIcons.MODULE;
        } else if ("Signature".equals(entry.kind)) {
            entryIcon = ReasonMLIcons.SIGNATURE;
        }
        return entryIcon;
    }

    // find all text on the left of the cursor
    private String findSuitablePrefix(CompletionParameters parameters, String text) {
        int endPos = parameters.getOffset();
        int startPos = endPos;

        // find space or return
        while (startPos > 0) {
            char previousChar = text.charAt(startPos - 1);
            if (previousChar == ' ' || previousChar == '\n' || previousChar == '(') {
                break;
            }
            startPos--;
        }

        return text.substring(startPos, endPos);
    }
}
