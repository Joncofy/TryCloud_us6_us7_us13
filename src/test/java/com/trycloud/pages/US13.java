package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class US13 extends LoginPage{
    public US13() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[6]/a")
    public WebElement dashboardPage;

    @FindBy(xpath = "//*[@id=\"contacts-list\"]/div[1]")
    public WebElement contacts;


    //@FindBy(id = "//*[@id=\"contacts-list\"]/div[1]")

    //public List<WebElement> contactNamesElements;
    public List<String> getContactNames() {
        List<String> contactNames = new ArrayList<>();
        List<WebElement> contactElements = contacts.findElements(By.className("app-content-list-item-line-one"));
        for (WebElement contactElement : contactElements) {
            contactNames.add(contactElement.getText());
        }
        return contactNames;
    }
}
