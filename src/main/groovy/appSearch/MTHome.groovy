package appSearch

import context.ContextUtil
import org.openqa.selenium.By
import utilities.Wait

class MTHome {


    void username_edt_sendKeys(String string){
        ContextUtil.get().getWebDriverInstance().findElement(By.name("userName")).sendKeys(string)

    }
    void passsword_edt_sendKeys(String string){
        ContextUtil.get().getWebDriverInstance().findElement(By.name("password")).sendKeys(string)

    }

    void signin_btn_click(){
        ContextUtil.get().getWebDriverInstance().findElement(By.name("login")).click()

    }


}
