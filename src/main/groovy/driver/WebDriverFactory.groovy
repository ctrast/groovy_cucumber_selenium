package driver

import context.Context
import context.ContextUtil
import dto.Browser
import org.openqa.selenium.*
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

class WebDriverFactory {

    /* Browsers constants */
    private static final String CHROME = "Chrome"
    private static final String INTERNET_EXPLORER = "ie"
    private static final String SAFARI = "Safari"
    private static final String FIREFOX = "Firefox"

    private static final String REMOTE_CHROME = "remoteChrome"
    private static final String REMOTE_INTERNET_EXPLORER = "remoteIE"
    private static final String REMOTE_FIREFOX = "remoteFirefox"
    private static final String REMOTE_SAFARI = "remoteSafari"

    /* Platform constants */
    private static final String WINDOWS = "windows"
    private static final String XP = "xp"
    private static final String VISTA = "vista"
    private static final String MAC = "mac"
    private static final String LINUX = "linux"

    private static final String IEDRIVER_PATH = "src/main/resources/drivers/internetexplorer/IEDriverServer.exe"
    private static final String CHROMEDRIVER_PATH = "src/main/resources/drivers/chrome/chromedriver"
    private static final String REMOTE_CHROMEDRIVER_PATH = ""

    static void initialize(String gridHubUrl, Browser browser)
    {

        WebDriver webDriver = null
        Context context = new Context()
        DesiredCapabilities capability = new DesiredCapabilities()
        String browserName = browser.getName()
        capability.setJavascriptEnabled(true)
        gridHubUrl = null

        if (gridHubUrl == null || gridHubUrl.length() == 0) {
            webDriver = getInstance(browser)
        } else {

            if (REMOTE_CHROME.equals(browserName)) {
                setRemoteChromeDriver()
                capability = DesiredCapabilities.chrome()
            } else if (REMOTE_FIREFOX.equals(browserName)) {
                capability = DesiredCapabilities.firefox()
                capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true)
            } else if (REMOTE_INTERNET_EXPLORER.equals(browserName)) {
                capability = DesiredCapabilities.internetExplorer()
                //capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            } else if (REMOTE_SAFARI.equals(browserName)) {
                capability = DesiredCapabilities.safari()
            }
            capability = setVersionAndPlatform(capability,
                    browser.getVersion(), browser.getPlatform())

            try {
                webDriver = new RemoteWebDriver(new URL(gridHubUrl), capability)
            } catch (MalformedURLException e) {
                e.printStackTrace()
            }

        }
        // webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        context.setWebDriverInstance(webDriver)
        ContextUtil.set(context)

    }

    private static DesiredCapabilities setVersionAndPlatform(
            DesiredCapabilities capability, String version, String platform) {
        if (MAC.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC)
        } else if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX)
        } else if (XP.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.XP)
        } else if (VISTA.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.VISTA)
        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS)
        } else {
            capability.setPlatform(Platform.ANY)
        }
        if (version != null) {
            capability.setVersion(version)
        }
        return capability
    }

    static WebDriver getInstance(Browser browser) {

        WebDriver webDriver = null
        String browserName = browser.getName()

        if (CHROME.equals(browserName)) {

            setChromeDriver()
            webDriver = new ChromeDriver()
            webDriver.manage().window().setPosition(new Point(0, 0))
            webDriver.manage().window().setSize(new Dimension(2000,1800))

        } else if (FIREFOX.equals(browserName)) {

            webDriver = new FirefoxDriver()

        } else if (INTERNET_EXPLORER.equals(browserName)) {

            // isSupportedPlatform(browser);
            String url = browser.getUrl()
            webDriver = new InternetExplorerDriver(setIEDriver(url))
            webDriver.manage().window().maximize()

        }

        return webDriver
    }

    static void closeBrowser() {
        ContextUtil.get().getWebDriverInstance().close()
    }

    static void quitDriver() {
        ContextUtil.get().getWebDriverInstance().quit()
    }
    private static void setChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3)
        String chromeBinary = CHROMEDRIVER_PATH+(os.equals("win") ? ".exe" : "")
        String result
        result = System.setProperty("webdriver.chrome.driver", chromeBinary)
        println result
    }

    private static void setRemoteChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3)
        String chromeBinary = REMOTE_CHROMEDRIVER_PATH + (os.equals("win") ? ".exe" : "")
        System.setProperty("webdriver.chrome.driver", chromeBinary)
    }

    private static DesiredCapabilities setIEDriver(String url) {

        System.setProperty("webdriver.ie.driver", IEDRIVER_PATH)
        DesiredCapabilities capabilities = DesiredCapabilities
                .internetExplorer()
        // capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
        // true);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE)

        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true)
        capabilities.setCapability("initialBrowserUrl", url)

        return capabilities

    }

    @SuppressWarnings("unused")
    private static void isSupportedPlatform(String browser) {
        boolean is_supported = true
        Platform current = Platform.getCurrent()
        if (INTERNET_EXPLORER.equals(browser)) {
            is_supported = Platform.WINDOWS.is(current)
        } else if (SAFARI.equals(browser)) {
            is_supported = Platform.MAC.is(current) || Platform.WINDOWS.is(current)
        }
        assert is_supported : "Platform is not supported by " + browser.toUpperCase() + " browser"
    }

}