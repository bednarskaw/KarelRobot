// Generated from lang/karel/Karel.g4 by ANTLR 4.13.2


package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class KarelLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUM=7, ID=8, STR=9, WHITESPACE=10, 
		LINECOMMENT=11, COMMENT=12, ERROR=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUM", "ID", "STR", "ESC", 
			"WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'forward'", "'turn left'", "'turn right'", "'reset'", "'skip'", 
			"';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NUM", "ID", "STR", "WHITESPACE", 
			"LINECOMMENT", "COMMENT", "ERROR"
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


	public KarelLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Karel.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0004\u0006I\b"+
		"\u0006\u000b\u0006\f\u0006J\u0001\u0007\u0001\u0007\u0005\u0007O\b\u0007"+
		"\n\u0007\f\u0007R\t\u0007\u0001\b\u0001\b\u0001\b\u0005\bW\b\b\n\b\f\b"+
		"Z\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\tf\b\t\u0001\n\u0004\ni\b\n\u000b\n\f\nj\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"s\b\u000b\n\u000b\f\u000bv\t\u000b\u0001\u000b\u0003\u000by\b\u000b\u0001"+
		"\u000b\u0003\u000b|\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0005\f\u0084\b\f\n\f\f\f\u0087\t\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0003Xt\u0085\u0000\u000e\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\u0000\u0015\n\u0017\u000b\u0019\f\u001b\r\u0001\u0000"+
		"\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t"+
		"\n\f\r  \u0001\u0001\n\n\u0098\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0015\u0001"+
		"\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001"+
		"\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001d\u0001"+
		"\u0000\u0000\u0000\u0003%\u0001\u0000\u0000\u0000\u0005/\u0001\u0000\u0000"+
		"\u0000\u0007:\u0001\u0000\u0000\u0000\t@\u0001\u0000\u0000\u0000\u000b"+
		"E\u0001\u0000\u0000\u0000\rH\u0001\u0000\u0000\u0000\u000fL\u0001\u0000"+
		"\u0000\u0000\u0011S\u0001\u0000\u0000\u0000\u0013e\u0001\u0000\u0000\u0000"+
		"\u0015h\u0001\u0000\u0000\u0000\u0017n\u0001\u0000\u0000\u0000\u0019\u007f"+
		"\u0001\u0000\u0000\u0000\u001b\u008d\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005f\u0000\u0000\u001e\u001f\u0005o\u0000\u0000\u001f \u0005r\u0000"+
		"\u0000 !\u0005w\u0000\u0000!\"\u0005a\u0000\u0000\"#\u0005r\u0000\u0000"+
		"#$\u0005d\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005t\u0000\u0000"+
		"&\'\u0005u\u0000\u0000\'(\u0005r\u0000\u0000()\u0005n\u0000\u0000)*\u0005"+
		" \u0000\u0000*+\u0005l\u0000\u0000+,\u0005e\u0000\u0000,-\u0005f\u0000"+
		"\u0000-.\u0005t\u0000\u0000.\u0004\u0001\u0000\u0000\u0000/0\u0005t\u0000"+
		"\u000001\u0005u\u0000\u000012\u0005r\u0000\u000023\u0005n\u0000\u0000"+
		"34\u0005 \u0000\u000045\u0005r\u0000\u000056\u0005i\u0000\u000067\u0005"+
		"g\u0000\u000078\u0005h\u0000\u000089\u0005t\u0000\u00009\u0006\u0001\u0000"+
		"\u0000\u0000:;\u0005r\u0000\u0000;<\u0005e\u0000\u0000<=\u0005s\u0000"+
		"\u0000=>\u0005e\u0000\u0000>?\u0005t\u0000\u0000?\b\u0001\u0000\u0000"+
		"\u0000@A\u0005s\u0000\u0000AB\u0005k\u0000\u0000BC\u0005i\u0000\u0000"+
		"CD\u0005p\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005;\u0000\u0000"+
		"F\f\u0001\u0000\u0000\u0000GI\u0007\u0000\u0000\u0000HG\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000K\u000e\u0001\u0000\u0000\u0000LP\u0007\u0001\u0000\u0000"+
		"MO\u0007\u0002\u0000\u0000NM\u0001\u0000\u0000\u0000OR\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000Q\u0010\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000SX\u0005\"\u0000\u0000TW\u0003"+
		"\u0013\t\u0000UW\t\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VU\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"XV\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[\\\u0005\"\u0000\u0000\\\u0012\u0001\u0000\u0000\u0000]^\u0005"+
		"\\\u0000\u0000^f\u0005\"\u0000\u0000_`\u0005\\\u0000\u0000`f\u0005n\u0000"+
		"\u0000ab\u0005\\\u0000\u0000bf\u0005%\u0000\u0000cd\u0005\\\u0000\u0000"+
		"df\u0005\\\u0000\u0000e]\u0001\u0000\u0000\u0000e_\u0001\u0000\u0000\u0000"+
		"ea\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000f\u0014\u0001\u0000"+
		"\u0000\u0000gi\u0007\u0003\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001"+
		"\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"kl\u0001\u0000\u0000\u0000lm\u0006\n\u0000\u0000m\u0016\u0001\u0000\u0000"+
		"\u0000no\u0005/\u0000\u0000op\u0005/\u0000\u0000pt\u0001\u0000\u0000\u0000"+
		"qs\t\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000"+
		"\u0000vt\u0001\u0000\u0000\u0000wy\u0005\r\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000z|\u0007\u0004"+
		"\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0006"+
		"\u000b\u0000\u0000~\u0018\u0001\u0000\u0000\u0000\u007f\u0080\u0005/\u0000"+
		"\u0000\u0080\u0081\u0005*\u0000\u0000\u0081\u0085\u0001\u0000\u0000\u0000"+
		"\u0082\u0084\t\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0087\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0088\u0089\u0005*\u0000\u0000\u0089\u008a"+
		"\u0005/\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0006"+
		"\f\u0000\u0000\u008c\u001a\u0001\u0000\u0000\u0000\u008d\u008e\t\u0000"+
		"\u0000\u0000\u008e\u001c\u0001\u0000\u0000\u0000\u000b\u0000JPVXejtx{"+
		"\u0085\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}