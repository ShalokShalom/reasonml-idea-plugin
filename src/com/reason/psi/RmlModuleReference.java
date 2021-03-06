package com.reason.psi;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.psi.*;
import com.reason.icons.ReasonMLIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class RmlModuleReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String myName;

    RmlModuleReference(@NotNull PsiElement element, String name) {
        super(element);
        myName = name;
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        List<ResolveResult> results = new ArrayList<>();

        List<PsiFile> files = RmlPsiUtil.findFileModules(myElement.getProject(), myName);
        for (PsiFile file : files) {
            results.add(new PsiElementResolveResult(file));
        }

        List<ReasonMLModule> modules = RmlPsiUtil.findModules(myElement.getProject(), myName);
        for (ReasonMLModule module : modules) {
            results.add(new PsiElementResolveResult(module));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] results = multiResolve(false);
        return results.length == 1 ? results[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        List<LookupElement> result = new ArrayList<>();

        List<ReasonMLModule> modules = RmlPsiUtil.findModules(myElement.getProject());
        for (ReasonMLModule module : modules) {
            result.add(LookupElementBuilder.create(module).withIcon(ReasonMLIcons.MODULE).withTypeText("VARIANTS:" + module.getContainingFile().getName()));
        }

        return result.toArray();
    }
}
