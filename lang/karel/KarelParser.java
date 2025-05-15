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
		NUM=10, ID=11, STR=12, WHITESPACE=13, LINECOMMENT=14, COMMENT=15, ERROR=16;
	public static final int
		RULE_dNumber = 0, RULE_dCommand = 1, RULE_dProgram = 2, RULE_dNUM = 3, 
		RULE_dID = 4, RULE_dSTR = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"dNumber", "dCommand", "dProgram", "dNUM", "dID", "dSTR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'forward'", "'turn'", "'left'", "'right'", "'pickbeeper'", "'putbeeper'", 
			"'reset'", "'skip'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "NUM", "ID", 
			"STR", "WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
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
			setState(12);
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
	public static class DCommandContext extends ParserRuleContext {
		public Command _result;
		public DCommandContext c1;
		public DNumberContext n;
		public DCommandContext c2;
		public DNumberContext dNumber() {
			return getRuleContext(DNumberContext.class,0);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_dCommand, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(16);
				match(T__0);
				 ((DCommandContext)_localctx)._result =  new Command.Forward(); 
				}
				break;
			case 2:
				{
				setState(18);
				match(T__0);
				setState(19);
				((DCommandContext)_localctx).n = dNumber();
				 ((DCommandContext)_localctx)._result =  new Command.ForwardN(((DCommandContext)_localctx).n._result); 
				}
				break;
			case 3:
				{
				setState(22);
				match(T__1);
				setState(23);
				match(T__2);
				 ((DCommandContext)_localctx)._result =  new Command.TurnLeft(); 
				}
				break;
			case 4:
				{
				setState(25);
				match(T__1);
				setState(26);
				match(T__3);
				 ((DCommandContext)_localctx)._result =  new Command.TurnRight(); 
				}
				break;
			case 5:
				{
				setState(28);
				match(T__4);
				 ((DCommandContext)_localctx)._result =  new Command.PickBeeper(); 
				}
				break;
			case 6:
				{
				setState(30);
				match(T__5);
				 ((DCommandContext)_localctx)._result =  new Command.PutBeeper(); 
				}
				break;
			case 7:
				{
				setState(32);
				match(T__6);
				 ((DCommandContext)_localctx)._result =  new Command.Reset(); 
				}
				break;
			case 8:
				{
				setState(34);
				match(T__7);
				 ((DCommandContext)_localctx)._result =  new Command.Skip(); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DCommandContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_dCommand);
					setState(38);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(39);
					match(T__8);
					setState(40);
					((DCommandContext)_localctx).c2 = dCommand(2);
					 ((DCommandContext)_localctx)._result =  new Command.Seq(((DCommandContext)_localctx).c1._result, ((DCommandContext)_localctx).c2._result); 
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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
		enterRule(_localctx, 4, RULE_dProgram);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			((DProgramContext)_localctx).c = dCommand(0);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(49);
					match(T__8);
					setState(50);
					((DProgramContext)_localctx).c2 = dCommand(0);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(56);
				match(T__8);
				}
			}

			setState(59);
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
		enterRule(_localctx, 6, RULE_dNUM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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
		enterRule(_localctx, 8, RULE_dID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
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
		enterRule(_localctx, 10, RULE_dSTR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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
		case 1:
			return dCommand_sempred((DCommandContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dCommand_sempred(DCommandContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0010H\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001%\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001,\b\u0001\n\u0001\f\u0001/\t"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00024\b\u0002\n\u0002"+
		"\f\u00027\t\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0000\u0001"+
		"\u0002\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0000K\u0000\f\u0001\u0000"+
		"\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000"+
		"\u0006>\u0001\u0000\u0000\u0000\bA\u0001\u0000\u0000\u0000\nD\u0001\u0000"+
		"\u0000\u0000\f\r\u0003\u0006\u0003\u0000\r\u000e\u0006\u0000\uffff\uffff"+
		"\u0000\u000e\u0001\u0001\u0000\u0000\u0000\u000f\u0010\u0006\u0001\uffff"+
		"\uffff\u0000\u0010\u0011\u0005\u0001\u0000\u0000\u0011%\u0006\u0001\uffff"+
		"\uffff\u0000\u0012\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0003\u0000"+
		"\u0000\u0000\u0014\u0015\u0006\u0001\uffff\uffff\u0000\u0015%\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0005\u0002\u0000\u0000\u0017\u0018\u0005\u0003"+
		"\u0000\u0000\u0018%\u0006\u0001\uffff\uffff\u0000\u0019\u001a\u0005\u0002"+
		"\u0000\u0000\u001a\u001b\u0005\u0004\u0000\u0000\u001b%\u0006\u0001\uffff"+
		"\uffff\u0000\u001c\u001d\u0005\u0005\u0000\u0000\u001d%\u0006\u0001\uffff"+
		"\uffff\u0000\u001e\u001f\u0005\u0006\u0000\u0000\u001f%\u0006\u0001\uffff"+
		"\uffff\u0000 !\u0005\u0007\u0000\u0000!%\u0006\u0001\uffff\uffff\u0000"+
		"\"#\u0005\b\u0000\u0000#%\u0006\u0001\uffff\uffff\u0000$\u000f\u0001\u0000"+
		"\u0000\u0000$\u0012\u0001\u0000\u0000\u0000$\u0016\u0001\u0000\u0000\u0000"+
		"$\u0019\u0001\u0000\u0000\u0000$\u001c\u0001\u0000\u0000\u0000$\u001e"+
		"\u0001\u0000\u0000\u0000$ \u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000"+
		"\u0000%-\u0001\u0000\u0000\u0000&\'\n\u0001\u0000\u0000\'(\u0005\t\u0000"+
		"\u0000()\u0003\u0002\u0001\u0002)*\u0006\u0001\uffff\uffff\u0000*,\u0001"+
		"\u0000\u0000\u0000+&\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\u0003\u0001\u0000"+
		"\u0000\u0000/-\u0001\u0000\u0000\u000005\u0003\u0002\u0001\u000012\u0005"+
		"\t\u0000\u000024\u0003\u0002\u0001\u000031\u0001\u0000\u0000\u000047\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"69\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008:\u0005\t\u0000\u0000"+
		"98\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;<\u0005\u0000\u0000\u0001<=\u0006\u0002\uffff\uffff\u0000=\u0005"+
		"\u0001\u0000\u0000\u0000>?\u0005\n\u0000\u0000?@\u0006\u0003\uffff\uffff"+
		"\u0000@\u0007\u0001\u0000\u0000\u0000AB\u0005\u000b\u0000\u0000BC\u0006"+
		"\u0004\uffff\uffff\u0000C\t\u0001\u0000\u0000\u0000DE\u0005\f\u0000\u0000"+
		"EF\u0006\u0005\uffff\uffff\u0000F\u000b\u0001\u0000\u0000\u0000\u0004"+
		"$-59";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}