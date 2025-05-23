grammar Karel;
options { language = Java; }
@header
{

package lang.karel;
import java.util.*;
import java.io.*;
import org.json.*;
import javax.swing.*;
import static lang.karel.Karel.*;
import lang.karel.KarelVisualizer;
    
}
dNumber returns [ Number _result ] :
   n=dNUM { $_result = new Number.Num($n._result); }
;
dCondition returns [ Condition _result ] :
   'front-is-clear' { $_result = new Condition.FrontIsClear(); }
|  'front-is-blocked' { $_result = new Condition.FrontIsBlocked(); }
|  'left-is-clear' { $_result = new Condition.LeftIsClear(); }
|  'left-is-blocked' { $_result = new Condition.LeftIsBlocked(); }
|  'right-is-clear' { $_result = new Condition.RightIsClear(); }
|  'right-is-blocked' { $_result = new Condition.RightIsBlocked(); }
|  'back-is-clear' { $_result = new Condition.BackIsClear(); }
|  'back-is-blocked' { $_result = new Condition.BackIsBlocked(); }
;
dCommand returns [ Command _result ] :
   'forward' { $_result = new Command.Forward(); }
|  'forward' n=dNumber { $_result = new Command.ForwardN($n._result); }
|  'turn' 'left' { $_result = new Command.TurnLeft(); }
|  'turn' 'right' { $_result = new Command.TurnRight(); }
|  'pickbeeper' { $_result = new Command.PickBeeper(); }
|  'putbeeper' { $_result = new Command.PutBeeper(); }
|  'reset' { $_result = new Command.Reset(); }
|  'skip' { $_result = new Command.Skip(); }
|  'if' b=dCondition 'then' c1=dCommand 'else' c2=dCommand { $_result = new Command.IfElse($b._result, $c1._result, $c2._result); }
|  'while' b=dCondition 'do' '(' c=dCommand ')' { $_result = new Command.While($b._result, $c._result); }
|  'while' b=dCondition 'do' c=dCommand { $_result = new Command.While($b._result, $c._result); }
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
