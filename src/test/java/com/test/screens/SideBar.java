package com.test.screens;
import com.test.Configurations.Hooks;
import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;


public class SideBar extends Base{

    private List<AndroidElement> lists;
    private AndroidDriver driver;
    private AndroidElement addNewListButton;

    public SideBar() {
        this.driver = new Hooks().getAndroidDriver();
        List<MobileElement> sideBarLinks = this.driver.findElementsById("org.openintents.shopping:id/mode_radio_button");
        this.addNewListButton = (AndroidElement) sideBarLinks.get(sideBarLinks.size()-1);
        this.lists = this.driver.findElementsByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.support.v4.widget.DrawerLayout/android.widget.ListView/android.widget.FrameLayout");
    }

    public List<AndroidElement>  getLists() {
        return lists;
    }

    public AndroidElement getAddNewListButton() {
        return addNewListButton;
    }

}

