@echo off

SETLOCAL EnableDelayedExpansion

set sourceFiles=

for /f %%f in ('dir /s/b "src\main\java\*.java"') do set sourceFiles=!sourceFiles! %%f

::echo sourceFiles: "%sourceFiles%"

javac ^
	-d ".\batchBuild" ^
	--enable-preview ^
	--release 15 ^
	-verbose ^
	%sourceFiles%