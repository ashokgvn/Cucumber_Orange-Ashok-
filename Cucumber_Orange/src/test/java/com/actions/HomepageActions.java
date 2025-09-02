package com.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomepageActions {

    private WebDriverWait wait;

    public HomepageActions(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By homePageText = By.xpath("//h6[normalize-space()='Dashboard']");

    public String getHomePageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(homePageText)).getText();
    }
}
