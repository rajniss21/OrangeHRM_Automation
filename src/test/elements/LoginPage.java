package test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    public void setEmailInput(String userEmail){emailInput.sendKeys(userEmail);}
    public void setPasswordInput(String userPassword){passwordInput.sendKeys(userPassword);}
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
