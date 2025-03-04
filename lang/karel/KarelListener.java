// Generated from lang/karel/Karel.g4 by ANTLR 4.13.2


package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KarelParser}.
 */
public interface KarelListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KarelParser#dCommand}.
	 * @param ctx the parse tree
	 */
	void enterDCommand(KarelParser.DCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link KarelParser#dCommand}.
	 * @param ctx the parse tree
	 */
	void exitDCommand(KarelParser.DCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link KarelParser#dProgram}.
	 * @param ctx the parse tree
	 */
	void enterDProgram(KarelParser.DProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link KarelParser#dProgram}.
	 * @param ctx the parse tree
	 */
	void exitDProgram(KarelParser.DProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link KarelParser#dNUM}.
	 * @param ctx the parse tree
	 */
	void enterDNUM(KarelParser.DNUMContext ctx);
	/**
	 * Exit a parse tree produced by {@link KarelParser#dNUM}.
	 * @param ctx the parse tree
	 */
	void exitDNUM(KarelParser.DNUMContext ctx);
	/**
	 * Enter a parse tree produced by {@link KarelParser#dID}.
	 * @param ctx the parse tree
	 */
	void enterDID(KarelParser.DIDContext ctx);
	/**
	 * Exit a parse tree produced by {@link KarelParser#dID}.
	 * @param ctx the parse tree
	 */
	void exitDID(KarelParser.DIDContext ctx);
	/**
	 * Enter a parse tree produced by {@link KarelParser#dSTR}.
	 * @param ctx the parse tree
	 */
	void enterDSTR(KarelParser.DSTRContext ctx);
	/**
	 * Exit a parse tree produced by {@link KarelParser#dSTR}.
	 * @param ctx the parse tree
	 */
	void exitDSTR(KarelParser.DSTRContext ctx);
}