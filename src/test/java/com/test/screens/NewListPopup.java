package com.test.screens;
import com.test.Configurations.Hooks;
import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class NewListPopup{

    private AndroidDriver driver;
    private AndroidElement ok;
    private AndroidElement textField;

    public NewListPopup(){
        this.driver = new Hooks().getAndroidDriver();
        List<MobileElement> mobele =  this.driver.findElementsById("org.openintents.shopping:id/edittext");
        this.textField = (AndroidElement) mobele.get(mobele.size()-1);
        this.ok = (AndroidElement) this.driver.findElement(By.id("android:id/button1"));
    }

    public AndroidElement getOk() {
        return ok;
    }

    public AndroidElement getTextField() {
        return textField;
    }
}
