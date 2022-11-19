package com.trycloud.pages;

import com.trycloud.utilities.Config;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EditFavoriteFilesPage {

    public EditFavoriteFilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user']")
    private WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordBox;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    public void login_method (String username, String password){
        Driver.getDriver().get(Config.getProperty("trycloudEnv"));
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    @FindBy(xpath = "(//span[@class='innernametext'])[1]")
    public WebElement expectedFileName;

    @FindBy(xpath = "(//a[@class='action action-menu permanent'])[1]")
    public WebElement actionMenu;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionList;

    @FindBy(xpath = "(//div[@class='fileActionsMenu popovermenu bubble open menu']//a)[3]")
    public WebElement bubbleOption1;

    @FindBy(xpath = "(//div[@class='fileActionsMenu popovermenu bubble open menu']//a)[8]")
    public WebElement bubbleOption2;

    public WebElement chooseRemoveFromFavorites(String moduleElement){
        String xPath = "//a//span[contains(text(),'"+moduleElement+"')]";
        return (Driver.getDriver().findElement(By.xpath(xPath)));

    }
    public WebElement chooseFromLeftSubModule(String subModuleElemenet){
        String xPath = "//div[@id='app-navigation']//li/a[contains(text(),'"+subModuleElemenet+"')]";
        return (Driver.getDriver().findElement(By.xpath(xPath)));
    }

    @FindBy(xpath = "//td[@class='filename']//span[@class='innernametext']")
    public List<WebElement> favoriteList;

    @FindBy(xpath = "//td[@class='filename ui-draggable ui-draggable-handle']//span[@class='innernametext']")
    public List<WebElement> allList;

    @FindBy(xpath = "//a//span[@class='icon icon-add']")
    public WebElement addBtn;


    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadOpt;

    @FindBy(xpath = "//div//span[@class='icon icon-starred']")
    public List<WebElement> iconStarredList;

}
