// Generated from lang/karel/Karel.g4 by ANTLR 4.13.2


package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KarelParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, NUM=23, ID=24, STR=25, 
		WHITESPACE=26, LINECOMMENT=27, COMMENT=28, ERROR=29;
	public static final int
		RULE_dNumber = 0, RULE_dCondition = 1, RULE_dCommand = 2, RULE_dProgram = 3, 
		RULE_dNUM = 4, RULE_dID = 5, RULE_dSTR = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"dNumber", "dCondition", "dCommand", "dProgram", "dNUM", "dID", "dSTR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'front-is-clear'", "'front-is-blocked'", "'left-is-clear'", "'left-is-blocked'", 
			"'right-is-clear'", "'right-is-blocked'", "'back-is-clear'", "'back-is-blocked'", 
			"'forward'", "'turn'", "'left'", "'right'", "'pickbeeper'", "'putbeeper'", 
			"'reset'", "'skip'", "';'", "'if'", "'then'", "'else'", "'while'", "'do'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "NUM", 
			"ID", "STR", "WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Karel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KarelParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DNumberContext extends ParserRuleContext {
		public Number _result;
		public DNUMContext n;
		public DNUMContext dNUM() {
			return getRuleContext(DNUMContext.class,0);
		}
		public DNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDNumber(this);
		}
	}

	public final DNumberContext dNumber() throws RecognitionException {
		DNumberContext _localctx = new DNumberContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			((DNumberContext)_localctx).n = dNUM();
			 ((DNumberContext)_localctx)._result =  new Number.Num(((DNumberContext)_localctx).n._result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DConditionContext extends ParserRuleContext {
		public Condition _result;
		public DConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDCondition(this);
		}
	}

	public final DConditionContext dCondition() throws RecognitionException {
		DConditionContext _localctx = new DConditionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dCondition);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(T__0);
				 ((DConditionContext)_localctx)._result =  new Condition.FrontIsClear(); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				match(T__1);
				 ((DConditionContext)_localctx)._result =  new Condition.FrontIsBlocked(); 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(21);
				match(T__2);
				 ((DConditionContext)_localctx)._result =  new Condition.LeftIsClear(); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(23);
				match(T__3);
				 ((DConditionContext)_localctx)._result =  new Condition.LeftIsBlocked(); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(25);
				match(T__4);
				 ((DConditionContext)_localctx)._result =  new Condition.RightIsClear(); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 6);
				{
				setState(27);
				match(T__5);
				 ((DConditionContext)_localctx)._result =  new Condition.RightIsBlocked(); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 7);
				{
				setState(29);
				match(T__6);
				 ((DConditionContext)_localctx)._result =  new Condition.BackIsClear(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 8);
				{
				setState(31);
				match(T__7);
				 ((DConditionContext)_localctx)._result =  new Condition.BackIsBlocked(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DCommandContext extends ParserRuleContext {
		public Command _result;
		public DCommandContext c1;
		public DNumberContext n;
		public DConditionContext b;
		public DCommandContext c2;
		public DCommandContext c;
		public DNumberContext dNumber() {
			return getRuleContext(DNumberContext.class,0);
		}
		public DConditionContext dCondition() {
			return getRuleContext(DConditionContext.class,0);
		}
		public List<DCommandContext> dCommand() {
			return getRuleContexts(DCommandContext.class);
		}
		public DCommandContext dCommand(int i) {
			return getRuleContext(DCommandContext.class,i);
		}
		public DCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDCommand(this);
		}
	}

	public final DCommandContext dCommand() throws RecognitionException {
		return dCommand(0);
	}

	private DCommandContext dCommand(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DCommandContext _localctx = new DCommandContext(_ctx, _parentState);
		DCommandContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_dCommand, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(36);
				match(T__8);
				 ((DCommandContext)_localctx)._result =  new Command.Forward(); 
				}
				break;
			case 2:
				{
				setState(38);
				match(T__8);
				setState(39);
				((DCommandContext)_localctx).n = dNumber();
				 ((DCommandContext)_localctx)._result =  new Command.ForwardN(((DCommandContext)_localctx).n._result); 
				}
				break;
			case 3:
				{
				setState(42);
				match(T__9);
				setState(43);
				match(T__10);
				 ((DCommandContext)_localctx)._result =  new Command.TurnLeft(); 
				}
				break;
			case 4:
				{
				setState(45);
				match(T__9);
				setState(46);
				match(T__11);
				 ((DCommandContext)_localctx)._result =  new Command.TurnRight(); 
				}
				break;
			case 5:
				{
				setState(48);
				match(T__12);
				 ((DCommandContext)_localctx)._result =  new Command.PickBeeper(); 
				}
				break;
			case 6:
				{
				setState(50);
				match(T__13);
				 ((DCommandContext)_localctx)._result =  new Command.PutBeeper(); 
				}
				break;
			case 7:
				{
				setState(52);
				match(T__14);
				 ((DCommandContext)_localctx)._result =  new Command.Reset(); 
				}
				break;
			case 8:
				{
				setState(54);
				match(T__15);
				 ((DCommandContext)_localctx)._result =  new Command.Skip(); 
				}
				break;
			case 9:
				{
				setState(56);
				match(T__17);
				setState(57);
				((DCommandContext)_localctx).b = dCondition();
				setState(58);
				match(T__18);
				setState(59);
				((DCommandContext)_localctx).c1 = dCommand(0);
				setState(60);
				match(T__19);
				setState(61);
				((DCommandContext)_localctx).c2 = dCommand(2);
				 ((DCommandContext)_localctx)._result =  new Command.IfElse(((DCommandContext)_localctx).b._result, ((DCommandContext)_localctx).c1._result, ((DCommandContext)_localctx).c2._result); 
				}
				break;
			case 10:
				{
				setState(64);
				match(T__20);
				setState(65);
				((DCommandContext)_localctx).b = dCondition();
				setState(66);
				match(T__21);
				setState(67);
				((DCommandContext)_localctx).c = dCommand(1);
				 ((DCommandContext)_localctx)._result =  new Command.While(((DCommandContext)_localctx).b._result, ((DCommandContext)_localctx).c._result); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(79);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DCommandContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_dCommand);
					setState(72);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(73);
					match(T__16);
					setState(74);
					((DCommandContext)_localctx).c2 = dCommand(4);
					 ((DCommandContext)_localctx)._result =  new Command.Seq(((DCommandContext)_localctx).c1._result, ((DCommandContext)_localctx).c2._result); 
					}
					} 
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DProgramContext extends ParserRuleContext {
		public Program _result;
		public DCommandContext c;
		public DCommandContext c2;
		public TerminalNode EOF() { return getToken(KarelParser.EOF, 0); }
		public List<DCommandContext> dCommand() {
			return getRuleContexts(DCommandContext.class);
		}
		public DCommandContext dCommand(int i) {
			return getRuleContext(DCommandContext.class,i);
		}
		public DProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDProgram(this);
		}
	}

	public final DProgramContext dProgram() throws RecognitionException {
		DProgramContext _localctx = new DProgramContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dProgram);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			((DProgramContext)_localctx).c = dCommand(0);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(83);
					match(T__16);
					setState(84);
					((DProgramContext)_localctx).c2 = dCommand(0);
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(90);
				match(T__16);
				}
			}

			setState(93);
			match(EOF);
			 ((DProgramContext)_localctx)._result =  new Program.Prog(((DProgramContext)_localctx).c._result); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DNUMContext extends ParserRuleContext {
		public String _result;
		public Token n;
		public TerminalNode NUM() { return getToken(KarelParser.NUM, 0); }
		public DNUMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dNUM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDNUM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDNUM(this);
		}
	}

	public final DNUMContext dNUM() throws RecognitionException {
		DNUMContext _localctx = new DNUMContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dNUM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			((DNUMContext)_localctx).n = match(NUM);
			 ((DNUMContext)_localctx)._result =  (((DNUMContext)_localctx).n!=null?((DNUMContext)_localctx).n.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DIDContext extends ParserRuleContext {
		public String _result;
		public Token i;
		public TerminalNode ID() { return getToken(KarelParser.ID, 0); }
		public DIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDID(this);
		}
	}

	public final DIDContext dID() throws RecognitionException {
		DIDContext _localctx = new DIDContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((DIDContext)_localctx).i = match(ID);
			 ((DIDContext)_localctx)._result =  (((DIDContext)_localctx).i!=null?((DIDContext)_localctx).i.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DSTRContext extends ParserRuleContext {
		public String _result;
		public Token s;
		public TerminalNode STR() { return getToken(KarelParser.STR, 0); }
		public DSTRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dSTR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).enterDSTR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KarelListener ) ((KarelListener)listener).exitDSTR(this);
		}
	}

	public final DSTRContext dSTR() throws RecognitionException {
		DSTRContext _localctx = new DSTRContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dSTR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((DSTRContext)_localctx).s = match(STR);
			 ((DSTRContext)_localctx)._result =  (((DSTRContext)_localctx).s!=null?((DSTRContext)_localctx).s.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return dCommand_sempred((DCommandContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dCommand_sempred(DCommandContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001dj\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\"\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002G\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002N\b\u0002\n\u0002\f\u0002Q\t\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003V\b\u0003\n\u0003\f\u0003Y\t\u0003\u0001"+
		"\u0003\u0003\u0003\\\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0001\u0004\u0007\u0000"+
		"\u0002\u0004\u0006\b\n\f\u0000\u0000u\u0000\u000e\u0001\u0000\u0000\u0000"+
		"\u0002!\u0001\u0000\u0000\u0000\u0004F\u0001\u0000\u0000\u0000\u0006R"+
		"\u0001\u0000\u0000\u0000\b`\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000"+
		"\u0000\ff\u0001\u0000\u0000\u0000\u000e\u000f\u0003\b\u0004\u0000\u000f"+
		"\u0010\u0006\u0000\uffff\uffff\u0000\u0010\u0001\u0001\u0000\u0000\u0000"+
		"\u0011\u0012\u0005\u0001\u0000\u0000\u0012\"\u0006\u0001\uffff\uffff\u0000"+
		"\u0013\u0014\u0005\u0002\u0000\u0000\u0014\"\u0006\u0001\uffff\uffff\u0000"+
		"\u0015\u0016\u0005\u0003\u0000\u0000\u0016\"\u0006\u0001\uffff\uffff\u0000"+
		"\u0017\u0018\u0005\u0004\u0000\u0000\u0018\"\u0006\u0001\uffff\uffff\u0000"+
		"\u0019\u001a\u0005\u0005\u0000\u0000\u001a\"\u0006\u0001\uffff\uffff\u0000"+
		"\u001b\u001c\u0005\u0006\u0000\u0000\u001c\"\u0006\u0001\uffff\uffff\u0000"+
		"\u001d\u001e\u0005\u0007\u0000\u0000\u001e\"\u0006\u0001\uffff\uffff\u0000"+
		"\u001f \u0005\b\u0000\u0000 \"\u0006\u0001\uffff\uffff\u0000!\u0011\u0001"+
		"\u0000\u0000\u0000!\u0013\u0001\u0000\u0000\u0000!\u0015\u0001\u0000\u0000"+
		"\u0000!\u0017\u0001\u0000\u0000\u0000!\u0019\u0001\u0000\u0000\u0000!"+
		"\u001b\u0001\u0000\u0000\u0000!\u001d\u0001\u0000\u0000\u0000!\u001f\u0001"+
		"\u0000\u0000\u0000\"\u0003\u0001\u0000\u0000\u0000#$\u0006\u0002\uffff"+
		"\uffff\u0000$%\u0005\t\u0000\u0000%G\u0006\u0002\uffff\uffff\u0000&\'"+
		"\u0005\t\u0000\u0000\'(\u0003\u0000\u0000\u0000()\u0006\u0002\uffff\uffff"+
		"\u0000)G\u0001\u0000\u0000\u0000*+\u0005\n\u0000\u0000+,\u0005\u000b\u0000"+
		"\u0000,G\u0006\u0002\uffff\uffff\u0000-.\u0005\n\u0000\u0000./\u0005\f"+
		"\u0000\u0000/G\u0006\u0002\uffff\uffff\u000001\u0005\r\u0000\u00001G\u0006"+
		"\u0002\uffff\uffff\u000023\u0005\u000e\u0000\u00003G\u0006\u0002\uffff"+
		"\uffff\u000045\u0005\u000f\u0000\u00005G\u0006\u0002\uffff\uffff\u0000"+
		"67\u0005\u0010\u0000\u00007G\u0006\u0002\uffff\uffff\u000089\u0005\u0012"+
		"\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0005\u0013\u0000\u0000;<\u0003"+
		"\u0004\u0002\u0000<=\u0005\u0014\u0000\u0000=>\u0003\u0004\u0002\u0002"+
		">?\u0006\u0002\uffff\uffff\u0000?G\u0001\u0000\u0000\u0000@A\u0005\u0015"+
		"\u0000\u0000AB\u0003\u0002\u0001\u0000BC\u0005\u0016\u0000\u0000CD\u0003"+
		"\u0004\u0002\u0001DE\u0006\u0002\uffff\uffff\u0000EG\u0001\u0000\u0000"+
		"\u0000F#\u0001\u0000\u0000\u0000F&\u0001\u0000\u0000\u0000F*\u0001\u0000"+
		"\u0000\u0000F-\u0001\u0000\u0000\u0000F0\u0001\u0000\u0000\u0000F2\u0001"+
		"\u0000\u0000\u0000F4\u0001\u0000\u0000\u0000F6\u0001\u0000\u0000\u0000"+
		"F8\u0001\u0000\u0000\u0000F@\u0001\u0000\u0000\u0000GO\u0001\u0000\u0000"+
		"\u0000HI\n\u0003\u0000\u0000IJ\u0005\u0011\u0000\u0000JK\u0003\u0004\u0002"+
		"\u0004KL\u0006\u0002\uffff\uffff\u0000LN\u0001\u0000\u0000\u0000MH\u0001"+
		"\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000P\u0005\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000RW\u0003\u0004\u0002\u0000ST\u0005\u0011\u0000\u0000TV\u0003"+
		"\u0004\u0002\u0000US\u0001\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000"+
		"WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000"+
		"\u0000YW\u0001\u0000\u0000\u0000Z\\\u0005\u0011\u0000\u0000[Z\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0005"+
		"\u0000\u0000\u0001^_\u0006\u0003\uffff\uffff\u0000_\u0007\u0001\u0000"+
		"\u0000\u0000`a\u0005\u0017\u0000\u0000ab\u0006\u0004\uffff\uffff\u0000"+
		"b\t\u0001\u0000\u0000\u0000cd\u0005\u0018\u0000\u0000de\u0006\u0005\uffff"+
		"\uffff\u0000e\u000b\u0001\u0000\u0000\u0000fg\u0005\u0019\u0000\u0000"+
		"gh\u0006\u0006\uffff\uffff\u0000h\r\u0001\u0000\u0000\u0000\u0005!FOW"+
		"[";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}