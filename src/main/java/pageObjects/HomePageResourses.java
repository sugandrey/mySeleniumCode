package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageResourses {
	
	private WebDriver driver;
	public HomePageResourses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".theme-btn.register-btn")
	private WebElement loginButtton;
	@FindBy(xpath="//h3/span")
	private WebElement text;
	@FindBy(css=".nav.navbar-nav.navbar-right")
	private WebElement navBar;
	@FindBy(xpath="//div[@class='row']/div/p")
	private WebElement title;
	@FindBy(xpath="//button[text()='NO THANKS']")
	private List <WebElement> popup;
	
	
	public LoginPageResourses pressLoginButton() {
		loginButtton.click();
		LoginPageResourses logPage = new LoginPageResourses(driver);
		return logPage;
	}
	public WebElement getHomeText() {
		return text;
	}
	
	public WebElement getNavigationBar() {
		return navBar;
	}
	public WebElement getTitleText() {
		return title;
	}
	public List<WebElement> getPopups() {
		return (List<WebElement>) popup;
	}
	public WebElement getPopUp() {
		return popup.get(0);
	}
}
