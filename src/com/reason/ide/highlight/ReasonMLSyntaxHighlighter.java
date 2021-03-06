package com.reason.ide.highlight;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.reason.lang.ReasonMLLexerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.reason.lang.ReasonMLTypes.*;

public class ReasonMLSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final Set<IElementType> KEYWORD_TYPES = of(OPEN, MODULE, FUN, LET, TYPE, INCLUDE, EXTERNAL, IF, ELSE, SWITCH);
    private static final Set<IElementType> OPERATION_SIGN_TYPES = of(EQ, EQEQEQ, ARROW, SHORTCUT, COLON, SHARP, QUESTION_MARK, PLUS, PLUSDOT, MINUS, MINUSDOT, STAR, STARDOT, SLASH, SLASHDOT, CARRET, ARROBASE);
    private static final Set<IElementType> OPTIONS_TYPES = of(NONE, SOME, OPTION);

    public static final TextAttributesKey COMMENT_ = createTextAttributesKey("REASONML_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey STRING_ = createTextAttributesKey("REASONML_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TAG_ = createTextAttributesKey("REASONML_TAG", DefaultLanguageHighlighterColors.MARKUP_TAG);
    public static final TextAttributesKey MODULE_NAME_ = createTextAttributesKey("REASONML_UIDENT", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey OPTION_ = createTextAttributesKey("REASONML_OPTION");
    public static final TextAttributesKey KEYWORD_ = createTextAttributesKey("REASONML_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey SEMICOLON_ = createTextAttributesKey("REASONML_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey BRACKETS_ = createTextAttributesKey("REASONML_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey BRACES_ = createTextAttributesKey("REASONML_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey PARENS_ = createTextAttributesKey("REASONML_PARENS", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey OPERATION_SIGN_ = createTextAttributesKey("REASONML_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private static final TextAttributesKey BAD_CHAR_ = createTextAttributesKey("REASONML_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT_};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING_};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACES_};
    private static final TextAttributesKey[] PAREN_KEYS = new TextAttributesKey[]{PARENS_};
    private static final TextAttributesKey[] OPTION_KEYS = new TextAttributesKey[]{OPTION_};
    private static final TextAttributesKey[] TAG_KEYS = new TextAttributesKey[]{TAG_};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD_};
    private static final TextAttributesKey[] SEMICOLON_KEYS = new TextAttributesKey[]{SEMICOLON_};
    private static final TextAttributesKey[] OPERATION_SIGN_KEYS = new TextAttributesKey[]{OPERATION_SIGN_};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHAR_};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ReasonMLLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(LBRACE) || tokenType.equals(RBRACE)) {
            return BRACE_KEYS;
        } else if (tokenType.equals(LPAREN) || tokenType.equals(RPAREN)) {
            return PAREN_KEYS;
        } else if (tokenType.equals(AUTO_CLOSE_TAG) || tokenType.equals(CLOSE_TAG) || tokenType.equals(GT) || tokenType.equals(LT)) {
            return TAG_KEYS;
        } else if (SEMI.equals(tokenType)) {
            return SEMICOLON_KEYS;
        } else if (STRING.equals(tokenType)) {
            return STRING_KEYS;
        } else if (KEYWORD_TYPES.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (OPERATION_SIGN_TYPES.contains(tokenType)) {
            return OPERATION_SIGN_KEYS;
        } else if (OPTIONS_TYPES.contains(tokenType)) {
            return OPTION_KEYS;
        } else if (BAD_CHARACTER.equals(tokenType)) {
            return BAD_CHAR_KEYS;
        }

        return EMPTY_KEYS;
    }

    private static Set<IElementType> of(IElementType... types) {
        Set<IElementType> result = new HashSet<>();
        Collections.addAll(result, types);
        return result;
    }
}
