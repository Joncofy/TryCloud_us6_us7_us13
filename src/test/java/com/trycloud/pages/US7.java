package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US7 {

    public US7() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a//span[@class='icon icon-add']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderTextBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement submitIcon;

    public WebElement clickNewFolderBtn(String element) {
        String xPath = "//ul//a//span[contains(text(),'" + element + "')]";

        return (Driver.getDriver().findElement(By.xpath(xPath)));
    }

    @FindBy(xpath = "//td[@class='filename ui-draggable ui-draggable-handle']//span[@class='innernametext']")
    public List<WebElement> allList;

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actionList;

    @FindBy(xpath = "(//div[@class='fileActionsMenu popovermenu bubble open menu']//a)[8]")
    public WebElement bubbleOption2;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement uploadOpt;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> uploadFileNameList;

}
