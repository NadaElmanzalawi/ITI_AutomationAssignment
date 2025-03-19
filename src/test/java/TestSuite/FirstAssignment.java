package TestSuite;

import POM.SelectDoc;
import POM.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class FirstAssignment {
    WebDriver driver;
    Home home;
    SelectDoc doc;
    @BeforeTest
    public void setup()
    {
        driver = new ChromeDriver();
        home = new Home(driver);
        doc = new SelectDoc(driver);
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }

    @Test
    void testFreeNumber()
    {
        doc.navigateToSelectDocPage();
        int actualFreeDocsCount = doc.getFreeNumber();
        int expecetedFreeDocsCount = 2;
        Assert.assertEquals(actualFreeDocsCount, expecetedFreeDocsCount);
    }
    @Test
    void testRangeNumber()
    {
        doc.navigateToSelectDocPage();
        int actualPaidDocsCount = doc.getPaidRangeNumber(30,60);
        int expecetedPaidDocsCount = 1;
        Assert.assertEquals(actualPaidDocsCount, expecetedPaidDocsCount);
    }
    @Test
    void testFreeNames()
    {
        doc.navigateToSelectDocPage();
        String[] actualFreeDocsNames = doc.getFreeNames();
        String[] expectedFreeDocsNames = {"Exchange a Waiver", "Send a Payment Document"};
        Assert.assertEquals(actualFreeDocsNames[0], expectedFreeDocsNames[0]);
        Assert.assertEquals(actualFreeDocsNames[1], expectedFreeDocsNames[1]);
    }
    @Test
    void testRangeNames()
    {
        doc.navigateToSelectDocPage();
        String[] actualPaidDocsNames = doc.getPaidRangeNames(30,60);
        String[] expectedPaidDocsNames = {"Send a Warning"};
        Assert.assertEquals(actualPaidDocsNames[0], expectedPaidDocsNames[0]);
    }





}
