package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class BasePage extends PageGenerator {



    public BasePage(WebDriver driver) {
        super(driver);
    }

    public Actions action = new Actions(driver);

    public Random random = new Random();


    //Click Method
    public <T> void click(T element) {
        if (element.getClass().getName().contains("By")) {
            driver.findElement((By) element).click();


        } else {
            System.out.println("unable to click element,not found.");

        }
    }


    //     LEAVE with no USE fro now to test this FOR radio buttons and check boxes
    public <T> void waitForDisplayedAndEnabledClick(T element) {
        if (element.getClass().getName().contains("By")) {
            boolean elementAttrVisible = driver.findElement((By) element).isDisplayed();
            boolean elementAttrEnabled = driver.findElement((By) element).isEnabled();
            if (elementAttrVisible && elementAttrEnabled) {
                click(element);

            }
        }
    }

    // this is a trial version pfr finding element
    public <T> void waitForVisible_Click(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
            driver.findElement((By) element).click();

        } else {
            System.out.println("Could not find visible element ");
        }
    }

    //this one is a ggod combo to check
    public <T> void isElementPresent_Visible(T element) throws Exception {

        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
            wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
            driver.findElement((By) element).click();

        } else if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.elementToBeClickable((By) element));
            scrollIntoView(element);
            Thread.sleep(250);
        } else {

            System.out.println("Could not find 'present/visible element ");
        }

    }
    //return NoSuchElementException

    public <T> void tryElementPresentClickable_Visible(T element) {
        try {

            if (element.getClass().getName().contains("By")) {
                wait.until(ExpectedConditions.presenceOfElementLocated((By) element));

                wait.until(ExpectedConditions.elementToBeClickable((By) element));
                driver.findElement((By) element).click();

            } else {
                wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
                ((WebElement) element).click();
            }
        } catch (Exception e) {
            System.out.println("Could not find presented element ");
        }
    }

    //Write Text by using JAVA Generics (You can use both By or Webelement)
    protected <T> void writeText(T element, String text) {
        if (element.getClass().getName().contains("By")) {
            driver.findElement((By) element).sendKeys(text);
        } else {
            ((WebElement) element).sendKeys(text);

        }
    }


    public <T> String readText(T element) {
        if (element.getClass().getName().contains("By")) {
            return driver.findElement((By) element).getText();

        } else {
            return ((WebElement) element).getText();

        }
    }


    public void closeChildWindows() {

        // It will return the parent window name as a String
        String mainWindow = driver.getWindowHandle();
        // It returns no. of windows opened by WebDriver and will return Set of Strings
        Set<String> set = driver.getWindowHandles();
        // Using Iterator to iterate within windows
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();
            // Compare whether the main windows is not equal to child window. If not equal, we will close.
            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(driver.switchTo().window(childWindow).getTitle());
                driver.close();
            }
        }
        // This is to switch to the main window
        driver.switchTo().window(mainWindow);
    }

    public <T> void focustoModal(T element) {


        if (element.getClass().getName().contains("By")) {
            driver.switchTo().activeElement();
            driver.findElement((By) element).click();
        } else {
            ((WebElement) element).click();
        }
    }

    public <T> void scrollIntoView(T element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void hoverClick(WebElement element) {

        if (element.getClass().getName().contains("By")) {
            driver.findElement((By) element);
            action.moveToElement(element);
            action.click().build().perform();

        } else
            System.out.println("Unable to hover and click over this element");
    }

    public <T> void waitForStaleness(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.stalenessOf((WebElement) element));
        }
    }

    public <T> void waitForInvisibility(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.invisibilityOf((WebElement) element));
        }

    }

    public <T> void waitForVisibility(T element) {
        if (element.getClass().getName().contains("By")) {
            wait.until(ExpectedConditions.visibilityOf((WebElement) element));
        }

    }

    public <T> void RandomDropDownSelect(T element, T element2) throws Exception {
        if (element.getClass().getName().contains("By")) {
            WebElement dropdown = driver.findElement((By) element);
            // click the dropdown menu
            dropdown.click();
            Thread.sleep(500);
            //get the list
            if (element2.getClass().getName().contains("By")) {
                List<WebElement> list = driver.findElements((By) element2);
                // Get the size of dropdown list
                int size = list.size();
                // Generate the random number
                int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
                // Clicking on random value
                list.get(randomNumber).click();
            }
        }
    }

    public <T> void selectAction(T element) throws Exception {
        if (element.getClass().getName().contains("By")) {
            Select select = new Select(driver.findElement((By) element));
            Thread.sleep(200);
        } else {
            System.out.println("unable to Select element");
        }
    }


    public void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void selectByInt(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);

    }

    public <T> void isElement(T element) {

        if (element.getClass().getName().contains("By")) {
            driver.findElements((By) element).size();
        } else {
            {
                System.out.println("element not found in DOM here");
            }
        }
    }

    public void clickEscapeButton() throws Exception {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ESCAPE);
        r.keyRelease(KeyEvent.VK_ESCAPE);
        driver.switchTo().defaultContent();

    }


    public void scrollDownPageAction() throws Exception {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }


    public void scrollDownPageSection250px() throws Exception {
        ((JavascriptExecutor) driver).executeScript("scroll(0,250);");
        Thread.sleep(500);
    }

    public void scrollDownPageSection750px() throws Exception {
        ((JavascriptExecutor) driver).executeScript("scroll(0,750);");
        Thread.sleep(500);
    }
}