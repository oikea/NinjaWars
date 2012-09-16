@echo off

SET TARGET=%1
if "%TARGET%"=="" SET TARGET=run

if "%TARGET%"=="tool" goto tool
if "%TARGET%"=="home" goto home

setlocal
%NSW_DRIVE%
cd %NSW_HOME%\tools

call %TARGET% %2 %3 %4 %5 %6 %7 %8 %9
goto end

:tool
%NSW_DRIVE%
cd %NSW_HOME%\tools
goto end

:home
%NSW_DRIVE%
cd %NSW_HOME%
goto end

:end
