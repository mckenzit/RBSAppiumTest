package com.test.screens;
import com.test.Configurations.Hooks;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


public class Layout{

    private AndroidDriver driver;
    private AndroidElement buttonLayoutChoiceBottom;
    private AndroidElement buttonLayoutChoiceBar;

    public Layout() {
        this.driver = new Hooks().getAndroidDriver();
        this.buttonLayoutChoiceBottom = (AndroidElement) this.driver.findElementById("layout_choice_bottom");
        this.buttonLayoutChoiceBar = (AndroidElement) this.driver.findElement(By.id("layout_choice_actionbar"));
    }

    public AndroidElement getButtonLayoutChoiceBottom() {
        return buttonLayoutChoiceBottom;
    }

    public AndroidElement getButtonLayoutChoiceBar() {
        return buttonLayoutChoiceBar;
    }

}

