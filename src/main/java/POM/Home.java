package POM;

import Actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home {

    String homeURL = "https://www.levelset.com/";
    WebDriver driver;
    Actions act;
    By getPaidButton = new By.ByXPath("//a[contains(text(),'Get paid ')]");
    By expectedList = new By.ByXPath("//div[@class='section']");

    public Home(WebDriver driver)
    {
        this.driver = driver;
        act = new Actions(driver);
    }

    public void navigateToHomePage() {

        act.navigatePage(homeURL,5,getPaidButton);
    }

    public void clickOnGetPaid()
    {

        act.clickElement(getPaidButton,5,expectedList,homeURL);

    }




}
