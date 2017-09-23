package context

import org.openqa.selenium.WebDriver

class Context {

    private WebDriver webDriverInstance = null

    WebDriver getWebDriverInstance() {
        return webDriverInstance
    }

    void setWebDriverInstance(WebDriver webDriverInstance) {
        this.webDriverInstance = webDriverInstance
    }
}
