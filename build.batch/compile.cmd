@echo off

set this=[%~nx0]
set thidDir=%~dp0
set owd=%cd%

echo executing: %this%
echo %this% parent: %thidDir%
echo %this% parameter: %*

SETLOCAL EnableDelayedExpansion

:parameterParsingStart
if "%1" == "" (
	goto parameterParsingEnd
) else (
	echo parse parameter %1
	if /I "%1" EQU "-p" (
		:: TODO Error handling: validate %2
		shift
		echo %this% module path is: %2
		set modulePath=-p %2
		shift
		goto parameterParsingStart 
	)
	echo %this% unknown parameter: %1
	goto EOF
)


goto parameterParsingStart


:parameterParsingEnd


echo %this% Collecting source files


set sourceFiles=
for /f %%f in ('dir /s/b "src\main\java\*.java"') do set sourceFiles=!sourceFiles! %%f

echo %this% Done with collecting source files. 
echo.

set buildDestination=.\build.batch

echo %this% source files: %sourceFiles%
echo %this% build destination: "%buildDestination%"
echo %this% modulePath: %modulePath%


echo build compile command
set buildCommand=javac
set buildCommand=%buildCommand% -d %buildDestination%
set buildCommand=%buildCommand% --enable-preview
set buildCommand=%buildCommand% --release 15
set buildCommand=%buildCommand% -verbose
set buildCommand=%buildCommand% %modulePath%
set buildCommand=%buildCommand% %sourceFiles%

echo %this% final compile command is:
echo     %buildCommand%

echo %this%  execute compile command
call %buildCommand%

if ERRORLEVEL 0 (
	echo %this% Compilation succesful
) else (
	echo %this% Compilation faild. Errorcode %ERRORLEVEL%
)

:EOF
