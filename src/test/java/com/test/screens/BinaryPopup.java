package com.test.screens;
import com.test.Configurations.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BinaryPopup {

    private AndroidDriver driver;
    private AndroidElement ok;
    private AndroidElement cancel;

    public BinaryPopup() {
        this.driver = new Hooks().getAndroidDriver();
        this.ok = (AndroidElement) this.driver.findElementById("android:id/button1");
        this.cancel = (AndroidElement) this.driver.findElementById("android:id/button2");
    }

    public AndroidElement getOk() {
        return ok;
    }

    public AndroidElement getCancel() {
        return cancel;
    }
}
