@echo off

set this=[%~nx0]
set parentDir=%~dp0
set owd=%cd%

cd ../..
set root=%cd%

echo executing: %this%
echo %this% parent: %parent%
echo %this% parameter: %*
echo.
echo %this% Working directiory: %owd% 
echo %this% Root directiory: %root%

set batchDir=buildBatch


call :compileProject sailaflash.api
call :compileProject sailaflash.boot


echo %this% --DONE--

exit 0

:compileProject
echo %this% start with %0
set super=%this%
set this=[%0]

echo %this% In sub: %0
echo %this% paramters: %*
cd %1
cd %batchDir%

call compile.cmd

set this=%super%
echo %this% done with %0
exit /B 0


