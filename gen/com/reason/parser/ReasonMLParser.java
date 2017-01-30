// This is a generated file. Not intended for manual editing.
package com.reason.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.reason.psi.ReasonMLTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ReasonMLParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARGUMENT) {
      r = argument(b, 0);
    }
    else if (t == CORE_TYPE) {
      r = core_type(b, 0);
    }
    else if (t == END_TAG) {
      r = end_tag(b, 0);
    }
    else if (t == EXPR) {
      r = expr(b, 0);
    }
    else if (t == EXPR_STATEMENT) {
      r = expr_statement(b, 0);
    }
    else if (t == FUN_ARG) {
      r = fun_arg(b, 0);
    }
    else if (t == FUN_BODY) {
      r = fun_body(b, 0);
    }
    else if (t == INCLUDE_STATEMENT) {
      r = include_statement(b, 0);
    }
    else if (t == JSX) {
      r = jsx(b, 0);
    }
    else if (t == JSX_CONTENT) {
      r = jsxContent(b, 0);
    }
    else if (t == LET_BINDING) {
      r = let_binding(b, 0);
    }
    else if (t == LET_BINDING_BODY) {
      r = let_binding_body(b, 0);
    }
    else if (t == MODULE_BODY) {
      r = module_body(b, 0);
    }
    else if (t == MODULE_EXPR) {
      r = module_expr(b, 0);
    }
    else if (t == MODULE_NAME) {
      r = module_name(b, 0);
    }
    else if (t == MODULE_PATH) {
      r = module_path(b, 0);
    }
    else if (t == MODULE_STATEMENT) {
      r = module_statement(b, 0);
    }
    else if (t == RECORD_FIELD) {
      r = record_field(b, 0);
    }
    else if (t == SEQ_EXPR) {
      r = seq_expr(b, 0);
    }
    else if (t == SHORT_ID) {
      r = short_id(b, 0);
    }
    else if (t == START_TAG) {
      r = start_tag(b, 0);
    }
    else if (t == TAG_NAME) {
      r = tag_name(b, 0);
    }
    else if (t == TAG_PROPERTY) {
      r = tag_property(b, 0);
    }
    else if (t == TUPLE_ARG) {
      r = tuple_arg(b, 0);
    }
    else if (t == TUPLE_EXPR) {
      r = tuple_expr(b, 0);
    }
    else if (t == TUPLE_VALUE) {
      r = tuple_value(b, 0);
    }
    else if (t == TYPE_DEFINITION) {
      r = type_definition(b, 0);
    }
    else if (t == TYPE_STATEMENT) {
      r = type_statement(b, 0);
    }
    else if (t == VALUE_NAME) {
      r = value_name(b, 0);
    }
    else if (t == VALUE_PATH) {
      r = value_path(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return reasonFile(b, l + 1);
  }

  /* ********************************************************** */
  // STRING
  //     | jsx
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    if (!nextTokenIs(b, "<argument>", LT, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = consumeToken(b, STRING);
    if (!r) r = jsx(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LIDENT
  public static boolean core_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "core_type")) return false;
    if (!nextTokenIs(b, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIDENT);
    exit_section_(b, m, CORE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // CLOSE_TAG tag_name GT
  public static boolean end_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_tag")) return false;
    if (!nextTokenIs(b, CLOSE_TAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CLOSE_TAG);
    r = r && tag_name(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, END_TAG, r);
    return r;
  }

  /* ********************************************************** */
  // value_path argument
  //        | LPAREN expr RPAREN
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = expr_0(b, l + 1);
    if (!r) r = expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // value_path argument
  private static boolean expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_path(b, l + 1);
    r = r && argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN expr RPAREN
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr+ SEMI
  public static boolean expr_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_STATEMENT, "<expr statement>");
    r = expr_statement_0(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr+
  private static boolean expr_statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expr_statement_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // short_id
  //     | LBRACE short_id RBRACE
  public static boolean fun_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUN_ARG, "<fun arg>");
    r = short_id(b, l + 1);
    if (!r) r = fun_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LBRACE short_id RBRACE
  private static boolean fun_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_arg_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && short_id(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (seq_expr)* NONE?
  public static boolean fun_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUN_BODY, "<fun body>");
    r = fun_body_0(b, l + 1);
    r = r && fun_body_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (seq_expr)*
  private static boolean fun_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!fun_body_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fun_body_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (seq_expr)
  private static boolean fun_body_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = seq_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NONE?
  private static boolean fun_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fun_body_1")) return false;
    consumeToken(b, NONE);
    return true;
  }

  /* ********************************************************** */
  // INCLUDE module_expr (module_expr)* SEMI
  public static boolean include_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement")) return false;
    if (!nextTokenIs(b, INCLUDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INCLUDE);
    r = r && module_expr(b, l + 1);
    r = r && include_statement_2(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, INCLUDE_STATEMENT, r);
    return r;
  }

  // (module_expr)*
  private static boolean include_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!include_statement_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "include_statement_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (module_expr)
  private static boolean include_statement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_statement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // start_tag tag_property* ( AUTO_CLOSE_TAG | GT jsxContent* end_tag )
  public static boolean jsx(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsx")) return false;
    if (!nextTokenIs(b, LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = start_tag(b, l + 1);
    r = r && jsx_1(b, l + 1);
    r = r && jsx_2(b, l + 1);
    exit_section_(b, m, JSX, r);
    return r;
  }

  // tag_property*
  private static boolean jsx_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsx_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tag_property(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jsx_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // AUTO_CLOSE_TAG | GT jsxContent* end_tag
  private static boolean jsx_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsx_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AUTO_CLOSE_TAG);
    if (!r) r = jsx_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GT jsxContent* end_tag
  private static boolean jsx_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsx_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GT);
    r = r && jsx_2_1_1(b, l + 1);
    r = r && end_tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // jsxContent*
  private static boolean jsx_2_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsx_2_1_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!jsxContent(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "jsx_2_1_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // value_name
  public static boolean jsxContent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsxContent")) return false;
    if (!nextTokenIs(b, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_name(b, l + 1);
    exit_section_(b, m, JSX_CONTENT, r);
    return r;
  }

  /* ********************************************************** */
  // LET short_id let_binding_body SEMI
  public static boolean let_binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && short_id(b, l + 1);
    r = r && let_binding_body(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, LET_BINDING, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL FUN (fun_arg)* ARROW fun_body
  //     | EQUAL seq_expr
  //     | (fun_arg)* ARROW LBRACE? fun_body RBRACE?
  public static boolean let_binding_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LET_BINDING_BODY, "<let binding body>");
    r = let_binding_body_0(b, l + 1);
    if (!r) r = let_binding_body_1(b, l + 1);
    if (!r) r = let_binding_body_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // EQUAL FUN (fun_arg)* ARROW fun_body
  private static boolean let_binding_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUAL, FUN);
    r = r && let_binding_body_0_2(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && fun_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (fun_arg)*
  private static boolean let_binding_body_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_0_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!let_binding_body_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_binding_body_0_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (fun_arg)
  private static boolean let_binding_body_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fun_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL seq_expr
  private static boolean let_binding_body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUAL);
    r = r && seq_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (fun_arg)* ARROW LBRACE? fun_body RBRACE?
  private static boolean let_binding_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_binding_body_2_0(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && let_binding_body_2_2(b, l + 1);
    r = r && fun_body(b, l + 1);
    r = r && let_binding_body_2_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (fun_arg)*
  private static boolean let_binding_body_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_2_0")) return false;
    int c = current_position_(b);
    while (true) {
      if (!let_binding_body_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_binding_body_2_0", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (fun_arg)
  private static boolean let_binding_body_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fun_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACE?
  private static boolean let_binding_body_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_2_2")) return false;
    consumeToken(b, LBRACE);
    return true;
  }

  // RBRACE?
  private static boolean let_binding_body_2_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_binding_body_2_4")) return false;
    consumeToken(b, RBRACE);
    return true;
  }

  /* ********************************************************** */
  // (  module_statement
  //     | include_statement
  //     | type_statement
  //     | let_binding )*
  public static boolean module_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_body")) return false;
    Marker m = enter_section_(b, l, _NONE_, MODULE_BODY, "<module body>");
    int c = current_position_(b);
    while (true) {
      if (!module_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_body", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // module_statement
  //     | include_statement
  //     | type_statement
  //     | let_binding
  private static boolean module_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_statement(b, l + 1);
    if (!r) r = include_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    if (!r) r = let_binding(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // module_path
  public static boolean module_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_expr")) return false;
    if (!nextTokenIs(b, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_path(b, l + 1);
    exit_section_(b, m, MODULE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // UIDENT
  public static boolean module_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_name")) return false;
    if (!nextTokenIs(b, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UIDENT);
    exit_section_(b, m, MODULE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // module_name (DOT module_name)*
  public static boolean module_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_path")) return false;
    if (!nextTokenIs(b, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_name(b, l + 1);
    r = r && module_path_1(b, l + 1);
    exit_section_(b, m, MODULE_PATH, r);
    return r;
  }

  // (DOT module_name)*
  private static boolean module_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_path_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!module_path_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "module_path_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT module_name
  private static boolean module_path_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_path_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && module_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE module_name EQUAL LBRACE module_body RBRACE SEMI
  public static boolean module_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_statement")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MODULE);
    r = r && module_name(b, l + 1);
    r = r && consumeTokens(b, 0, EQUAL, LBRACE);
    r = r && module_body(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACE, SEMI);
    exit_section_(b, m, MODULE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ( COMMENT | module_statement | include_statement | let_binding | expr_statement | type_statement )*
  static boolean reasonFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reasonFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!reasonFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "reasonFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMENT | module_statement | include_statement | let_binding | expr_statement | type_statement
  private static boolean reasonFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reasonFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMENT);
    if (!r) r = module_statement(b, l + 1);
    if (!r) r = include_statement(b, l + 1);
    if (!r) r = let_binding(b, l + 1);
    if (!r) r = expr_statement(b, l + 1);
    if (!r) r = type_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // short_id (COLON short_id)?
  public static boolean record_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field")) return false;
    if (!nextTokenIs(b, "<record field>", LIDENT, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RECORD_FIELD, "<record field>");
    r = short_id(b, l + 1);
    r = r && record_field_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON short_id)?
  private static boolean record_field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field_1")) return false;
    record_field_1_0(b, l + 1);
    return true;
  }

  // COLON short_id
  private static boolean record_field_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_field_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && short_id(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LIDENT
  //     | STRING
  //     | INT
  //     | FLOAT
  //     | tuple_expr
  public static boolean seq_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "seq_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SEQ_EXPR, "<seq expr>");
    r = consumeToken(b, LIDENT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = tuple_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UIDENT | LIDENT
  public static boolean short_id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "short_id")) return false;
    if (!nextTokenIs(b, "<short id>", LIDENT, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHORT_ID, "<short id>");
    r = consumeToken(b, UIDENT);
    if (!r) r = consumeToken(b, LIDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LT tag_name
  public static boolean start_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_tag")) return false;
    if (!nextTokenIs(b, LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && tag_name(b, l + 1);
    exit_section_(b, m, START_TAG, r);
    return r;
  }

  /* ********************************************************** */
  // LIDENT | UIDENT
  public static boolean tag_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_name")) return false;
    if (!nextTokenIs(b, "<tag name>", LIDENT, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_NAME, "<tag name>");
    r = consumeToken(b, LIDENT);
    if (!r) r = consumeToken(b, UIDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // value_name EQUAL STRING
  public static boolean tag_property(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_property")) return false;
    if (!nextTokenIs(b, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_name(b, l + 1);
    r = r && consumeTokens(b, 0, EQUAL, STRING);
    exit_section_(b, m, TAG_PROPERTY, r);
    return r;
  }

  /* ********************************************************** */
  // tuple_value (COLON core_type)?
  public static boolean tuple_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_arg")) return false;
    if (!nextTokenIs(b, "<tuple arg>", INT, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_ARG, "<tuple arg>");
    r = tuple_value(b, l + 1);
    r = r && tuple_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COLON core_type)?
  private static boolean tuple_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_arg_1")) return false;
    tuple_arg_1_0(b, l + 1);
    return true;
  }

  // COLON core_type
  private static boolean tuple_arg_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_arg_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && core_type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN tuple_arg (COMMA tuple_arg)* RPAREN
  public static boolean tuple_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_expr")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && tuple_arg(b, l + 1);
    r = r && tuple_expr_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, TUPLE_EXPR, r);
    return r;
  }

  // (COMMA tuple_arg)*
  private static boolean tuple_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_expr_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!tuple_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tuple_expr_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA tuple_arg
  private static boolean tuple_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && tuple_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INT
  //     | LIDENT
  public static boolean tuple_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tuple_value")) return false;
    if (!nextTokenIs(b, "<tuple value>", INT, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TUPLE_VALUE, "<tuple value>");
    r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, LIDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EQUAL LBRACE record_field (COMMA record_field)* RBRACE
  public static boolean type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition")) return false;
    if (!nextTokenIs(b, EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQUAL, LBRACE);
    r = r && record_field(b, l + 1);
    r = r && type_definition_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, TYPE_DEFINITION, r);
    return r;
  }

  // (COMMA record_field)*
  private static boolean type_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!type_definition_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_definition_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA record_field
  private static boolean type_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && record_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE short_id type_definition? SEMI
  public static boolean type_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && short_id(b, l + 1);
    r = r && type_statement_2(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, TYPE_STATEMENT, r);
    return r;
  }

  // type_definition?
  private static boolean type_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_statement_2")) return false;
    type_definition(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LIDENT
  public static boolean value_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_name")) return false;
    if (!nextTokenIs(b, LIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LIDENT);
    exit_section_(b, m, VALUE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // value_name
  //     | module_path DOT value_name
  public static boolean value_path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_path")) return false;
    if (!nextTokenIs(b, "<value path>", LIDENT, UIDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_PATH, "<value path>");
    r = value_name(b, l + 1);
    if (!r) r = value_path_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // module_path DOT value_name
  private static boolean value_path_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_path_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_path(b, l + 1);
    r = r && consumeToken(b, DOT);
    r = r && value_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}