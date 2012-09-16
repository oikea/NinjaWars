@echo off
setlocal

cd ../

if "%1"=="-c" call grails clean
call grails compile

pause
