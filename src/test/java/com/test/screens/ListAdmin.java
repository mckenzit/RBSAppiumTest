package com.test.screens;
import com.test.Configurations.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class ListAdmin{

    private AndroidDriver driver;
    private AndroidElement deleteList;

    public ListAdmin() {
        this.driver = new Hooks().getAndroidDriver();
        this.deleteList = (AndroidElement) this.driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[4]");
    }

    public AndroidElement getDeleteList() {
        return deleteList;
    }
}
