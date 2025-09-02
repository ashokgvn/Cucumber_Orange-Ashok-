package com.actions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	
	private static WebDriver driver;
	
	public static void setUpDriver() {
		WebDriverManager.chromedriver().setup(); // auto-driver setup
		driver = new ChromeDriver();
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public static WebDriver getDriver() {
        return driver;
    }
	
	public static void openPage(String url) {
        driver.get(url);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // reset for next scenario
        }
    }
}
