
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package grammar;

import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class TinyJavaParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return Token.class;
}

  /** Default constructor. */
  @Deprecated
  public TinyJavaParser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public TinyJavaParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public TinyJavaParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\002\000\002\002\003\000\002\002\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\004\000\004\020\004\001\002\000\004\002\001\001" +
    "\002\000\004\002\006\001\002\000\004\002\000\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\004\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$TinyJavaParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$TinyJavaParser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$TinyJavaParser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public TinyJavaParser(TinyJavaLexer lexer, ComplexSymbolFactory symbolFactory) {
        super(lexer, symbolFactory);
    }

    public static void main(String[] args) throws Exception {

    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$TinyJavaParser$actions {
  private final TinyJavaParser parser;

  /** Constructor */
  CUP$TinyJavaParser$actions(TinyJavaParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$TinyJavaParser$do_action_part00000000(
    int                        CUP$TinyJavaParser$act_num,
    java_cup.runtime.lr_parser CUP$TinyJavaParser$parser,
    java.util.Stack            CUP$TinyJavaParser$stack,
    int                        CUP$TinyJavaParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$TinyJavaParser$result;

      /* select the action based on the action number */
      switch (CUP$TinyJavaParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // tiny_java_program ::= SEMICOLON 
            {
              Object RESULT =null;

              CUP$TinyJavaParser$result = parser.getSymbolFactory().newSymbol("tiny_java_program",0, ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.peek()), RESULT);
            }
          return CUP$TinyJavaParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= tiny_java_program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.elementAt(CUP$TinyJavaParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.elementAt(CUP$TinyJavaParser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$TinyJavaParser$stack.elementAt(CUP$TinyJavaParser$top-1)).value;
		RESULT = start_val;
              CUP$TinyJavaParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.elementAt(CUP$TinyJavaParser$top-1)), ((java_cup.runtime.Symbol)CUP$TinyJavaParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$TinyJavaParser$parser.done_parsing();
          return CUP$TinyJavaParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$TinyJavaParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$TinyJavaParser$do_action(
    int                        CUP$TinyJavaParser$act_num,
    java_cup.runtime.lr_parser CUP$TinyJavaParser$parser,
    java.util.Stack            CUP$TinyJavaParser$stack,
    int                        CUP$TinyJavaParser$top)
    throws java.lang.Exception
    {
              return CUP$TinyJavaParser$do_action_part00000000(
                               CUP$TinyJavaParser$act_num,
                               CUP$TinyJavaParser$parser,
                               CUP$TinyJavaParser$stack,
                               CUP$TinyJavaParser$top);
    }
}

}
