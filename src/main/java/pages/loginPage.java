package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement LogInPageLink;
	
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement Email;
	@FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath = "//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement SignInButton;

	
	
	public loginPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginInLink(){
		LogInPageLink.click();
}
	
	
	
	public void setEmail(String strEmail){
		Email.sendKeys(strEmail);
		
}
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
		
}
	
		
		
	public void clickSignIn(){
				SignInButton.click();
}

		
	
	public void LogIn(String strEmail,String strPassword)
{

		this.clickLoginInLink();
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		this.clickSignIn();

}
}


