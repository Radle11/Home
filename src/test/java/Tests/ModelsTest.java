package Tests;

import Pages.AudiQ5;
import Pages.Models;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModelsTest extends TestBase{
    WebDriverWait wait;
    AudiQ5 audiQ5;
    Actions actions;
    Models models;
    @BeforeClass
    public void setModelsTest(){
        models=new Models(driver);
        audiQ5=new AudiQ5(driver);
        wait=new WebDriverWait(driver,5);
    }
    @Test
    public void test1() throws InterruptedException {
        driver.navigate().to("https://www.audiusa.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(models.cookie));
        models.cookie.click();

        models.viewModels.click();
        System.out.println(models.models.size());
        System.out.println(models.prices.size());
        Iterator<WebElement> i1= models.models.iterator();
        Iterator<WebElement> i2= models.prices.iterator();
        while(i1.hasNext() && i2.hasNext()){System.out.println(i1.next().getText()+" "+i2.next().getText());}
        models.vehicleQ5.click();
        //#1

        wait.until(ExpectedConditions.visibilityOf(audiQ5.audi2020Q5));
        String actualHeader=audiQ5.audi2020Q5.getText();
         System.out.println(audiQ5.audi2020Q5.getText());
        String expectedHeader = "2020 Audi Q5";
         Assert.assertEquals(actualHeader,expectedHeader,"test1 #1 Test Failed.");
        //#2
        String actualStartAt = audiQ5.startPrice.getText().substring(audiQ5.startPrice.getText().indexOf("$") + 1);
        String expectedStartAt = "43,300";
        Assert.assertEquals(actualStartAt, expectedStartAt, "test1 #2 Test Failed.");
        audiQ5.buildButton.click();
        //#3
        String[] expectedVersionsInfo = {
                "Premium starting at $ 43,300",
                "Premium Plus starting at $ 47,700",
                "Prestige starting at $ 51,450"};
        Assert.assertTrue(audiQ5.getVersionInfo(expectedVersionsInfo), "test1 #3 Test Failed.");
        //#4
        String[] expectedVersionTypes = {
                "45 TFSI®",
                "45 TFSI® Titanium",
                "55 TFSI® e Plug-in hybrid",
                "45 TFSI®",
                "45 TFSI® Titanium",
                "55 TFSI® e Plug-in hybrid",
                "45 TFSI®",
                "45 TFSI® Titanium",
                "55 TFSI® e Plug-in hybrid"};
//        System.out.println(Arrays.toString(expectedVersionTypes));
//        System.out.println(expectedVersionTypes.length);
//        System.out.println(audiQ5.versionTypes.size());
        int matchCount = 0, z = 0;
        for (; z < audiQ5.versionTypes.size(); z++) {
            if (audiQ5.versionTypes.get(z).getText().equals(expectedVersionTypes[z])) {
                matchCount++;
            }
        }
        Assert.assertTrue(matchCount == expectedVersionTypes.length, "test1 #4 Test Test Failed.");
    }
    @Test
        public void test2() throws AWTException, InterruptedException {
        //#1
        audiQ5.premiumPlus45TFSI.click();
        audiQ5.continueButton.click();
       /* Robot robot = new Robot();
        for (int i = 0; i < 1; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_SUBTRACT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }*/
       // wait.until(ExpectedConditions.visibilityOf(audiQ5.optionalEquipment));
        //audiQ5.summaryButton.click();
        Thread.sleep(1000);
        System.out.println(audiQ5.optionalEquipment.getText()+audiQ5.optionalEquipment.getText().length());
        int actualOptionalEquipment = audiQ5.parsePrice(audiQ5.optionalEquipment);
        int expectedOptionalEquipment = 0;//optional equipment price:$0
        Assert.assertEquals(actualOptionalEquipment, expectedOptionalEquipment, "test2 #1 Test Failed.");
        //#2
        driver.navigate().back();
        //int actualBuildPrice=Integer.parseInt(audiQ5.buildPrice.getText().replace("$","").replace(",",""));//$48,695
        int actualBuildPrice = audiQ5.parsePrice(audiQ5.buildPrice);
        //int expectedBuildPrice=(Integer.parseInt(audiQ5.buildVersionStarts.get(1).getText().replace("$","").replace(",","")))+995;
        System.out.println("asdf" + audiQ5.msrp.getText());
        int expectedBuildPrice = audiQ5.parsePrice(audiQ5.msrp) + 995;
        Assert.assertEquals(actualBuildPrice, expectedBuildPrice, "test2 #2 Test Failed.");
        //#3
        actions.moveToElement(audiQ5.navarraBlueMetalic).build().perform();
        String actualColorName = audiQ5.colorName.getText().trim();
        String expectedColorName = "Navarra Blue metallic";
        Assert.assertEquals(actualColorName, expectedColorName, "test2 #3 Test Failed.");
        //#4
        String actualColorPrice = audiQ5.colorPrice.getText();
        String expectedColorPrice = "$595";
        Assert.assertEquals(actualColorPrice, expectedColorPrice, "test2 #4 Test Failed.");
        actions.click(audiQ5.navarraBlueMetalic);
        //#5
        // actualBuildPrice=Integer.parseInt(audiQ5.buildPrice.getText().replace("$","").replace(",",""));//$49,290
        actualBuildPrice = audiQ5.parsePrice(audiQ5.buildPrice);
        int colorPriceParse = Integer.parseInt(actualColorPrice.replace("$", ""));
        int expectedNewBuildPrice = expectedBuildPrice + colorPriceParse;
        Assert.assertEquals(actualBuildPrice, expectedNewBuildPrice, "test2 #5 Test Failed.");
        //#6
        audiQ5.blackOpticPackage.click();
        String actualBlackOpticPackage = audiQ5.nameBlackOpticPackage.getText() + " " + audiQ5.blackOpticPackagePrice.getText();
        String expectedBlackOpticPackage = "Black Optic package $1,300";
        Assert.assertEquals(actualBlackOpticPackage, expectedBlackOpticPackage, "test2 #6 Test Failed.");
        //#7
        String actualBoxText = audiQ5.selectedBox.getText();
        String expectedBoxText = "Selected";
        Assert.assertEquals(actualBoxText, expectedBoxText, "test1 #7 Test Failed.");
        audiQ5.continueButton2.click();
    }
//    @Test
//        public void test3(){
//    //#1
//        audiQ5.warmWeatherPackage.click();
//        int actualUpdatePrice=audiQ5.parsePrice(audiQ5.updatePrice);//$52,040
//        int colorPriceParse = audiQ5.parsePrice(audiQ5.colorPrice);
//
//        int expectedNewBuildPrice = expectedBuildPrice + colorPriceParse;
//        int expectedUpdatePrice=expectedNewBuildPrice+audiQ5.parsePrice(audiQ5.warmWeatherPackagePrice);
//        Assert.assertEquals(actualUpdatePrice,expectedUpdatePrice,"test3 #1 Test Failed.");
//    //#2
//        audiQ5.summaryButton.click();
//        int msrp=audiQ5.parsePrice(audiQ5.msrp);
//        int equipmenntPrice=audiQ5.parsePrice(audiQ5.optionalEquipment);
//        int destinationCharge=audiQ5.parsePrice(audiQ5.destinationCharge);
//        int actualSummaryTotal=audiQ5.parsePrice(audiQ5.summaryTotal);
//        int expectedSummaryTotal=equipmenntPrice+destinationCharge+msrp;
//        Assert.assertEquals(actualSummaryTotal,expectedSummaryTotal,"test3 #2 Test Failed.");
//    //#3
//        driver.navigate().back();
//        int interiorColorAmount=audiQ5.interiorColors.size();
//        int priceZeroCount=0;
//        for (int k=0;k<interiorColorAmount;k++){
//            actions.moveToElement(audiQ5.interiorColors.get(k));
//            if (audiQ5.interiorColorPrice.getText().equals("$0")){
//                priceZeroCount++;
//            }
//        }
//        Assert.assertEquals(priceZeroCount,"$0","test3 #3 Test Failed");
//    //4
//        actions.moveToElement(audiQ5.highGlossInlay);
//        Assert.assertEquals(audiQ5.inlayPrice.getText(),"$0","test3 #15 Test Failed.");
//        actions.moveToElement(audiQ5.ashGreyInlay);
//        Assert.assertTrue(audiQ5.inlayPrice.equals("$0"),"test3 #4 Test Failed.");
//        audiQ5.continueButton3.click();
//
//
//
//
//
//    }
}
