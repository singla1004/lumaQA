package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Base.BaseTest;

public class womenJacketPage extends BaseTest{
	WebDriver driver;
	
	@FindBy(xpath = "//a[@id='ui-id-9']")
	WebElement women_menu_top_xpath;
	
	@FindBy(xpath = "//a[@id='ui-id-4']")
	WebElement womenMenu;
	
	
	@FindBy(xpath = "//a[@id='ui-id-11']//span[contains(text(),'Jackets')]")
	WebElement women_menu_top_Jacket_xpath;
	
	
	public womenJacketPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void hoverWomenMenu()
	{
		WebElement mobile= womenMenu;
        Actions act= new Actions(driver);
        act.moveToElement(mobile).build().perform();
	}
	public void hoverWomenTop()
	{
		WebElement mobile= women_menu_top_xpath;
        Actions act= new Actions(driver);
        act.moveToElement(mobile).build().perform();
	}
	
	public void clickJacket()
	{
		women_menu_top_Jacket_xpath.click();
	}
	
	
	public void clickTop()
	{
		this.hoverWomenMenu();
		this.hoverWomenTop();
		this.clickJacket();
		
	}
}
	
	
	
	


