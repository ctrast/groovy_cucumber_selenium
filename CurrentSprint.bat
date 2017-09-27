set projectLocation=C:\Dev\Groovy_Cucumber_Selenium
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*

java -cp "C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2017.2.4\plugins\testng\lib\" org.testng.TestNG currentsprint.xml
