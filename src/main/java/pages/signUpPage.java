package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signUpPage {
	

		WebDriver driver;
		
		@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
		WebElement signUpPageLink;
		
		@FindBy(xpath = "//input[@id='firstname']")
		WebElement FirstName;
		
		
		@FindBy(xpath = "//input[@id='lastname']")
		WebElement LastName;
		@FindBy(xpath = "//input[@id='email_address']")
		WebElement email;
		@FindBy(xpath = "//input[@id='password']")
		WebElement password;
		
		@FindBy(xpath = "//input[@id='password-confirmation']")
		WebElement confirmPassword;
		@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
		WebElement createAccountButton;
		
		
		
		
		
		
		public signUpPage(WebDriver driver){
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}
		
		public void clickSignUpLink(){
			signUpPageLink.click();
}
		
		public void setFirstName(String strFirstName){
			FirstName.sendKeys(strFirstName);
			
}
		public void setLastName(String strLastName){
			
			LastName.sendKeys(strLastName);
			
}
		
		public void setEmail(String strEmail){
			email.sendKeys(strEmail);
			
}
		public void setPassword(String strPassword){
			password.sendKeys(strPassword);
			
}
		public void setConfirmPass(String strConfirmPass){
			confirmPassword.sendKeys(strConfirmPass);
			
}			public void clickCreateAccount(){
			createAccountButton.click();
}

			
		
public void signUP(String strFirstName,String strLastName,String strEmail,String strPassword, String strConfirmPass)
{
	
	this.clickSignUpLink();
	this.setFirstName(strFirstName);
	this.setLastName(strLastName);
	this.setEmail(strEmail);
	this.setPassword(strPassword);
	this.setConfirmPass(strConfirmPass);
	this.clickCreateAccount();

}
}