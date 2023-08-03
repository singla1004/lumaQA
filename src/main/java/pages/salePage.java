package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class salePage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@id='ui-id-8']//span[contains(text(),'Sale')]")
	WebElement salePageLink;
	
	
	public salePage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	public void clickLink()
	{
		salePageLink.click();
	}
	public void clickSaleLink()
	{
		this.clickLink();
	}
	
	
}
