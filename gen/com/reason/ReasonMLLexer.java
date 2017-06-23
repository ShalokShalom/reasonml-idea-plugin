/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.reason;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.reason.lang.ReasonMLTypes.*;
import static com.intellij.psi.TokenType.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>ReasonML.flex</tt>
 */
public class ReasonMLLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int WAITING_VALUE = 2;
  public static final int INITIAL = 4;
  public static final int IN_STRING = 6;
  public static final int IN_COMMENT = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3,  3,  4, 4
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\101\1\1\1\103\1\3\1\2\22\0\1\101\1\0\1\52\1\72\3\0\1\6\1\64\1\65\1"+
    "\54\1\77\1\62\1\27\1\24\1\53\1\11\1\23\2\102\4\20\2\7\1\55\1\63\1\75\1\56"+
    "\1\57\1\73\1\61\1\15\1\22\2\15\1\26\1\15\7\5\1\50\1\17\1\31\2\5\1\51\4\5\1"+
    "\13\2\5\1\70\1\100\1\71\1\76\1\10\1\74\1\35\1\21\1\42\1\37\1\25\1\14\1\4\1"+
    "\47\1\41\2\4\1\36\1\32\1\40\1\16\1\30\1\4\1\44\1\45\1\34\1\33\1\4\1\46\1\12"+
    "\1\43\1\4\1\66\1\60\1\67\7\0\1\103\242\0\2\103\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\5\0\1\1\1\2\1\3\1\4\1\5\1\6\2\7"+
    "\2\4\1\10\1\4\1\11\10\4\2\5\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\2\1\41\3\40"+
    "\1\7\1\42\1\0\2\7\1\0\5\4\1\43\5\4"+
    "\1\44\2\4\1\45\3\4\2\5\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\55\1\56\1\57\1\0"+
    "\1\40\1\0\3\40\1\60\1\61\2\42\1\0\3\7"+
    "\1\62\12\4\1\63\2\4\1\64\1\4\2\5\1\65"+
    "\3\0\1\42\1\7\1\4\1\66\2\4\1\67\2\4"+
    "\1\70\1\71\1\72\1\73\2\4\1\74\1\75\1\0"+
    "\1\42\1\76\6\4\1\77\1\4\1\100\2\4\1\101"+
    "\1\4\1\102\1\103\1\104";

  private static int [] zzUnpackAction() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\104\0\210\0\314\0\u0110\0\u0154\0\u0154\0\u0198"+
    "\0\u01dc\0\u0220\0\u0154\0\u0264\0\u02a8\0\u02ec\0\u0330\0\u0154"+
    "\0\u0374\0\u03b8\0\u03fc\0\u0440\0\u0484\0\u04c8\0\u050c\0\u0550"+
    "\0\u0594\0\u05d8\0\u061c\0\u0660\0\u0154\0\u06a4\0\u06e8\0\u072c"+
    "\0\u0770\0\u0154\0\u07b4\0\u0154\0\u0154\0\u0154\0\u0154\0\u0154"+
    "\0\u0154\0\u0154\0\u0154\0\u0154\0\u0154\0\u0154\0\u0154\0\u07f8"+
    "\0\u0154\0\u083c\0\u0154\0\u0880\0\u0154\0\u08c4\0\u0908\0\u094c"+
    "\0\u0154\0\u0990\0\u09d4\0\u0a18\0\u0a5c\0\u0aa0\0\u0ae4\0\u0b28"+
    "\0\u0b6c\0\u0bb0\0\u0bf4\0\u0154\0\u0c38\0\u0c7c\0\u0cc0\0\u0d04"+
    "\0\u0d48\0\u01dc\0\u0d8c\0\u0dd0\0\u01dc\0\u0e14\0\u0e58\0\u0e9c"+
    "\0\u0ee0\0\u0f24\0\u0154\0\u0154\0\u0154\0\u0154\0\u0154\0\u0f68"+
    "\0\u0154\0\u0154\0\u0154\0\u0154\0\u0880\0\u0fac\0\u0ff0\0\u1034"+
    "\0\u1078\0\u10bc\0\u0154\0\u0154\0\u0154\0\u1100\0\u1144\0\u1188"+
    "\0\u11cc\0\u1210\0\u01dc\0\u1254\0\u1298\0\u12dc\0\u1320\0\u1364"+
    "\0\u13a8\0\u13ec\0\u1430\0\u1474\0\u14b8\0\u01dc\0\u14fc\0\u1540"+
    "\0\u01dc\0\u1584\0\u15c8\0\u160c\0\u0154\0\u1650\0\u1694\0\u16d8"+
    "\0\u171c\0\u09d4\0\u1760\0\u01dc\0\u17a4\0\u17e8\0\u01dc\0\u182c"+
    "\0\u1870\0\u01dc\0\u01dc\0\u01dc\0\u01dc\0\u18b4\0\u18f8\0\u0220"+
    "\0\u0220\0\u193c\0\u09d4\0\u01dc\0\u1980\0\u19c4\0\u1a08\0\u1a4c"+
    "\0\u1a90\0\u1ad4\0\u01dc\0\u1b18\0\u01dc\0\u1b5c\0\u1ba0\0\u01dc"+
    "\0\u1be4\0\u01dc\0\u01dc\0\u01dc";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\104\6\105\7\3\10\1\11\1\12\1\13\1\14\1\11"+
    "\1\15\1\11\1\12\1\16\1\12\1\17\1\12\1\14"+
    "\1\11\1\12\1\14\1\20\1\21\1\12\1\22\1\11"+
    "\1\12\1\23\1\24\1\25\1\26\1\27\2\11\1\30"+
    "\2\11\1\31\1\32\2\11\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\1\62\1\7\1\10\1\14\1\7"+
    "\2\63\1\64\1\7\46\63\1\65\25\63\1\66\2\63"+
    "\1\7\2\63\1\64\1\7\47\63\1\67\1\70\26\63"+
    "\1\7\105\0\3\10\75\0\1\10\6\0\20\11\1\0"+
    "\2\11\1\0\22\11\30\0\1\11\5\0\20\12\1\0"+
    "\2\12\1\0\22\12\30\0\1\12\5\0\2\71\1\0"+
    "\3\14\2\71\2\0\2\71\1\14\2\0\1\14\1\72"+
    "\2\73\1\0\5\71\1\0\1\71\1\0\2\71\1\0"+
    "\7\71\30\0\1\14\5\0\2\71\1\0\3\14\2\74"+
    "\2\0\2\75\1\14\2\76\1\14\1\72\2\73\1\0"+
    "\5\71\1\0\1\71\1\0\2\71\1\0\7\71\30\0"+
    "\1\14\5\0\20\11\1\0\2\11\1\0\3\11\1\77"+
    "\1\11\1\100\14\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\1\101\21\11\30\0\1\11\5\0\6\11"+
    "\1\102\11\11\1\0\2\11\1\0\6\11\1\103\13\11"+
    "\30\0\1\11\25\0\1\104\63\0\12\11\1\105\5\11"+
    "\1\0\2\11\1\0\3\11\1\106\16\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\10\11\1\107\11\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\13\11"+
    "\1\110\1\111\5\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\15\11\1\112\4\11\30\0\1\11\5\0"+
    "\20\11\1\0\1\113\1\11\1\0\11\11\1\114\10\11"+
    "\30\0\1\11\5\0\10\11\1\115\7\11\1\0\2\11"+
    "\1\0\10\11\1\116\11\11\30\0\1\11\5\0\20\11"+
    "\1\0\1\117\1\11\1\0\22\11\30\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\16\11\1\120\3\11\30\0"+
    "\1\11\5\0\12\12\1\121\5\12\1\0\2\12\1\0"+
    "\22\12\30\0\1\12\5\0\12\12\1\122\5\12\1\0"+
    "\2\12\1\0\22\12\30\0\1\12\25\0\1\123\27\0"+
    "\1\124\2\0\1\125\50\0\1\126\134\0\1\127\104\0"+
    "\1\130\1\131\103\0\1\132\77\0\1\133\54\0\1\134"+
    "\60\0\1\63\1\135\101\0\1\63\1\136\1\137\1\0"+
    "\3\63\1\140\1\63\1\140\1\141\3\63\1\142\1\63"+
    "\1\140\2\63\1\140\56\63\1\140\55\0\1\143\102\0"+
    "\1\144\34\0\2\145\1\0\3\72\2\145\2\0\2\145"+
    "\1\72\2\0\1\72\1\0\2\73\1\0\5\145\1\0"+
    "\1\145\1\0\2\145\1\0\7\145\30\0\1\72\10\0"+
    "\1\146\1\0\1\146\6\0\1\146\2\0\1\146\3\0"+
    "\1\147\47\0\1\147\2\0\1\146\10\0\1\150\1\0"+
    "\1\150\2\0\2\150\2\0\4\150\1\0\2\150\6\0"+
    "\1\150\1\0\1\150\2\0\1\150\37\0\1\150\12\0"+
    "\1\151\6\0\1\151\2\0\1\151\56\0\1\151\12\0"+
    "\1\152\11\0\1\152\64\0\20\11\1\0\2\11\1\0"+
    "\10\11\1\153\11\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\6\11\1\154\13\11\30\0\1\11\5\0"+
    "\20\11\1\0\1\155\1\11\1\0\4\11\1\156\15\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\4\11"+
    "\1\157\15\11\30\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\15\11\1\160\4\11\30\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\7\11\1\161\12\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\4\11\1\162\15\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\11\11"+
    "\1\163\10\11\30\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\1\164\21\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\3\11\1\165\16\11\30\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\4\11\1\166\15\11\30\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\15\11\1\167"+
    "\4\11\30\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\12\11\1\170\7\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\12\11\1\171\7\11\30\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\11\11\1\172\10\11\30\0"+
    "\1\11\5\0\20\12\1\0\2\12\1\0\10\12\1\173"+
    "\11\12\30\0\1\12\5\0\20\12\1\0\2\12\1\0"+
    "\2\12\1\174\17\12\30\0\1\12\57\0\1\175\126\0"+
    "\1\136\3\0\1\136\1\137\110\0\1\176\1\0\1\176"+
    "\6\0\1\176\2\0\1\176\56\0\1\176\10\0\1\177"+
    "\1\0\1\177\2\0\2\177\2\0\4\177\1\0\2\177"+
    "\6\0\1\177\1\0\1\177\2\0\1\177\37\0\1\177"+
    "\12\0\1\200\11\0\1\200\56\0\1\200\5\0\2\145"+
    "\1\0\3\146\2\145\2\0\2\145\1\146\2\0\1\146"+
    "\4\0\5\145\1\0\1\145\1\0\2\145\1\0\7\145"+
    "\30\0\1\146\10\0\1\146\1\0\1\146\6\0\1\146"+
    "\2\0\1\146\56\0\1\146\5\0\2\71\1\0\3\150"+
    "\2\71\2\150\2\71\4\150\1\201\2\150\1\0\2\202"+
    "\3\71\1\150\1\71\1\150\2\71\1\150\7\71\30\0"+
    "\1\150\5\0\2\71\2\0\2\151\2\71\2\0\2\71"+
    "\1\151\2\0\1\151\4\0\5\71\1\0\1\71\1\0"+
    "\2\71\1\0\7\71\30\0\1\151\5\0\2\71\2\0"+
    "\2\152\2\71\2\0\2\71\3\0\1\152\4\0\5\71"+
    "\1\0\1\71\1\0\2\71\1\0\7\71\36\0\20\11"+
    "\1\0\2\11\1\0\15\11\1\203\4\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\10\11\1\204\11\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\11\11"+
    "\1\205\10\11\30\0\1\11\5\0\20\11\1\0\1\206"+
    "\1\11\1\0\22\11\30\0\1\11\5\0\20\11\1\0"+
    "\1\207\1\11\1\0\22\11\30\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\3\11\1\210\16\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\5\11\1\211\14\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\4\11"+
    "\1\212\15\11\30\0\1\11\5\0\20\11\1\0\1\213"+
    "\1\11\1\0\22\11\30\0\1\11\5\0\20\11\1\0"+
    "\1\214\1\11\1\0\22\11\30\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\4\11\1\215\15\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\6\11\1\216\13\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\4\11"+
    "\1\217\15\11\30\0\1\11\5\0\20\12\1\0\1\220"+
    "\1\12\1\0\22\12\30\0\1\12\5\0\20\12\1\0"+
    "\1\221\1\12\1\0\22\12\30\0\1\12\10\0\1\63"+
    "\1\0\1\63\6\0\1\63\2\0\1\63\56\0\1\63"+
    "\10\0\1\63\1\0\1\63\2\0\2\63\2\0\4\63"+
    "\1\0\2\63\6\0\1\63\1\0\1\63\2\0\1\63"+
    "\37\0\1\63\12\0\1\222\6\0\1\222\2\0\1\222"+
    "\56\0\1\222\5\0\2\145\1\0\3\201\2\145\2\201"+
    "\2\145\4\201\1\0\2\201\1\0\2\223\3\145\1\201"+
    "\1\145\1\201\2\145\1\201\7\145\30\0\1\201\5\0"+
    "\20\11\1\0\1\224\1\11\1\0\22\11\30\0\1\11"+
    "\5\0\12\11\1\225\5\11\1\0\2\11\1\0\22\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\14\11"+
    "\1\226\5\11\30\0\1\11\5\0\20\11\1\0\2\11"+
    "\1\0\6\11\1\227\13\11\30\0\1\11\5\0\15\11"+
    "\1\230\2\11\1\0\2\11\1\0\22\11\30\0\1\11"+
    "\5\0\20\11\1\0\2\11\1\0\3\11\1\231\16\11"+
    "\30\0\1\11\5\0\20\11\1\0\2\11\1\0\12\11"+
    "\1\232\7\11\30\0\1\11\12\0\1\63\6\0\1\63"+
    "\2\0\1\63\56\0\1\63\5\0\20\11\1\0\2\11"+
    "\1\0\10\11\1\233\11\11\30\0\1\11\5\0\20\11"+
    "\1\0\2\11\1\0\10\11\1\234\11\11\30\0\1\11"+
    "\5\0\20\11\1\0\1\235\1\11\1\0\22\11\30\0"+
    "\1\11\5\0\20\11\1\0\2\11\1\0\6\11\1\236"+
    "\13\11\30\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\7\11\1\237\12\11\30\0\1\11\5\0\20\11\1\0"+
    "\2\11\1\0\17\11\1\240\2\11\30\0\1\11\5\0"+
    "\20\11\1\0\2\11\1\0\5\11\1\241\14\11\30\0"+
    "\1\11\5\0\20\11\1\0\1\242\1\11\1\0\22\11"+
    "\30\0\1\11\5\0\20\11\1\0\1\243\1\11\1\0"+
    "\22\11\30\0\1\11\5\0\20\11\1\0\2\11\1\0"+
    "\6\11\1\244\13\11\30\0\1\11\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7208];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\5\0\2\11\3\1\1\11\4\1\1\11\14\1\1\11"+
    "\4\1\1\11\1\1\14\11\1\1\1\11\1\1\1\11"+
    "\1\1\1\11\3\1\1\11\1\1\1\0\2\1\1\0"+
    "\5\1\1\11\16\1\5\11\1\1\4\11\1\0\1\1"+
    "\1\0\3\1\3\11\1\1\1\0\25\1\1\11\3\0"+
    "\21\1\1\0\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  private int tokenStartIndex;
  private CharSequence quotedStringId;
  private int commentDepth;

  //Store the start index of a token
  private void tokenStart() {
    tokenStartIndex = zzStartRead;
  }

  //Set the start index of the token to the stored index
  private void tokenEnd() {
    zzStartRead = tokenStartIndex;
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public ReasonMLLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        switch (zzLexicalState) {
            case IN_STRING: {
              yybegin(INITIAL); tokenEnd(); return STRING;
            }
            case 165: break;
            case IN_COMMENT: {
              yybegin(INITIAL); tokenEnd(); return COMMENT;
            }
            case 166: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yybegin(INITIAL); yypushback(1);
            }
          case 69: break;
          case 2: 
            { return BAD_CHARACTER;
            }
          case 70: break;
          case 3: 
            { return WHITE_SPACE;
            }
          case 71: break;
          case 4: 
            { return LIDENT;
            }
          case 72: break;
          case 5: 
            { return UIDENT;
            }
          case 73: break;
          case 6: 
            { return QUOTE;
            }
          case 74: break;
          case 7: 
            { return INT;
            }
          case 75: break;
          case 8: 
            { return DOT;
            }
          case 76: break;
          case 9: 
            { return MINUS;
            }
          case 77: break;
          case 10: 
            { yybegin(IN_STRING); tokenStart();
            }
          case 78: break;
          case 11: 
            { return SLASH;
            }
          case 79: break;
          case 12: 
            { return STAR;
            }
          case 80: break;
          case 13: 
            { return COLON;
            }
          case 81: break;
          case 14: 
            { return EQ;
            }
          case 82: break;
          case 15: 
            { return GT;
            }
          case 83: break;
          case 16: 
            { return PIPE;
            }
          case 84: break;
          case 17: 
            { return ARROBASE;
            }
          case 85: break;
          case 18: 
            { return COMMA;
            }
          case 86: break;
          case 19: 
            { return SEMI;
            }
          case 87: break;
          case 20: 
            { return LPAREN;
            }
          case 88: break;
          case 21: 
            { return RPAREN;
            }
          case 89: break;
          case 22: 
            { return LBRACE;
            }
          case 90: break;
          case 23: 
            { return RBRACE;
            }
          case 91: break;
          case 24: 
            { return LBRACKET;
            }
          case 92: break;
          case 25: 
            { return RBRACKET;
            }
          case 93: break;
          case 26: 
            { return SHARP;
            }
          case 94: break;
          case 27: 
            { return QUESTION_MARK;
            }
          case 95: break;
          case 28: 
            { return BACKTICK;
            }
          case 96: break;
          case 29: 
            { return LT;
            }
          case 97: break;
          case 30: 
            { return CARRET;
            }
          case 98: break;
          case 31: 
            { return PLUS;
            }
          case 99: break;
          case 32: 
            { 
            }
          case 100: break;
          case 33: 
            { yybegin(INITIAL); tokenEnd(); return STRING;
            }
          case 101: break;
          case 34: 
            { return FLOAT;
            }
          case 102: break;
          case 35: 
            { return MINUSDOT;
            }
          case 103: break;
          case 36: 
            { return AS;
            }
          case 104: break;
          case 37: 
            { return IF;
            }
          case 105: break;
          case 38: 
            { return SLASHDOT;
            }
          case 106: break;
          case 39: 
            { yybegin(IN_COMMENT); commentDepth = 1; tokenStart();
            }
          case 107: break;
          case 40: 
            { return AUTO_CLOSE_TAG;
            }
          case 108: break;
          case 41: 
            { return STARDOT;
            }
          case 109: break;
          case 42: 
            { return SHORTCUT;
            }
          case 110: break;
          case 43: 
            { return EQEQ;
            }
          case 111: break;
          case 44: 
            { return ARROW;
            }
          case 112: break;
          case 45: 
            { return PIPE_FORWARD;
            }
          case 113: break;
          case 46: 
            { return CLOSE_TAG;
            }
          case 114: break;
          case 47: 
            { return PLUSDOT;
            }
          case 115: break;
          case 48: 
            { commentDepth += 1;
            }
          case 116: break;
          case 49: 
            { commentDepth -= 1; if(commentDepth == 0) { yybegin(INITIAL); tokenEnd(); return COMMENT; }
            }
          case 117: break;
          case 50: 
            { return FUN;
            }
          case 118: break;
          case 51: 
            { return LET;
            }
          case 119: break;
          case 52: 
            { return REC;
            }
          case 120: break;
          case 53: 
            { return EQEQEQ;
            }
          case 121: break;
          case 54: 
            { return OPEN;
            }
          case 122: break;
          case 55: 
            { return ELSE;
            }
          case 123: break;
          case 56: 
            { return UNIT;
            }
          case 124: break;
          case 57: 
            { return TYPE;
            }
          case 125: break;
          case 58: 
            { return TRUE;
            }
          case 126: break;
          case 59: 
            { return LIST;
            }
          case 127: break;
          case 60: 
            { return NONE;
            }
          case 128: break;
          case 61: 
            { return SOME;
            }
          case 129: break;
          case 62: 
            { return FALSE;
            }
          case 130: break;
          case 63: 
            { return OPTION;
            }
          case 131: break;
          case 64: 
            { return MODULE;
            }
          case 132: break;
          case 65: 
            { return SWITCH;
            }
          case 133: break;
          case 66: 
            { return MUTABLE;
            }
          case 134: break;
          case 67: 
            { return INCLUDE;
            }
          case 135: break;
          case 68: 
            { return EXTERNAL;
            }
          case 136: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
