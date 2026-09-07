@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

setlocal enabledelayedexpansion

set APP_NAME=gradlew
set APP_HOME=%~dp0

if not exist "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" (
    echo Error: Gradle wrapper jar not found at %APP_HOME%gradle\wrapper\gradle-wrapper.jar
    exit /b 1
)

if not defined JAVA_HOME (
    echo Error: JAVA_HOME is not set
    exit /b 1
)

set CLASSPATH=%APP_HOME%gradle\wrapper\gradle-wrapper.jar

"%JAVA_HOME%\bin\java.exe" -Dorg.gradle.appname="%APP_BASE_NAME%" -classpath "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*