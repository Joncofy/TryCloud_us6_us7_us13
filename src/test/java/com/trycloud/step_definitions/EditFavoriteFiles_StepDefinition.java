package com.trycloud.step_definitions;

import com.trycloud.pages.EditFavoriteFilesPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EditFavoriteFiles_StepDefinition {

    EditFavoriteFilesPage editFavoriteFilesPage = new EditFavoriteFilesPage();
    LoginPage loginPage = new LoginPage();
    Actions actions = new Actions(Driver.getDriver());
    String expected ="";

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
      editFavoriteFilesPage.login_method("User4","Userpass123");
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {

        loginPage.click_on_module_option(string);
        BrowserUtils.waitForPageToLoad(2);
    }

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {
        BrowserUtils.waitFor(2);
        if(editFavoriteFilesPage.allList.size()!=0) {
            BrowserUtils.sleep(2);
            expected = editFavoriteFilesPage.expectedFileName.getText();
            actions.moveToElement(editFavoriteFilesPage.actionMenu).pause(1).click().pause(1).perform();
        } else {
            BrowserUtils.sleep(1);
            actions.moveToElement(editFavoriteFilesPage.addBtn).pause(1).click().perform();
            BrowserUtils.sleep(1);
            editFavoriteFilesPage.uploadOpt.sendKeys("/Users/joncofy/IdeaProjects/TryCloud_us6_us7_us13/src/test/java/com/trycloud/files/AAA.txt");
            BrowserUtils.sleep(1);
        }
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        if(editFavoriteFilesPage.iconStarredList.size()!=0) {
            actions.moveToElement(editFavoriteFilesPage.chooseRemoveFromFavorites(string)).pause(1).click().perform();
            BrowserUtils.waitFor(2);
        } else {
            expected = editFavoriteFilesPage.expectedFileName.getText();
        }
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        actions.moveToElement(editFavoriteFilesPage.chooseFromLeftSubModule(string)).pause(2).click().perform();
        BrowserUtils.waitFor(2);
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        for(WebElement each: editFavoriteFilesPage.favoriteList){
            Assert.assertFalse(expected.equalsIgnoreCase(each.getText()));
        }
        loginPage.click_on_module_option("File");
        BrowserUtils.waitForPageToLoad(2);
            BrowserUtils.sleep(1);
            actions.moveToElement(editFavoriteFilesPage.actionList.get(editFavoriteFilesPage.allList.size()-1)).pause(1).click().perform();
            BrowserUtils.sleep(1);
                actions.moveToElement(editFavoriteFilesPage.bubbleOption1).pause(1).click().perform();
                BrowserUtils.sleep(1);
            }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        BrowserUtils.sleep(1);
        actions.moveToElement(editFavoriteFilesPage.addBtn).pause(1).click().perform();
        BrowserUtils.sleep(2);
    }

    @When("users uploads file with the “upload file” option")
    public void users_uploads_file_with_the_upload_file_option() {
        editFavoriteFilesPage.uploadOpt.sendKeys("/Users/joncofy/IdeaProjects/TryCloud_us6_us7_us13/src/test/java/com/trycloud/files/AAA.txt");
        BrowserUtils.sleep(3);
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        BrowserUtils.sleep(3);

        for(WebElement element:editFavoriteFilesPage.allList){
            if(element.getText().contains("AAA")){
                actions.moveToElement(editFavoriteFilesPage.actionList.get(editFavoriteFilesPage.allList.indexOf(element))).pause(1).click().perform();
                BrowserUtils.sleep(1);
                actions.moveToElement(editFavoriteFilesPage.bubbleOption2).pause(1).click().perform();
                BrowserUtils.sleep(1);
            }
        }
    }
}
