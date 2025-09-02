package com.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageActions {

	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Username field
	private By usernameField = By.xpath("//input[@placeholder='Username']");
	private By passwordField = By.xpath("//input[@placeholder='Password']");
	private By loginButton = By.xpath("//button[normalize-space()='Login']");
	private By errorMessage = By.xpath("//p[text()='Invalid credentials']");
	private By missingText = By.xpath("(//span[text()='Required'])[1]");

	// Login method
	public void login(String user, String pass) throws InterruptedException {
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(user);

		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);

		WebElement loginBtn = driver.findElement(loginButton);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		Thread.sleep(5000);
	}
	
	// Get error message text
	public String getErrorMsg() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
	}

	// Get missing field message text
	public String getMissingText() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(missingText)).getText();
	}
}
