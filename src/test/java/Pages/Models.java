package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Models {
    public Models(WebDriver driver){PageFactory.initElements(driver,this);}
    @FindBy(xpath = "//button[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button onetrust-lg close-icon']")
    public WebElement cookie;
    @FindBy(xpath = "//li//a[@href='/models?filter=suv' and .='View models']")
    public WebElement viewModels;
    @FindBy(xpath = "//ul[@style='position: relative; height: 598.374px;']//li//div[@class='txt']//h5[@class='name']")
    public List<WebElement> models;
    @FindBy(xpath = "//ul[@style='position: relative; height: 598.374px;']//li//div[@class='txt']//span[@class='price']")
    public List<WebElement> prices;
    @FindBy(xpath = "//a[@href='/models/audi-q5']")
    public WebElement vehicleQ5;
}
