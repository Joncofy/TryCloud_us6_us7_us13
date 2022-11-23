package com.trycloud.step_definitions;

import com.trycloud.pages.US13;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Config;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US13_StepDefs {
    US13 US13 = new US13();
//    LoginPage loginPage = new LoginPage();
//    @Given("user on the dashboard page")
//    public void user_on_the_dashboard_page() {
//        Driver.getDriver().get(Config.getProperty("trycloudEnv"));
//
//        loginPage.navigateTo();
//        loginPage.trycloud_login(Config.getProperty("username"), Config.getProperty("password"));
//        loginPage.user_click_loginBtn();
//        US13.dashboardPage.click();
//
//
//        BrowserUtils.waitFor(5);
//
//        //BrowserUtils.waitUntilVisible(contactPage.contacts, 20);
//        verify_the_contact_names_are_in_the_list();
//    }
    @When("the user clicks the contacts module")
    public void the_user_clicks_the_contacts_module() {
        BrowserUtils.waitFor(5);
        US13.dashboardPage.click();
        BrowserUtils.waitFor(5);
        US13.contacts.click();

    }
    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        Assert.assertTrue(US13.getContactNames().size() != 0);
    }

}
