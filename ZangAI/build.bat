set pluginName=ZangAiPlugin.jar
set targetPath=E:\Project\Java\Spigot\Servers\plugins\
@REM 编译
javac -encoding UTF-8 -cp .\lib\*.jar -d . .\src\ltq\mc\*.java
@REM 打包
jar cvfM %pluginName% .\ltq .\lib .\plugin.yml .\META-INF
@REM 复制插件到服务端
copy %pluginName% %targetPath%
@REM 删除生成的文件
del %pluginName%
del /s /q ltq
rd /s /q ltq
@REM 启动服务
cd E:\Project\Java\Spigot\Servers
java -jar .\spigot-1.16.2.jar