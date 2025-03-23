# Setup tuturial

## 1. Download SLANG:

https://www3.risc.jku.at/research/formal/software/SLANG/public/

## 2. Download Antler:

https://www.antlr.org/download.html

## 3. Add Antler to SLANG folder:

Copy antler jar to \SLANG-1.0.2\lib

## 4. Create setup bat file:

```
rem JAVA
set JAVA_HOME=C:\Program Files\Java\jdk-23
set JAVA_OPTIONS=
set JAVA="%JAVA_HOME%\bin\java"
set JAVAC=%JAVA_HOME%\bin\javac

rem ANTLR4: complete tool for compilation, not just the runtime binaries
set ANTLR4_JAR=C:\antlr\antlr-4.13.2-complete.jar
set ANTLR4=%JAVA% -cp "%ANTLR4_JAR%" org.antlr.v4.Tool

rem SLANG
set SLANG=C:\SLANG-1.0.2\bin\SLANG.bat

rem Execute SLANG, ANTLR4, JAVAC
%SLANG% -d lang\stacklang StackLang.txt
%ANTLR4% lang\stacklang\StackLang.g4
java -jar C:\antlr\antlr-4.13.2-complete.jar lang\stacklang\StackLang.g4
%JAVAC% %JAVA_OPTIONS% -cp "%ANTLR4_JAR%;." StackLangMain.java
```

## 5. Probelms with Command and Program classes:

If Command and Program classes were not created run again:
`java -jar C:\antlr\antlr-4.13.2-complete.jar lang\stacklang\StackLang.g4`

