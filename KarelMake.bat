@echo off
C:\Program Files\Java\jdk-23\bin\java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool lang\karel\Karel.g4
rem JAVA
set JAVA_HOME=C:\Program Files\Java\jdk-23
set JAVA_OPTIONS=
set JAVA=%JAVA_HOME%\bin\java
set JAVAC=%JAVA_HOME%\bin\javac

rem ANTLR4: complete tool for compilation, not just the runtime binaries
set ANTLR4_JAR=C:\SLANG-1.0.2\lib\antlr4.jar
set ANTLR4="%JAVA% -cp %ANTLR4_JAR% org.antlr.v4.Tool"

rem SLANG
set SLANG=C:\SLANG-1.0.2\bin\SLANG

rem Execute SLANG, ANTLR4, JAVAC
%SLANG% -d lang\karel Karel.txt
%ANTLR4% lang\karel\Karel.g4
java -jar C:\antlr\antlr-4.13.2-complete.jar lang\karel\Karel.g4
%JAVAC% %JAVA_OPTIONS% -cp "%ANTLR4_JAR%;." KarelMain.java
