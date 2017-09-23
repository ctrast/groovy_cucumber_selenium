package appSearch

import context.ContextUtil
import org.openqa.selenium.By
import utilities.AppConstants

class Navigate {
    void Google(){
        ContextUtil.get().getWebDriverInstance().navigate().to(AppConstants.GOOGLEHOME)
    }

    void All(){
        ContextUtil.get().getWebDriverInstance().findElement(By.linkText("AllPage")).click()
    }

    void News(){
        ContextUtil.get().getWebDriverInstance().findElement(By.linkText("News")).click()
    }

    void Images(){
        ContextUtil.get().getWebDriverInstance().findElement(By.linkText("Images")).click()
    }

    void Videos(){
        ContextUtil.get().getWebDriverInstance().findElement(By.linkText("Videos")).click()
    }
}
