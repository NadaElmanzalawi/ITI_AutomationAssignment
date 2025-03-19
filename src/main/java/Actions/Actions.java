package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Actions {
    WebDriver driver;
    public Actions(WebDriver driver)
    {
        this.driver = driver;
    }

    public void navigatePage(String pageURL, int waitTime, By expectedElement)
    {
        driver.get(pageURL);
        new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
    }


    public void clickElement(By elementLocator, int waitTime, By expectedElement,String pageURL)
    {
        driver.findElement(elementLocator).click();
        try{
            new WebDriverWait(driver,Duration.ofSeconds(waitTime)).until(ExpectedConditions.visibilityOfElementLocated(expectedElement));

        }catch (Exception e)
        {
            driver.get(pageURL);
            driver.findElement(elementLocator).click();
            driver.findElement(elementLocator).click();
            if(new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until(ExpectedConditions.visibilityOfElementLocated(expectedElement))==null){
                System.out.println("Element not found");
            }
        }
    }

    public WebElement findElement(By requiredElement)
    {
        return driver.findElement(requiredElement);
    }

    public List<WebElement> findElements(By requiredElements)
    {
        return driver.findElements(requiredElements);
    }




}
