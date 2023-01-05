package test.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class MM_AdminPage {
    public MM_AdminPage(WebDriver pWebDriver){
        PageFactory.initElements(pWebDriver, this);
    }

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement userAddBtn;

    // Add User
    @FindBy(xpath = "//div[contains(text(),'-- Select --')])[1]")
    WebElement userRole;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(xpath = "//div[contains(text(),'-- Select --')])[2]")
    WebElement status;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active oxd-input--error'])[1]")
    WebElement username;
    @FindBy(xpath = "//input[@type='password'])[1]")
    WebElement password;
    @FindBy(xpath = "//input[@type='password'])[2]")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveBtn;

    public WebElement clickUserAddBtn(){
        return userAddBtn;
    }

    public void selectUserRole(String userRoleInput){
        Select dropdown = new Select(userRole);
        dropdown.selectByIndex(1);
    }
    public void selectEmployeeName(String employeeNameInput){
        employeeName.sendKeys("Lisa");
        Select dropdown = new Select(employeeName);
        dropdown.selectByVisibleText(employeeNameInput);
    }
    public void selectStatus(String statusInput){
        Select dropdown = new Select(status);
        dropdown.selectByVisibleText(statusInput);
    }

    public WebElement setUsername() {
        return username;
    }

    public WebElement setPassword() {
        return password;
    }

    public WebElement setConfirmPassword() {
        return confirmPassword;
    }
    public WebElement clickSaveBtn(){
        return saveBtn;
    }

}
