package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.US7;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class US7_StepDef {

    US7 manageFoldersPage = new US7();
    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(Driver.getDriver());

    String newFolderName = "US7NewFolder";
    String uploadedFile = "AAA";

//
//    @Given("user on the dashboard page")
//    public void user_on_the_dashboard_page() {
//        loginPage.navigateTo();
//        loginPage.trycloud_login("User4", "Userpass123");
//        loginPage.user_click_loginBtn();
//    }

    @When("user clicks on {string} module")
    public void user_clicks_on_module(String string) {
        loginPage.click_on_module_option(string);
        BrowserUtils.waitForPageToLoad(2);
    }

    @When("user clicks on add icon on the top")
    public void user_clicks_on_add_icon_on_the_top() {
        BrowserUtils.waitFor(3);
        actions.moveToElement(manageFoldersPage.addButton).pause(2).click().pause(2).perform();
        BrowserUtils.sleep(2);
    }

    @And("user click {string}")
    public void user_click(String string) {
        BrowserUtils.waitFor(3);
        actions.moveToElement(manageFoldersPage.clickNewFolderBtn(string)).pause(2).click().pause(2).perform();
    }

    @And("user write a folder name")
    public void user_write_a_folder_name() {
        BrowserUtils.waitFor(3);
        manageFoldersPage.newFolderTextBox.sendKeys(newFolderName);
        BrowserUtils.sleep(3);
    }

    @And("the user click submit icon")
    public void the_user_click_submit_icon() {
        manageFoldersPage.submitIcon.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtils.waitFor(2);
        for (WebElement each : manageFoldersPage.allList) {
            if (each.getText().equals(newFolderName)) {
                System.out.println(each.getText());
            }
        }
    }


    @When("user choose a folder from the page")
    public void user_choose_a_folder_from_the_page() {
        BrowserUtils.sleep(4);
        for (WebElement each : manageFoldersPage.allList) {
            if (each.getText().equalsIgnoreCase(newFolderName)) {
                actions.moveToElement(each).pause(1).click().pause(1).perform();
            }
        }
    }

    @And("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        BrowserUtils.waitFor(3);
        actions.moveToElement(manageFoldersPage.addButton).pause(2).click().pause(2).perform();
        BrowserUtils.sleep(2);
    }

    @And("the user uploads a file with the upload file option")
    public void the_user_uploads_a_file_with_the_upload_file_option() {
        manageFoldersPage.uploadOpt.sendKeys("/Users/joncofy/IdeaProjects/TryCloud_us6_us7_us13/src/test/java/com/trycloud/files/AAA.txt");
        BrowserUtils.sleep(3);
    }

    @Then("Verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        for (WebElement each : manageFoldersPage.uploadFileNameList) {
            if (each.getText().contains(uploadedFile)) {
                System.out.println(each.getText());
                loginPage.click_on_module_option("File");
            }
        }
        BrowserUtils.waitFor(2);
        for (WebElement each1 : manageFoldersPage.allList) {
            if (each1.getText().equals(newFolderName)) {
                actions.moveToElement(manageFoldersPage.actionList.get(manageFoldersPage.allList.indexOf(each1))).pause(1).click().perform();
                BrowserUtils.sleep(1);
                actions.moveToElement(manageFoldersPage.bubbleOption2).pause(1).click().perform();
                BrowserUtils.sleep(1);
            }
        }


    }
}
