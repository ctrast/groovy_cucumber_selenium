package utilities

import context.ContextUtil
import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.*
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.Select

import java.util.concurrent.TimeUnit

class UtilityHelper {

    static Boolean isfound = false

    static boolean isAlertAccept() throws Exception {

        boolean alertPresentFlag = false
        Thread.sleep(4000)
        try {

            // Check for Alert
            Alert alert = ContextUtil.get().getWebDriverInstance().switchTo()
                    .alert()
            // Alert set the flag
            alertPresentFlag = true
            // alert accept
            alert.accept()

        } catch (NoAlertPresentException ex) {
            // no alert
            ex.printStackTrace()
        }

        return alertPresentFlag

    }

    static String getCurrentWindow() {
        String parentWindowHandle = ContextUtil.get().getWebDriverInstance()
                .getWindowHandle() // Get parent window
        return parentWindowHandle
    }

    static String switchToSubWin() {
        String parentWindowHandle = ContextUtil.get().getWebDriverInstance()
                .getWindowHandle() // Get parent window
        String parenttitle = ContextUtil.get().getWebDriverInstance()
                .getTitle()
        Boolean isNewWinFound = false
        java.util.Set<String> handles = ContextUtil.get()
                .getWebDriverInstance().getWindowHandles() // get win handles

        Iterator<String> iterator = handles.iterator()
        while (iterator.hasNext()) {
            String popupHandle = iterator.next().toString()
            String mytitle = ContextUtil.get().getWebDriverInstance()
                    .switchTo().window(popupHandle).getTitle()

            if (!mytitle.equals(parenttitle)) {
                ContextUtil.get().getWebDriverInstance().switchTo()
                        .window(popupHandle)

                isNewWinFound = true
                break
            }
        }
        if (isNewWinFound == false) {
            switchToSubWin()
        }
        return parentWindowHandle
    }

    static boolean switchToParentWin(String parent_win_handle) {
        Boolean myval = false
        WebDriver wd = ContextUtil.get().getWebDriverInstance().switchTo()
                .window(parent_win_handle) // switch back to parent window
        if (wd != null) {
            myval = isfound
        }
        return myval
    }

    static boolean switchToParentWin_noClose(String parent_win_handle) {
        Boolean myval = false
        WebDriver wd = ContextUtil.get().getWebDriverInstance().switchTo()
                .window(parent_win_handle) // switch back to parent window
        if (wd != null) {
            myval = isfound
        }
        return myval
    }


    static List<WebElement> IsElementPresent(String string) {

        List<WebElement> elements
        waitForLoad()
        if (ContextUtil.get().getWebDriverInstance()
                .findElements(By.id(string)).isEmpty()) {
            System.out.println("Elements list is empty")
        }
        ContextUtil.get().getWebDriverInstance().manage().timeouts()
                .implicitlyWait(timeout, TimeUnit.SECONDS)
        elements = ContextUtil.get().getWebDriverInstance()
                .findElements(By.id(string))
        return elements
    }

    static void waitForLoad() {

        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {

            @Override
            Boolean apply(WebDriver wd) {

                return "complete".equals(((JavascriptExecutor) wd)
                        .executeScript("return document.readyState"))
            }
        }
    }

    private static int timeout = utilities.AppConstants.DEFAULT_TIMEOUT_SECONDS

    int getTimeout() {
        return timeout
    }

    @SuppressWarnings("static-access")
    void setTimeout(int timeout) {
        this.timeout = timeout
    }


    static Boolean h1containsText(String string) {
        Boolean h1text = ContextUtil.get().getWebDriverInstance()
                .findElements(By.xpath("//h1[contains(., '" + string + "')]"))
                .size() == 1
        return h1text
    }

    static Boolean licontainsText(String string) {
        Boolean h1text = ContextUtil.get().getWebDriverInstance()
                .findElements(By.xpath("//li[contains(., '" + string + "')]"))
                .size() == 1
        return h1text
    }

    static Boolean divcontainsText(String string) {
        System.out
                .println("the size is "
                + ContextUtil
                .get()
                .getWebDriverInstance()
                .findElements(
                By.xpath("//div[contains(., '" + string
                        + "')]")).size())
        Boolean divtext = ContextUtil.get().getWebDriverInstance()
                .findElements(By.xpath("//div[contains(., '" + string + "')]"))
                .size() > 1
        return divtext
    }

    static String getCellData_Table(String tableClassName, int row, int col) {
        String celldata = null
        WebElement table =ContextUtil.get().getWebDriverInstance().findElement(By.className(""+ tableClassName +""))
        // Get all rows (tr tags)
        List<WebElement> rows = table.findElements(By.tagName("tr"))
        int rowcnt = 1
        int colcnt = 1
        for (WebElement rowitem : rows) {
            if (row == rowcnt){
                List<WebElement> cells = rowitem.findElements(By.tagName("td"))
                for (WebElement cell:cells){
                    if(col == colcnt){
                        celldata = cell.getText()
                        break
                    }else{
                        colcnt++
                    }
                }
            }else{
                rowcnt++
            }
        }
        return celldata
    }

    static void clickOnCell_Table(String tableClassName, int row, int col) {
        WebElement table =ContextUtil.get().getWebDriverInstance().findElement(By.className(""+ tableClassName +""))
        Boolean cellClicked= false
        List<WebElement> rows = table.findElements(By.tagName("tr"))
        int rowcnt = 1
        int colcnt = 1
        for (WebElement rowitem : rows) {
            if (row == rowcnt && !cellClicked){
                List<WebElement> cells = rowitem.findElements(By.tagName("td"))
                for (WebElement cell:cells){
                    if(col == colcnt && !cellClicked){
                        System.out.println("cellclick"+cell.getText().toString())
                        cell.findElement(By.className("menulink")).click()
                        cellClicked= true
                        break
                    }else{
                        colcnt++
                    }
                }
            }else{
                rowcnt++
            }
        }
    }

    static void completeAttribute(String tableClassName, String attrName, String attrValue) {
        WebElement table =ContextUtil.get().getWebDriverInstance().findElement(By.className(""+ tableClassName +""))
        List<WebElement> row_tables = table.findElements(By.tagName("table"))
        outer:
        for (WebElement rowitem : row_tables) {
            String textvalue = rowitem.getText().toString().replaceAll("[\n\r]", "")
            String cleaned_text = StringUtils.strip(textvalue,"*")
            if (cleaned_text.equals(attrName)){
                int currow = row_tables.indexOf(rowitem)
                WebElement desired_table = row_tables.get(currow+1)
                boolean isSelect = desired_table.findElements(By.tagName("select")).size()==1
                boolean isInput = desired_table.findElements(By.tagName("input")).size()==1
                if(isSelect){							//is DDL
                    Select selobj = new Select(desired_table.findElement(By.tagName("select")))
                    selobj.selectByValue(attrValue)
                    break outer
                }
                if(isInput)	{						//item is an input
                    WebElement input = desired_table.findElement(By.tagName("input"))
                    input.clear()
                    input.sendKeys(attrValue)
                    break outer
                }
            }
        }
    }
}
