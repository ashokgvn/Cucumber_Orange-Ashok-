package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	@FindBy(xpath="//input[@placeholder='Username']")
	public WebElement User;
	@FindBy(xpath="//input[@placeholder='Password']")
	public WebElement Pass;
	@FindBy(xpath="//span[text()='Required']")
	public WebElement Req;
	@FindBy(xpath="//button[normalize-space()='Login']")
	public WebElement Login;
	@FindBy(xpath="//p[text()='Invalid credentials']")
	public WebElement Error;
}
