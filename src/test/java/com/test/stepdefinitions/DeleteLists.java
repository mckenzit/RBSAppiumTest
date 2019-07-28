package com.test.stepdefinitions;

import com.test.screens.BinaryPopup;
import com.test.screens.ListAdmin;
import com.test.screens.OIList;
import cucumber.api.java.en.When;

public class DeleteLists {
    @When("^I delete the list$")
    public void iDeleteTheFirstList() {
        OIList oiList = new OIList();
        oiList.getListAdmin().click();
        ListAdmin listAdmin = new ListAdmin();
        listAdmin.getDeleteList().click();
        BinaryPopup binaryPopup = new BinaryPopup();
        binaryPopup.getOk().click();
    }
}
