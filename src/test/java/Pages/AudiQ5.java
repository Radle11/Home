package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AudiQ5 {
    public AudiQ5(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='content-overlay-parsys-overlay parsys']//span[@class='extendedbold']")
    public WebElement audi2020Q5;
    @FindBy(xpath = "//div[@class='content-overlay-parsys-overlay parsys']//p//b[@class='text-white']")
    public WebElement startPrice;
    @FindBy(xpath = "//div[@class='content-overlay-parsys-overlay parsys']//a[@href='/models/audi-q5/2020/build' and @title='Build']")
    public WebElement buildButton;
    @FindBy(xpath = "//div[@class='audi-headline-order-3 nm-module-trimline-engine-headline']")
    public List<WebElement> buildVersions;
    @FindBy(xpath = "//span[@class='nm-module-trimline-engine-price-tag']")
    public List<WebElement> buildVersionStarts;
    @FindBy(xpath = "//div[@class='audi-headline-order-3 nm-module-trimline-engine-name']")
    public List<WebElement> versionTypes;
    @FindBy(xpath ="//li[@data-configurator-id='FYB5NY0WPS6W9_2020']//span[@class='audi-checkbox-symbol nm-module-trimline-engine-checkbox']" )
    public WebElement premiumPlus45TFSI;
    @FindBy(xpath = "//a[@href='/models/audi-q5/2020/build/exterior.html']//span[@class='audi-button__text']")
    public WebElement continueButton;
//    @FindBy(xpath = "//span[.='Summary']")
//    public WebElement summaryButton;
    @FindBy(xpath = "//div[contains(@class,'modelPrice')]")
    public WebElement msrp;
    @FindBy(xpath = "//div[contains(@class,'optionsPrice')]")
    public WebElement optionalEquipment;
    @FindBy(xpath = "//div[contains(@class,'destination-charge-amount')]")
    public WebElement destinationCharge;
    @FindBy(xpath = "//div[contains(@class,'totalWithCharges')]")
    public WebElement summaryTotal;
    @FindBy(xpath = "//div[@class='nm-basket-price-text nm-car-price-amount nm-j-configurator-text-totalWithCharges audi-headline-order-3 nm-basket-bold']")
    public WebElement buildPrice;
    @FindBy(xpath = "//img[@src='//mediaservice.audi.com/media/cdb/data/ce0b2c88-97bc-4a04-ba59-394835b2bd37.jpg?alt=//www.audiusa.com/bin/nemo.static/cms4i-nemo/assets/img/fallback/fb-pattern.png']")
    public WebElement navarraBlueMetalic;
    @FindBy(xpath = "//div//div[@class='audi-copy-s' and contains(.,'Navarra Blue metallic')]")
    public WebElement colorName;
    @FindBy(xpath = "//div//div[@class='audi-copy-s' and contains(.,'Navarra Blue metallic')]/following-sibling::*")
    public WebElement colorPrice;
    @FindBy(xpath = "//li[@data-configurator-id='40T_in_PFW']//img")
    public WebElement blackOpticPackage;
    @FindBy(xpath = "//div[.='Black Optic package']")
    public WebElement nameBlackOpticPackage;
    @FindBy(xpath = "//div[@class='nm-j-configurator-text-price nm-price audi-headline-order-3']")
    public WebElement blackOpticPackagePrice;
    @FindBy(xpath = "//span[@class='audi-button__text nm-teaser-equipment-list-item__button-text--contain']")
    public WebElement selectedBox;
    @FindBy(xpath = "//a[@class='nm-pageOpen audi-button audi-button--ghost']")
    public WebElement continueButton2;
    @FindBy(xpath = "//div[@data-configurator-id='Q1D_in_PS8']//span[@class='audi-checkbox-symbol']")
    public WebElement warmWeatherPackage;
    @FindBy(xpath = "//div[.='$1,450']")
    public WebElement warmWeatherPackagePrice;
    @FindBy(xpath = "//div[@class='nm-basket-price-text nm-car-price-amount nm-j-configurator-text-totalWithCharges audi-headline-order-3 nm-basket-bold']")
    public WebElement updatePrice;
    @FindBy(xpath = "//img[@alt='fb-pattern.png']")
    public List<WebElement> interiorColors;
    @FindBy(xpath = "(//span[@class='nm-j-configurator-text-price audi-copy-m'])[2]")
    public WebElement interiorColorPrice;
    @FindBy(xpath = "//img[@alt='High-gloss Gray Oak Wood inlays']")
    public WebElement highGlossInlay;
    @FindBy(xpath = "//img[@alt='Fine Grain Ash Gray Brown Natural Wood inlays']")
    public WebElement ashGreyInlay;
    @FindBy(xpath = "(//span[@class='nm-j-configurator-text-price audi-copy-m'])[12]")
    public WebElement inlayPrice;
    @FindBy(xpath = "//span[.='Continue']")
    public WebElement continueButton3;


    public int parsePrice(WebElement strPrice){
        int intPrice=0;
        if(!strPrice.getText().contains(",")){
            intPrice=Integer.parseInt(strPrice.getText().replace("$",""));
            return intPrice;
        }else{
       intPrice=Integer.parseInt(strPrice.getText().replace("$","").replace(",",""));
   return intPrice;
        }
}

    public boolean getVersionInfo(String... expectedVersions) {
        boolean versionsInfoMatching = false;
        int count = 0;
        for (int i = 0; i < buildVersions.size(); i++) {
            String actual = buildVersions.get(i).getText() + " starting at " + buildVersionStarts.get(i).getText();
            if (actual.equals(expectedVersions[i]))
                count++;
        }
        if (count == 3){
            versionsInfoMatching = true;}
     return versionsInfoMatching;
    }
}