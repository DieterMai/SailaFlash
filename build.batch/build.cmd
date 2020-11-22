@echo off

echo execute build.cmd in %cd%

SETLOCAL EnableDelayedExpansion

:parameterParsingStart
if "%1" == "" (
	goto parameterParsingEnd
) else (
	echo parse parameter %1
	if /I "%1" EQU "-p" (
		:: TODO Error handling: validate %2
		shift
		echo module path is: %2
		set modulePath=-p %2
		shift
		goto parameterParsingStart 
	)
	echo unknown parameter: %1
	goto EOF
)


goto parameterParsingStart


:parameterParsingEnd


echo Collecting source files

set sourceFiles=
for /f %%f in ('dir /s/b "src\main\java\*.java"') do set sourceFiles=!sourceFiles! %%f

echo Done with collecting source files. 
echo.

set buildDestination=.\build.batch

echo source files: %sourceFiles%
echo build destination: "%buildDestination%"
echo modulePath: %modulePath%


echo build compile command
set buildCommand=javac
set buildCommand=%buildCommand% -d %buildDestination%
set buildCommand=%buildCommand% --enable-preview
set buildCommand=%buildCommand% --release 15
set buildCommand=%buildCommand% -verbose
set buildCommand=%buildCommand% %modulePath%
set buildCommand=%buildCommand% %sourceFiles%

echo final compile command is:
echo     %buildCommand%

echo execute compile command
call %buildCommand%

:EOF
