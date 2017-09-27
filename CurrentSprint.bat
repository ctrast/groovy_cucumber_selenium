set projectLocation=C:\Dev\Groovy_Cucumber_Selenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -cp C:\Workspace\projectname\lib*;C:\Workspace\projectname\bin org.testng.TestNG currentsprint.xml
pause

