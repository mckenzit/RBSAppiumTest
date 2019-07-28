package com.test.screens;
import com.test.Configurations.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Base {

    private AndroidElement navBar;
    private AndroidElement listAdmin;

    public Base() {
        AndroidDriver driver = new Hooks().getAndroidDriver();
        this.navBar = (AndroidElement) driver.findElementByAccessibilityId("Open navigation drawer");
        this.listAdmin = (AndroidElement) driver.findElementByAccessibilityId("More options");
    }

    public AndroidElement getNavBar() {
        return navBar;
    }

    public AndroidElement getListAdmin() {
        return listAdmin;
    }
}