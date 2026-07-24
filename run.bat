@echo off

cd src

javac app\Main.java ui\*.java parser\*.java model\*.java detection\*.java controller\*.java service\*.java report\*.java database\*.java repository\*.java mitre\*.java
java -cp ".;..\lib\sqlite-jdbc-3.53.2.0.jar" app.Main

pause