package test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MM_PIMPage {
    public MM_PIMPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement AddPimBtn;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement LastName;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement SaveBtn;

    public WebElement clickAddPimBtn(){
        return AddPimBtn;
    }
   public WebElement setFirstName(){
        return FirstName;
   }
   public WebElement setLastName(){
        return LastName;
   }
   public void setSaveBtn(){
        SaveBtn.click();
   }
}
