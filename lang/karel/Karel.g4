grammar Karel;
options { language = Java; }
@header
{

package lang.karel;
import java.util.*;
import static lang.karel.Karel.*;
    
}
dCommand returns [ Command _result ] :
   'forward' n=dNUM { $_result = new Command.Forward($n._result); }
|  'forward' { $_result = new Command.ForwardDefault(); }
|  'turn left' { $_result = new Command.TurnLeft(); }
|  'turn right' { $_result = new Command.TurnRight(); }
|  'reset' { $_result = new Command.Reset(); }
|  'skip' { $_result = new Command.Skip(); }
|  'putbeeper' { $_result = new Command.PutBeeper(); }
|  'pickbeeper' { $_result = new Command.PickBeeper(); }
|  c1=dCommand ';' c2=dCommand { $_result = new Command.Seq($c1._result, $c2._result); }
;
dProgram returns [ Program _result ] :
   c=dCommand ( ';' c2=dCommand )* ';'? EOF { $_result = new Program.Prog($c._result); }
;
dNUM returns [ String _result ] : n=NUM { $_result = $n.text; } ;
dID returns [ String _result ] : i=ID { $_result = $i.text; } ;
dSTR returns [ String _result ] : s=STR { $_result = $s.text; } ;
NUM : [0-9]+ ;
ID : [a-zA-Z][a-zA-Z_0-9]* ;
STR : '"' (ESC|.)*? '"' ;
fragment ESC : '\\"' | '\\n' | '\\%' | '\\\\';
WHITESPACE  : [ \t\r\n\f]+ -> skip ;
LINECOMMENT : '//' .*? '\r'? ('\n' | EOF) -> skip ;
COMMENT     : '/*' .*? '*/' -> skip ;
ERROR : . ;
