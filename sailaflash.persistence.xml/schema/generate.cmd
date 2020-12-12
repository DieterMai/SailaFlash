@echo off

SETLOCAL ENABLEEXTENSIONS
SET this=%~n0
SET wd=%~dp0
SET startTime=%TIME%

echo %this% called
echo Working directory: %wd%
echo Additional parameter: %* 
echo Start time: %startTime% 

del /Q ..\src\main\java\dev\dietermai\sailaflash\persistence\xml\node\*

call xjc -d output -p dev.dietermai.sailaflash.persistence.xml.node -no-header -encoding UTF-8 %* sailaflash.xsd

copy /Y output\dev\dietermai\sailaflash\persistence\xml\node\* ..\src\main\java\dev\dietermai\sailaflash\persistence\xml\node


SET endTime=%TIME%
echo End time: %endTime% 
