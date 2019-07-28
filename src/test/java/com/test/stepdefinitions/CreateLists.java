package com.test.stepdefinitions;
import com.test.screens.NewListPopup;
import com.test.screens.OIList;
import com.test.screens.SideBar;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;

public class CreateLists {

    public OIList oiList;
    public String[] sortedArray;

    @Given("^I am on the shopping list page$")
    public void iAmOnTheShoppingListPage() {
        this.oiList = new OIList();
        this.sortedArray = new String[]{};
    }

    @And("^I add (\\d+) new items$")
    public void iAddNewItems(int arg0) {
        WebDriverWait wait = new WebDriverWait(this.oiList.getDriver(), 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.openintents.shopping:id/autocomplete_add_item")));
        String item1 = "item1";
        String item2 = "item2";
        oiList.getListnameField().sendKeys(item1);
        oiList.getAddButton().click();
        oiList.getListnameField().sendKeys(item2);
        oiList.getAddButton().click();
    }

    @Given("^I create (\\d+) new list$")
    public void iCreateNewLists(int arg0) throws InterruptedException {
        oiList.getNavBar().click();
        SideBar sideBar = new SideBar();
        sideBar.getAddNewListButton().click();
        NewListPopup newListPopup = new NewListPopup();
        newListPopup.getTextField().sendKeys("AnotherList");
        newListPopup.getOk().click();
    }

    @Then("^there should be (\\d+) remaining list$")
    public void thereShouldBeRemainingListContainingItems(int arg0){
        WebDriverWait wait = new WebDriverWait(this.oiList.getDriver(), 8);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.openintents.shopping:id/autocomplete_add_item")));
        oiList.getNavBar().click();
        SideBar sideBar = new SideBar();
        int listNumber = sideBar.getLists().size();
        Assert.assertEquals(listNumber,arg0);
    }


    @And("^I add several new items$")
    public void iAddSeveralNewItems() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(this.oiList.getDriver(), 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.openintents.shopping:id/autocomplete_add_item")));
        this.sortedArray = new String[]{"Irene", "Tim", "Karen", "Bill", "Anna", "Phil", "Dave"};
        for(String name : this.sortedArray){
            oiList.getListnameField().sendKeys(name);
            oiList.getAddButton().click();
        }
        oiList.parseListOfItems();
    }

    @When("^I sort the items$")
    public void iSortTheItems() {
        oiList.getAddButton().click();
        Arrays.sort(this.sortedArray);
    }

    @Then("^they should be in the order I expected$")
    public void theyShouldBeInTheOrderIExpected() throws InterruptedException {
        String[] listOfItemNames = oiList.listOfItemNames();
        Assert.assertArrayEquals(listOfItemNames,this.sortedArray);
    }
}
