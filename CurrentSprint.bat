set projectLocation=C:\Dev\Groovy_Cucumber_Selenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java -cp "$USER_HOME$/.gradle/caches/modules-2/files-2.1/org.testng/testng/6.9.10/6feb3e964aeb7097aff30c372aac3ec0f8d87ede/testng-6.9.10.jar" org.testng.TestNG  currentsprint.xml
