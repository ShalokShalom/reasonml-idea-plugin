package com.reason.lang;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.reason.psi.*;

class RmlPsiElementFactory {
    static PsiElement createElement(ASTNode node) {
        IElementType type = node.getElementType();
        if (type == ReasonMLTypes.EXTERNAL_EXPRESSION) {
            return new ReasonMLExternal(node);
        } else if (type == ReasonMLTypes.FUN_BODY) {
            return new ReasonMLFunBody(node);
        } else if (type == ReasonMLTypes.LET_BINDING) {
            return new ReasonMLLetBinding(node);
        } else if (type == ReasonMLTypes.LET_EXPRESSION) {
            return new ReasonMLLet(node);
        } else if (type == ReasonMLTypes.MODULE_NAME) {
            return new ReasonMLModuleName(node);
        } else if (type == ReasonMLTypes.MODULE_EXPRESSION) {
            return new ReasonMLModule(node);
        } else if (type == ReasonMLTypes.TYPE_CONSTR_NAME) {
            return new ReasonMLTypeConstrName(node);
        } else if (type == ReasonMLTypes.SCOPED_EXPR) {
            return new ReasonMLScopedExpr(node);
        } else if (type == ReasonMLTypes.TYPE_EXPRESSION) {
            return new ReasonMLType(node);
        } else if (type == ReasonMLTypes.VALUE_NAME) {
            return new ReasonMLValueName(node);
        }
        return new ReasonMLToken(node);
    }
}
