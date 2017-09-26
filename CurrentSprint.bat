set projectLocation=C:\Dev\Groovy_Cucumber_Selenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\support\testngconfigs\currentsprint.xml
pause

