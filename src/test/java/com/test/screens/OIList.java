package com.test.screens;
import com.test.Configurations.Hooks;
import java.util.ArrayList;
import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;


public class OIList extends Base{

        private AndroidDriver driver;
        private AndroidElement listnameField;
        private AndroidElement addButton;
        private ArrayList<AndroidElement> listItems;

        public OIList(){
                this.driver = new Hooks().getAndroidDriver();
                this.listnameField = (AndroidElement) this.driver.findElement(By.id("org.openintents.shopping:id/autocomplete_add_item"));
                this.addButton = (AndroidElement) this.driver.findElementById("org.openintents.shopping:id/button_add_item");
        }

        public AndroidDriver getDriver() {
                return driver;
        }

        public AndroidElement getListnameField(){
                return listnameField;
        }

        public AndroidElement getAddButton() {
                return this.addButton;
        }

        public ArrayList<AndroidElement> getItems() {
                if (this.listItems == null) {
                        return null;
                } else {
                        return listItems;
                }
        }

        public void parseListOfItems() {
                if (this.listItems != null){
                        this.listItems.clear();
                }
                AndroidElement elem = (AndroidElement) this.driver.findElementById("org.openintents.shopping:id/list_items");
                List<MobileElement> listOfWebElema = elem.findElementsByClassName("android.widget.LinearLayout");
                if (this.listItems == null) {
                        this.listItems = new ArrayList<AndroidElement>();
                }
                for(MobileElement element : listOfWebElema){
                        this.listItems.add((AndroidElement)element);
                }
        }

        public String[] listOfItemNames() {
                parseListOfItems();
                String[] listOfItemNames = new String[this.getItems().size()];
                for(int i = 0; i<= this.getItems().size()-1; i++ ){
                        listOfItemNames[i] = this.getItems().get(i).findElementById("org.openintents.shopping:id/name").getText();
                }
                return listOfItemNames;
        }
}

