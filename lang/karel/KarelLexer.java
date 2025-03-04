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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, NUM=9, 
		ID=10, STR=11, WHITESPACE=12, LINECOMMENT=13, COMMENT=14, ERROR=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "NUM", 
			"ID", "STR", "ESC", "WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
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
		"\u0004\u0000\u000f\u00a8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0004"+
		"\bb\b\b\u000b\b\f\bc\u0001\t\u0001\t\u0005\th\b\t\n\t\f\tk\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0005\np\b\n\n\n\f\ns\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u007f\b\u000b\u0001\f\u0004\f\u0082\b\f\u000b"+
		"\f\f\f\u0083\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u008c"+
		"\b\r\n\r\f\r\u008f\t\r\u0001\r\u0003\r\u0092\b\r\u0001\r\u0003\r\u0095"+
		"\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u009d\b\u000e\n\u000e\f\u000e\u00a0\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003q\u008d"+
		"\u009e\u0000\u0010\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\u0000\u0019"+
		"\f\u001b\r\u001d\u000e\u001f\u000f\u0001\u0000\u0005\u0001\u000009\u0002"+
		"\u0000AZaz\u0004\u000009AZ__az\u0003\u0000\t\n\f\r  \u0001\u0001\n\n\u00b1"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003)\u0001\u0000"+
		"\u0000\u0000\u00053\u0001\u0000\u0000\u0000\u0007>\u0001\u0000\u0000\u0000"+
		"\tD\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rS\u0001\u0000"+
		"\u0000\u0000\u000f^\u0001\u0000\u0000\u0000\u0011a\u0001\u0000\u0000\u0000"+
		"\u0013e\u0001\u0000\u0000\u0000\u0015l\u0001\u0000\u0000\u0000\u0017~"+
		"\u0001\u0000\u0000\u0000\u0019\u0081\u0001\u0000\u0000\u0000\u001b\u0087"+
		"\u0001\u0000\u0000\u0000\u001d\u0098\u0001\u0000\u0000\u0000\u001f\u00a6"+
		"\u0001\u0000\u0000\u0000!\"\u0005f\u0000\u0000\"#\u0005o\u0000\u0000#"+
		"$\u0005r\u0000\u0000$%\u0005w\u0000\u0000%&\u0005a\u0000\u0000&\'\u0005"+
		"r\u0000\u0000\'(\u0005d\u0000\u0000(\u0002\u0001\u0000\u0000\u0000)*\u0005"+
		"t\u0000\u0000*+\u0005u\u0000\u0000+,\u0005r\u0000\u0000,-\u0005n\u0000"+
		"\u0000-.\u0005 \u0000\u0000./\u0005l\u0000\u0000/0\u0005e\u0000\u0000"+
		"01\u0005f\u0000\u000012\u0005t\u0000\u00002\u0004\u0001\u0000\u0000\u0000"+
		"34\u0005t\u0000\u000045\u0005u\u0000\u000056\u0005r\u0000\u000067\u0005"+
		"n\u0000\u000078\u0005 \u0000\u000089\u0005r\u0000\u00009:\u0005i\u0000"+
		"\u0000:;\u0005g\u0000\u0000;<\u0005h\u0000\u0000<=\u0005t\u0000\u0000"+
		"=\u0006\u0001\u0000\u0000\u0000>?\u0005r\u0000\u0000?@\u0005e\u0000\u0000"+
		"@A\u0005s\u0000\u0000AB\u0005e\u0000\u0000BC\u0005t\u0000\u0000C\b\u0001"+
		"\u0000\u0000\u0000DE\u0005s\u0000\u0000EF\u0005k\u0000\u0000FG\u0005i"+
		"\u0000\u0000GH\u0005p\u0000\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005p"+
		"\u0000\u0000JK\u0005u\u0000\u0000KL\u0005t\u0000\u0000LM\u0005b\u0000"+
		"\u0000MN\u0005e\u0000\u0000NO\u0005e\u0000\u0000OP\u0005p\u0000\u0000"+
		"PQ\u0005e\u0000\u0000QR\u0005r\u0000\u0000R\f\u0001\u0000\u0000\u0000"+
		"ST\u0005p\u0000\u0000TU\u0005i\u0000\u0000UV\u0005c\u0000\u0000VW\u0005"+
		"k\u0000\u0000WX\u0005b\u0000\u0000XY\u0005e\u0000\u0000YZ\u0005e\u0000"+
		"\u0000Z[\u0005p\u0000\u0000[\\\u0005e\u0000\u0000\\]\u0005r\u0000\u0000"+
		"]\u000e\u0001\u0000\u0000\u0000^_\u0005;\u0000\u0000_\u0010\u0001\u0000"+
		"\u0000\u0000`b\u0007\u0000\u0000\u0000a`\u0001\u0000\u0000\u0000bc\u0001"+
		"\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"d\u0012\u0001\u0000\u0000\u0000ei\u0007\u0001\u0000\u0000fh\u0007\u0002"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0014\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lq\u0005\"\u0000\u0000mp\u0003\u0017\u000b"+
		"\u0000np\t\u0000\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000ps\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000qo\u0001\u0000"+
		"\u0000\u0000rt\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005"+
		"\"\u0000\u0000u\u0016\u0001\u0000\u0000\u0000vw\u0005\\\u0000\u0000w\u007f"+
		"\u0005\"\u0000\u0000xy\u0005\\\u0000\u0000y\u007f\u0005n\u0000\u0000z"+
		"{\u0005\\\u0000\u0000{\u007f\u0005%\u0000\u0000|}\u0005\\\u0000\u0000"+
		"}\u007f\u0005\\\u0000\u0000~v\u0001\u0000\u0000\u0000~x\u0001\u0000\u0000"+
		"\u0000~z\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0018"+
		"\u0001\u0000\u0000\u0000\u0080\u0082\u0007\u0003\u0000\u0000\u0081\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0006\f\u0000\u0000\u0086\u001a\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005/\u0000\u0000\u0088\u0089\u0005/\u0000"+
		"\u0000\u0089\u008d\u0001\u0000\u0000\u0000\u008a\u008c\t\u0000\u0000\u0000"+
		"\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000"+
		"\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0092\u0005\r\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093"+
		"\u0095\u0007\u0004\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0001\u0000\u0000\u0000\u0096\u0097\u0006\r\u0000\u0000\u0097\u001c"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0005/\u0000\u0000\u0099\u009a\u0005"+
		"*\u0000\u0000\u009a\u009e\u0001\u0000\u0000\u0000\u009b\u009d\t\u0000"+
		"\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0005*\u0000\u0000\u00a2\u00a3\u0005/\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0006\u000e\u0000\u0000"+
		"\u00a5\u001e\u0001\u0000\u0000\u0000\u00a6\u00a7\t\u0000\u0000\u0000\u00a7"+
		" \u0001\u0000\u0000\u0000\u000b\u0000cioq~\u0083\u008d\u0091\u0094\u009e"+
		"\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}