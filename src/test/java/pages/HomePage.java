package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//
public class HomePage extends BasePage  {


    //*********Page Variables*********
    @FindBy(css = "insertWebElement")
    public WebElement webElementName;
    @FindBy(css = "insertWebElement")
    public WebElement webElementName1;
    @FindBy(css = "insertWebElement")
    public WebElement webElementName2;
    @FindBy(css = "insertWebElement")
    public WebElement webElementName3;
    @FindBy(css = "insertWebElement")
    public WebElement webElementName4;

    @FindBy(css = "insertWebElement")
    public WebElement errorMessageUsername;
    @FindBy(css = "insertWebElement")
    public WebElement errorMessagePassword;
    @FindBy(css = "insertWebElement")
    public WebElement errorMessageEmpty;

//this 'HOW' is another name to call on the  variable whie page loads.
    @FindBy(how = How.XPATH, using = "insertWebElement")
    public WebElement webElementName5;


    //*********CONSTRUCTOR*********
    public HomePage(WebDriver driver) {
       super(driver);
    }



    public void testSomething() {
        // List to hold the value we will return to the caller.
        List<String> currentOptions = new ArrayList<>();


        // This is the 'By.xpath' lookup used to find the dropdown field
        By openDestinations = By.cssSelector("");
        // Find the 'destinations' drop down on the page.
        WebElement select = driver.findElement(openDestinations); // Find the drop down
        click(openDestinations);

        // Pull out the options as web elements
        List<WebElement> matches = select.findElements(By.xpath(""));

        // Traverse the web elements to extract the text. Text gets added to the 'currentOptions' List
        for (WebElement match : matches) {
            currentOptions.add(match.getText());
        }

        System.out.println(currentOptions);

        // return the List of Strings pulled out of the 'options' back to the caller.
    }
// CHECK IF ITS RETURNING somethigN ON TH ECONSOLE OTHERWISE LOOK FOR  HOW TO PRINT IN THE OUTPU OF CONSOLE.

    public void selectShipDestination() {
        scrollIntoView(webElementName4);
        System.out.println(webElementName4 + "testing message before the return");

    }


    public String addElementsFromArray() {

        List<WebElement> arr = new ArrayList<>();
        arr.add(webElementName);
        arr.add(webElementName1);
        arr.add(webElementName2);
        int randomNumber = random.nextInt(arr.size());
        return String.valueOf(randomNumber);
    }

    public void selectApplybutton() {
        scrollIntoView(webElementName3);
    }



    //EXAMPLE POM PAGE expected text will be added in the test portion so it does not affect tests cases
    //Verify Username Condition
    public void verifyLoginUserName(String expectedText) {
        Assert.assertEquals(readText(errorMessageUsername), expectedText);

    }

    //Verify Password Condition
    public void verifyLoginPassword(String expectedText) {
        Assert.assertEquals(readText(errorMessagePassword), expectedText);

    }

    //Verify Password Condition
    public void verifyEmptyLogin(String expectedText) {
        Assert.assertEquals(readText(errorMessageEmpty), expectedText);

    }



    /* Using PageFactory BY selenium we call the page and its elements before the page starts looking for th elements to avoid 'stale' o 'element not found'.
     */

//    public pagename1 goToPageName) {
//        RegisterButton.click();
//        return new PageFactory().initElements(driver, pagename1.class);
//    }


}