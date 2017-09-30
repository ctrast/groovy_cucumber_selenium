package appSearch

import context.ContextUtil
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import utilities.UtilityHelper
import utilities.Wait

//google home page
class Google {
    static Boolean rtn = false

    void googSearch_edt_sendKeys(String string){
        ContextUtil.get().getWebDriverInstance().findElement(By.id("lst-ib")).sendKeys(string)
        ContextUtil.get().getWebDriverInstance().findElement(By.id("lst-ib")).sendKeys(Keys.RETURN)
    }


    void googSearch_btn_click(){
        ContextUtil.get().getWebDriverInstance().findElement(By.name("btnK")).click()
        Wait.webDriverWaitId(30, "resultStats")

    }

    void googSearchMagGlass_btn_click(){
        ContextUtil.get().getWebDriverInstance().findElement(By.id("_fZl")).click()
    }

    Boolean googSearch_btn_exists(){
        rtn = UtilityHelper.findElementByName("btnK")
        return rtn
    }

}