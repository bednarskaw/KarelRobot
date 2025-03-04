// Generated from lang/karel/Karel.g4 by ANTLR 4.13.2


package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUM=9, 
		ID=10, STR=11, WHITESPACE=12, LINECOMMENT=13, COMMENT=14, ERROR=15;
	public static final int
		RULE_dCommand = 0, RULE_dProgram = 1, RULE_dNUM = 2, RULE_dID = 3, RULE_dSTR = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"dCommand", "dProgram", "dNUM", "dID", "dSTR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'forward'", "'turn left'", "'turn right'", "'reset'", "'skip'", 
			"'putbeeper'", "'pickbeeper'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "NUM", "ID", "STR", 
			"WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
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
	public static class DCommandContext extends ParserRuleContext {
		public Command _result;
		public DCommandContext c1;
		public DNUMContext n;
		public DCommandContext c2;
		public DNUMContext dNUM() {
			return getRuleContext(DNUMContext.class,0);
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
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_dCommand, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(11);
				match(T__0);
				setState(12);
				((DCommandContext)_localctx).n = dNUM();
				 ((DCommandContext)_localctx)._result =  new Command.Forward(((DCommandContext)_localctx).n._result); 
				}
				break;
			case 2:
				{
				setState(15);
				match(T__0);
				 ((DCommandContext)_localctx)._result =  new Command.ForwardDefault(); 
				}
				break;
			case 3:
				{
				setState(17);
				match(T__1);
				 ((DCommandContext)_localctx)._result =  new Command.TurnLeft(); 
				}
				break;
			case 4:
				{
				setState(19);
				match(T__2);
				 ((DCommandContext)_localctx)._result =  new Command.TurnRight(); 
				}
				break;
			case 5:
				{
				setState(21);
				match(T__3);
				 ((DCommandContext)_localctx)._result =  new Command.Reset(); 
				}
				break;
			case 6:
				{
				setState(23);
				match(T__4);
				 ((DCommandContext)_localctx)._result =  new Command.Skip(); 
				}
				break;
			case 7:
				{
				setState(25);
				match(T__5);
				 ((DCommandContext)_localctx)._result =  new Command.PutBeeper(); 
				}
				break;
			case 8:
				{
				setState(27);
				match(T__6);
				 ((DCommandContext)_localctx)._result =  new Command.PickBeeper(); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
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
					setState(31);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(32);
					match(T__7);
					setState(33);
					((DCommandContext)_localctx).c2 = dCommand(2);
					 ((DCommandContext)_localctx)._result =  new Command.Seq(((DCommandContext)_localctx).c1._result, ((DCommandContext)_localctx).c2._result); 
					}
					} 
				}
				setState(40);
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
		enterRule(_localctx, 2, RULE_dProgram);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			((DProgramContext)_localctx).c = dCommand(0);
			setState(46);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(42);
					match(T__7);
					setState(43);
					((DProgramContext)_localctx).c2 = dCommand(0);
					}
					} 
				}
				setState(48);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(49);
				match(T__7);
				}
			}

			setState(52);
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
		enterRule(_localctx, 4, RULE_dNUM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
		enterRule(_localctx, 6, RULE_dID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
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
		enterRule(_localctx, 8, RULE_dSTR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
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
		case 0:
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
		"\u0004\u0001\u000fA\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u0000\u001e\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0005\u0000%\b\u0000\n\u0000\f\u0000(\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t"+
		"\u0001\u0001\u0001\u0003\u00013\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0000\u0001\u0000"+
		"\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000E\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0002)\u0001\u0000\u0000\u0000\u00047\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b=\u0001\u0000\u0000\u0000\n\u000b\u0006"+
		"\u0000\uffff\uffff\u0000\u000b\f\u0005\u0001\u0000\u0000\f\r\u0003\u0004"+
		"\u0002\u0000\r\u000e\u0006\u0000\uffff\uffff\u0000\u000e\u001e\u0001\u0000"+
		"\u0000\u0000\u000f\u0010\u0005\u0001\u0000\u0000\u0010\u001e\u0006\u0000"+
		"\uffff\uffff\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u001e\u0006"+
		"\u0000\uffff\uffff\u0000\u0013\u0014\u0005\u0003\u0000\u0000\u0014\u001e"+
		"\u0006\u0000\uffff\uffff\u0000\u0015\u0016\u0005\u0004\u0000\u0000\u0016"+
		"\u001e\u0006\u0000\uffff\uffff\u0000\u0017\u0018\u0005\u0005\u0000\u0000"+
		"\u0018\u001e\u0006\u0000\uffff\uffff\u0000\u0019\u001a\u0005\u0006\u0000"+
		"\u0000\u001a\u001e\u0006\u0000\uffff\uffff\u0000\u001b\u001c\u0005\u0007"+
		"\u0000\u0000\u001c\u001e\u0006\u0000\uffff\uffff\u0000\u001d\n\u0001\u0000"+
		"\u0000\u0000\u001d\u000f\u0001\u0000\u0000\u0000\u001d\u0011\u0001\u0000"+
		"\u0000\u0000\u001d\u0013\u0001\u0000\u0000\u0000\u001d\u0015\u0001\u0000"+
		"\u0000\u0000\u001d\u0017\u0001\u0000\u0000\u0000\u001d\u0019\u0001\u0000"+
		"\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001e&\u0001\u0000\u0000"+
		"\u0000\u001f \n\u0001\u0000\u0000 !\u0005\b\u0000\u0000!\"\u0003\u0000"+
		"\u0000\u0002\"#\u0006\u0000\uffff\uffff\u0000#%\u0001\u0000\u0000\u0000"+
		"$\u001f\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000"+
		"\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0001\u0001\u0000\u0000\u0000"+
		"(&\u0001\u0000\u0000\u0000).\u0003\u0000\u0000\u0000*+\u0005\b\u0000\u0000"+
		"+-\u0003\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/2\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000013\u0005\b\u0000\u000021\u0001\u0000"+
		"\u0000\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0005"+
		"\u0000\u0000\u000156\u0006\u0001\uffff\uffff\u00006\u0003\u0001\u0000"+
		"\u0000\u000078\u0005\t\u0000\u000089\u0006\u0002\uffff\uffff\u00009\u0005"+
		"\u0001\u0000\u0000\u0000:;\u0005\n\u0000\u0000;<\u0006\u0003\uffff\uffff"+
		"\u0000<\u0007\u0001\u0000\u0000\u0000=>\u0005\u000b\u0000\u0000>?\u0006"+
		"\u0004\uffff\uffff\u0000?\t\u0001\u0000\u0000\u0000\u0004\u001d&.2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}