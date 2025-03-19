package POM;

import Actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class SelectDoc {
    WebDriver driver;
    Actions act;
    By freeDocLocator = new By.ByXPath("//div[@class='section']//span[@class='price-amount' and contains(text(),'Free')]");
    By freeDocNameLocator = new By.ByXPath("//div[@class='section']//span[@class='price-amount' and contains(text(),'Free')]/ancestor::div[@class='panel-heading left-right-pair']/div[@class='left']");
    By expectedList = new By.ByXPath("//div[@class='section']");
    String selectDoc = "https://app.levelset.com/wizard/SelectDocument/";
    String dynamicRange = "//span[@class='price-amount' and number(translate(text(),'$',''))>=%d and number(translate(text(),'$',''))<=%d]/ancestor::div[@class='panel-heading left-right-pair']//div[@class='left']";


    public SelectDoc(WebDriver driver)
    {
        this.driver = driver;
        act = new Actions(driver);

    }

    public void navigateToSelectDocPage()
    {
        act.navigatePage(selectDoc,5,expectedList);
    }

    public int getFreeNumber()
    {
        List<WebElement> freeElements = act.findElements(freeDocLocator);
        return freeElements.size();
    }

    public int getPaidRangeNumber(int lower, int upper)
    {
        By rangeLocator = new By.ByXPath(String.format(dynamicRange,lower,upper));
        List<WebElement> paidElements = act.findElements(rangeLocator);
        return paidElements.size();
    }

    public String[] getFreeNames()
    {
        List<WebElement> freeDocsNamesElements = act.findElements(freeDocNameLocator);
        String[] strArr = new String[freeDocsNamesElements.size()];
        for(int i = 0 ;i<freeDocsNamesElements.size();i++)
        {
            strArr[i]=freeDocsNamesElements.get(i).getText();
        }
        return strArr;
    }

    public String[] getPaidRangeNames(int lower, int upper)
    {
        By rangeLocator = new By.ByXPath(String.format(dynamicRange,lower,upper));
        List<WebElement> paidElements = act.findElements(rangeLocator);
        String[] strArr = new String[paidElements.size()];
        for(int i = 0 ;i<paidElements.size();i++)
        {
            strArr[i]=paidElements.get(i).getText();
        }
        return strArr;
    }








}
