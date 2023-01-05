package test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LandingPage {
    public LandingPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }
    /** Write script for three module:
     * Admin > Add.
     * PIM > Edit & Delete.
     * Recruitment > Add Candidate.
     */
    /**Navigation side-bar elements*/
    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][1]")
    WebElement AdminModule;

    @FindBy(xpath ="//li[@class='oxd-main-menu-item-wrapper'][2]")
    WebElement PIMModule;


    public WebElement clickAdminModule(){
        return AdminModule;
    }
    public WebElement clickOnPIMModule(){
        return PIMModule;
    }








}
