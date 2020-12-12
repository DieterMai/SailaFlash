@echo off

:: change to root of project so that the acutal compile script can find the sources
cd ..

call ..\build.batch\compile.cmd -p "..\dev.dietermai.sailaflash.api\build.batch"
