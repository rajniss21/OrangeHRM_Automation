package test.tests;

import org.testng.annotations.Test;
import test.elements.LandingPage;
import test.elements.MM_AdminPage;
import test.elements.MM_PIMPage;

public class AllTest extends Setup{

    @Test
    public void loginWithValidCredentialsTest() throws InterruptedException {

        loginToTheModule();
        Thread.sleep(5000);
    }
    @Test
    public void testToAddAdminUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(myWebDriver);
        MM_AdminPage mm_adminPageObj = new MM_AdminPage(myWebDriver);

        loginToTheModule();
        waitForThisTobeClickable(landingPageObj.clickAdminModule());
        landingPageObj.clickAdminModule().click();
        waitForThisTobeClickable(mm_adminPageObj.clickUserAddBtn());
        mm_adminPageObj.clickUserAddBtn().click();
        Thread.sleep(3000);
        mm_adminPageObj.selectUserRole("Admin");
        Thread.sleep(1000);
        mm_adminPageObj.selectEmployeeName("Lisa Andrews");
        Thread.sleep(1000);
        mm_adminPageObj.selectStatus("Enabled");
        Thread.sleep(1000);
        mm_adminPageObj.setUsername().sendKeys("Jack Ryan");
        Thread.sleep(1000);
        mm_adminPageObj.setConfirmPassword().sendKeys("Admin123@");
        Thread.sleep(1000);
        mm_adminPageObj.setConfirmPassword().sendKeys("Admin123@");
        Thread.sleep(2000);
        mm_adminPageObj.clickSaveBtn().click();
    }

    @Test
    public void testToAddPimUser() throws InterruptedException{
        LandingPage landingPageObj = new LandingPage(myWebDriver);
        MM_PIMPage mm_pimPageObj = new MM_PIMPage(myWebDriver);
        loginToTheModule();
        waitForThisTobeClickable(landingPageObj.clickOnPIMModule());
        landingPageObj.clickOnPIMModule().click();
        waitForThisTobeClickable(mm_pimPageObj.clickAddPimBtn());
        mm_pimPageObj.clickAddPimBtn().click();
        waitForThisTobeClickable(mm_pimPageObj.setFirstName());
        mm_pimPageObj.setFirstName().sendKeys("Rajnish");
        waitForThisTobeClickable(mm_pimPageObj.setLastName());
        mm_pimPageObj.setLastName().sendKeys("Pradhan");
        mm_pimPageObj.setSaveBtn();
    }

}
