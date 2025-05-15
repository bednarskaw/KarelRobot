// Generated from lang/karel/Karel.g4 by ANTLR 4.13.2


package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		NUM=10, ID=11, STR=12, WHITESPACE=13, LINECOMMENT=14, COMMENT=15, ERROR=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"NUM", "ID", "STR", "ESC", "WHITESPACE", "LINECOMMENT", "COMMENT", "ERROR"
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
		"\u0004\u0000\u0010\u00a5\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0004\t_\b\t\u000b\t\f\t`\u0001\n\u0001\n\u0005"+
		"\ne\b\n\n\n\f\nh\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000bm"+
		"\b\u000b\n\u000b\f\u000bp\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f|\b\f\u0001"+
		"\r\u0004\r\u007f\b\r\u000b\r\f\r\u0080\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0089\b\u000e\n\u000e\f\u000e"+
		"\u008c\t\u000e\u0001\u000e\u0003\u000e\u008f\b\u000e\u0001\u000e\u0003"+
		"\u000e\u0092\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u009a\b\u000f\n\u000f\f\u000f\u009d\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0003n\u008a\u009b\u0000\u0011\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n"+
		"\u0015\u000b\u0017\f\u0019\u0000\u001b\r\u001d\u000e\u001f\u000f!\u0010"+
		"\u0001\u0000\u0005\u0001\u000009\u0002\u0000AZaz\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\f\r  \u0001\u0001\n\n\u00ae\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0001#\u0001\u0000\u0000\u0000\u0003+\u0001\u0000\u0000"+
		"\u0000\u00050\u0001\u0000\u0000\u0000\u00075\u0001\u0000\u0000\u0000\t"+
		";\u0001\u0000\u0000\u0000\u000bF\u0001\u0000\u0000\u0000\rP\u0001\u0000"+
		"\u0000\u0000\u000fV\u0001\u0000\u0000\u0000\u0011[\u0001\u0000\u0000\u0000"+
		"\u0013^\u0001\u0000\u0000\u0000\u0015b\u0001\u0000\u0000\u0000\u0017i"+
		"\u0001\u0000\u0000\u0000\u0019{\u0001\u0000\u0000\u0000\u001b~\u0001\u0000"+
		"\u0000\u0000\u001d\u0084\u0001\u0000\u0000\u0000\u001f\u0095\u0001\u0000"+
		"\u0000\u0000!\u00a3\u0001\u0000\u0000\u0000#$\u0005f\u0000\u0000$%\u0005"+
		"o\u0000\u0000%&\u0005r\u0000\u0000&\'\u0005w\u0000\u0000\'(\u0005a\u0000"+
		"\u0000()\u0005r\u0000\u0000)*\u0005d\u0000\u0000*\u0002\u0001\u0000\u0000"+
		"\u0000+,\u0005t\u0000\u0000,-\u0005u\u0000\u0000-.\u0005r\u0000\u0000"+
		"./\u0005n\u0000\u0000/\u0004\u0001\u0000\u0000\u000001\u0005l\u0000\u0000"+
		"12\u0005e\u0000\u000023\u0005f\u0000\u000034\u0005t\u0000\u00004\u0006"+
		"\u0001\u0000\u0000\u000056\u0005r\u0000\u000067\u0005i\u0000\u000078\u0005"+
		"g\u0000\u000089\u0005h\u0000\u00009:\u0005t\u0000\u0000:\b\u0001\u0000"+
		"\u0000\u0000;<\u0005p\u0000\u0000<=\u0005i\u0000\u0000=>\u0005c\u0000"+
		"\u0000>?\u0005k\u0000\u0000?@\u0005b\u0000\u0000@A\u0005e\u0000\u0000"+
		"AB\u0005e\u0000\u0000BC\u0005p\u0000\u0000CD\u0005e\u0000\u0000DE\u0005"+
		"r\u0000\u0000E\n\u0001\u0000\u0000\u0000FG\u0005p\u0000\u0000GH\u0005"+
		"u\u0000\u0000HI\u0005t\u0000\u0000IJ\u0005b\u0000\u0000JK\u0005e\u0000"+
		"\u0000KL\u0005e\u0000\u0000LM\u0005p\u0000\u0000MN\u0005e\u0000\u0000"+
		"NO\u0005r\u0000\u0000O\f\u0001\u0000\u0000\u0000PQ\u0005r\u0000\u0000"+
		"QR\u0005e\u0000\u0000RS\u0005s\u0000\u0000ST\u0005e\u0000\u0000TU\u0005"+
		"t\u0000\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005s\u0000\u0000WX\u0005"+
		"k\u0000\u0000XY\u0005i\u0000\u0000YZ\u0005p\u0000\u0000Z\u0010\u0001\u0000"+
		"\u0000\u0000[\\\u0005;\u0000\u0000\\\u0012\u0001\u0000\u0000\u0000]_\u0007"+
		"\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\u0014\u0001\u0000"+
		"\u0000\u0000bf\u0007\u0001\u0000\u0000ce\u0007\u0002\u0000\u0000dc\u0001"+
		"\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000g\u0016\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000in\u0005\"\u0000\u0000jm\u0003\u0019\f\u0000km\t\u0000\u0000"+
		"\u0000lj\u0001\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000mp\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000oq\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0005\"\u0000\u0000r\u0018"+
		"\u0001\u0000\u0000\u0000st\u0005\\\u0000\u0000t|\u0005\"\u0000\u0000u"+
		"v\u0005\\\u0000\u0000v|\u0005n\u0000\u0000wx\u0005\\\u0000\u0000x|\u0005"+
		"%\u0000\u0000yz\u0005\\\u0000\u0000z|\u0005\\\u0000\u0000{s\u0001\u0000"+
		"\u0000\u0000{u\u0001\u0000\u0000\u0000{w\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000|\u001a\u0001\u0000\u0000\u0000}\u007f\u0007\u0003\u0000"+
		"\u0000~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0006\r\u0000\u0000\u0083\u001c\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005/\u0000\u0000\u0085\u0086\u0005/\u0000"+
		"\u0000\u0086\u008a\u0001\u0000\u0000\u0000\u0087\u0089\t\u0000\u0000\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000"+
		"\u008d\u008f\u0005\r\u0000\u0000\u008e\u008d\u0001\u0000\u0000\u0000\u008e"+
		"\u008f\u0001\u0000\u0000\u0000\u008f\u0091\u0001\u0000\u0000\u0000\u0090"+
		"\u0092\u0007\u0004\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0006\u000e\u0000\u0000\u0094"+
		"\u001e\u0001\u0000\u0000\u0000\u0095\u0096\u0005/\u0000\u0000\u0096\u0097"+
		"\u0005*\u0000\u0000\u0097\u009b\u0001\u0000\u0000\u0000\u0098\u009a\t"+
		"\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009b\u0099\u0001"+
		"\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005*\u0000\u0000\u009f\u00a0\u0005/\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u000f\u0000"+
		"\u0000\u00a2 \u0001\u0000\u0000\u0000\u00a3\u00a4\t\u0000\u0000\u0000"+
		"\u00a4\"\u0001\u0000\u0000\u0000\u000b\u0000`fln{\u0080\u008a\u008e\u0091"+
		"\u009b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}