package utilities

import context.ContextUtil
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

class Wait {

    static Boolean webDriverWaitId(Integer waittime, String value){

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), waittime)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.id(value)))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitLinkText(int i, String value){

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)))
        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitWebElemnt(int i, WebElement webElement){

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(webElement))
        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitClassName(int i, String value){

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)))
        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitH3ContainsText(int i, String value){

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space(.) ='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitButtonEnabledText(int i, String value) {

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@span[text()='"+value+"']]")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitforTDTextToAppear(int i, String value) {

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitButtonSpanText_Clickable(int i, String value) {

        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitForElementDivText(int i, String value) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(.) ='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitForElementDivClassText(int i, String value, String classname) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, '"+classname+"') and normalize-space(.)='"+value+"']")))
        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitH2ContainsText(int i, String value) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space(.) ='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitH2ContainsTextValue(int i, String value) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), '"+value+"')]")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitH1ContainsText(int i, String value) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space(.) ='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

    static Boolean webDriverWaitLIContainsText(int i, String value) {
        WebDriverWait wait = new WebDriverWait(ContextUtil.get().getWebDriverInstance(), i)
        WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[normalize-space(.) ='"+value+"']")))

        if(!(we.getText() == null)){
            UtilityHelper.isfound = true
        }
        return UtilityHelper.isfound
    }

}