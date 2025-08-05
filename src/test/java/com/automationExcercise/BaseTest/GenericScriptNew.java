package com.automationExcercise.BaseTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.automationExcercise.pageObjects.HomePage;
import com.automationExcercise.pageObjects.SignupPage;
import com.automationExcercise.utilities.ExcellUtilities;
import com.automationExcercise.utilities.ExcellUtilityNew;

public class GenericScriptNew {

    WebDriver driver;
    ExcellUtilityNew excel;

    public GenericScriptNew(WebDriver driver) {
        this.driver = driver;
        this.excel = new ExcellUtilityNew("./Data/TestData.xlsx");
    }

    // ----------------------- RANDOM DATA GENERATORS -----------------------

    public String getRandomAlphabetic(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String getRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public String getRandomNumeric(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String getRandomEmail() {
        return getRandomAlphabetic(6) + "@gmail.com";
    }

    public String getRandomPassword() {
        return getRandomAlphanumeric(8);
    }

    public String getRandomDate() {
        return String.valueOf(new Random().nextInt(30) + 1); // 1 to 30
    }

    public String getRandomYear() {
        return String.valueOf(1900 + new Random().nextInt(2022 - 1900)); // 1900 to 2021
    }

    // ----------------------- ACCOUNT WORKFLOW METHODS -----------------------

    public void createAccountWithRandomData(HomePage home) throws IOException {
        String username = getRandomAlphabetic(4);
        String email = getRandomEmail();

        home.clickSignup();
        Reporter.log("Clicked on Signup link", false);

        assertEquals(home.msgSignupVisible(), true, "'New User Signup!' is not visible");
        Reporter.log("'New User Signup!' is visible", false);

        home.setUserName(username);
        Reporter.log("Entered username: " + username, false);

        home.setEmail(email);
        Reporter.log("Entered email: " + email, false);

        home.clickBtnSignup();
        Reporter.log("Clicked on Signup button", false);

        // Save to Excel
        excel.appendRow("Signups", new String[]{"Username: " + username, "Email: " + email});
    }

    public void fillAccountDetailsWithRandomData(SignupPage signup) throws IOException {
        String password = getRandomPassword();
        String mobile = getRandomNumeric(10);
        String company = getRandomAlphabetic(6);
        String address = getRandomAlphabetic(10);
        String firstName = getRandomAlphabetic(4);
        String lastName = getRandomAlphabetic(4);

        signup.clickMr();
        signup.setPassword(password);
        signup.setDay(getRandomDate());
        signup.setMonth("December");
        signup.setYear(getRandomYear());
        signup.clickSignUpForOurNewsletter();
        signup.clickReceiveSpecialOffersFromOu();
        signup.setfirstName(firstName);
        signup.setlastName(lastName);
        signup.setcompany(company);
        signup.setaddress(address);
        signup.setaddress2(getRandomAlphabetic(10));
        signup.setcountry("Canada");
        signup.setstate("Karnataka");
        signup.setcity("Bangalore");
        signup.setzipcode("754852");
        signup.setmobileNumber(mobile);

        Reporter.log("Filled account details", false);
        signup.clickcreateAccount();

        // Save to Excel
        excel.appendRow("Signups", new String[]{
            "FirstName: " + firstName,
            "LastName: " + lastName,
            "Mobile: " + mobile,
            "Password: " + password
        });
    }

    public void deleteAccount(SignupPage signup) throws InterruptedException, IOException {
        signup.clickdeleteAccount();
        Reporter.log("Clicked on Delete Account", false);

        Thread.sleep(4000); // Consider replacing with WebDriverWait

        signup.clickContinueD();
        Reporter.log("Clicked on Continue after deletion", false);

        assertEquals(driver.getTitle(), "Automation Exercise", "Mismatch in the title");
        Reporter.log("Deleted account successfully, HomePage displayed", false);

        excel.appendRow("Signups", new String[]{"Account Deleted"});
    }
}
