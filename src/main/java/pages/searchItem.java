package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchItem {

	WebDriver driver;
	@FindBy(xpath="//input[@id='search']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@title='Search']")
	WebElement searchButton;
	
	public searchItem(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void setItem(String strItem){
		searchBox.sendKeys(strItem);
}
	public void clickSearchBtn(){
		searchButton.click();
}
	public void search(String strItem) {
		this.setItem(strItem);
		this.clickSearchBtn();
	}
}
