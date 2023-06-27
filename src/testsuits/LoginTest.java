package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";


    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {

         //Enter the Username in Username field
        driver.findElement(By.id("username")).sendKeys("tomsmith");


        // Find the password Field and Enter Password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on Login Button
        driver.findElement(By.xpath("//button[@class='radius']")).click();
        //Verify the text "Secure Area"
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Secure Area page not loaded successfully", expectedText, actualText);


    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        //Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on LOGIN button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Verify the error message "Your username is invalid!"
        String expectedText = "Your username is invalid!\n" + "×";
        String actualText = driver.findElement(By.xpath("//div[1]/div/div|/text()")).getText();
        Assert.assertEquals("Error in invalid message", expectedText, actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        //Enter the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //Click on LOGIN button
        driver.findElement(By.xpath("//button[@class='radius']")).click();

        //Verify the error message"Your password is invalid!"
        String expectedText = "Your password is invalid!\n" + "×";
        String actualText = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Error in  invalid password",expectedText, actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}

