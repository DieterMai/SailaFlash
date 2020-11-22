@echo off

echo execute build.cmd in %cd%

SETLOCAL EnableDelayedExpansion

echo Collecting source files

set sourceFiles=
for /f %%f in ('dir /s/b "src\main\java\*.java"') do set sourceFiles=!sourceFiles! %%f

echo Done with collecting source files. 
echo source files are: %sourceFiles%

set buildDestination=.\build.batch
echo build destination is "%buildDestination%"


echo build compile command
set buildCommand=javac
set buildCommand=%buildCommand% -d %buildDestination%
set buildCommand=%buildCommand% --module-path ..\dev.dietermai.sailaflash.api\batchBuild
set buildCommand=%buildCommand% --enable-preview
set buildCommand=%buildCommand% --release 15
set buildCommand=%buildCommand% -verbose
set buildCommand=%buildCommand% %sourceFiles%

echo final compile command is:
echo     %buildCommand%

echo execute compile command
call %buildCommand%
