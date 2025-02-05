@echo off

REM Check if JREInstaller.bat exists
if not exist "JREInstaller.bat" (
    echo JREInstaller.bat not found, downloading...
    curl -o JREInstaller.bat https://raw.githubusercontent.com/MythEclipse/ProjectBP1Teori/refs/heads/main/JREInstaller.bat
)

REM Run the JRE installer
call JREInstaller.bat

REM Set the path to the extracted JRE
set "JRE_PATH=.\PortableJRE\jdk-17.0.13+11-jre"

REM Check if ProjectBP1Teori-1.0-SNAPSHOT.jar exists
if not exist "ProjectBP1Teori-1.0-SNAPSHOT.jar" (
    echo ProjectBP1Teori-1.0-SNAPSHOT.jar not found, downloading...
    curl -o ProjectBP1Teori-1.0-SNAPSHOT.jar https://raw.githubusercontent.com/MythEclipse/ProjectBP1Teori/refs/heads/main/ProjectBP1Teori-1.0-SNAPSHOT.jar
)

REM Run the packaged JAR file using the specified JRE
"%JRE_PATH%\bin\java" -jar ".\ProjectBP1Teori-1.0-SNAPSHOT.jar"