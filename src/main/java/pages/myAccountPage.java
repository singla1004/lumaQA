package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myAccountPage {
	WebDriver driver;
	@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
	WebElement customerMenu;
	
	public myAccountPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	public void clickCustomerMenu(){
		customerMenu.click();
		
	}	public void clickMyAccount(){
		myAccount.click();
}
	public void accountPage() {
		this.clickCustomerMenu();
		this.clickMyAccount();
	}

}
