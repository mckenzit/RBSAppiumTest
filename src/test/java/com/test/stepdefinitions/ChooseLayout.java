package com.test.stepdefinitions;
import com.test.screens.Layout;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;


public class ChooseLayout {

    private Layout layout;

    @Given("^I am on the layout page$")
    public void iAmOnTheLayoutPage(){
        this.layout = new Layout();
    }

    @And("^I choose \"([^\"]*)\" layout$")
    public void iChooseLayout(String arg0) {
        if(arg0.equals("bar")){
            this.layout.getButtonLayoutChoiceBar().click();
        } else {
            this.layout.getButtonLayoutChoiceBottom().click();
        }
    }
}
