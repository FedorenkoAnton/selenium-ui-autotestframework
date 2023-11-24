package dev.selenium.pages;

import dev.selenium.pages.commonpageelements.NavBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static dev.selenium.constants.TimeConstant.TIME_TO_WAIT;

public abstract class BasePage {
    private final WebDriver driver;
    private NavBar navBar;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setNavBar(NavBar navBar) {
        if (this.navBar == null) {
            this.navBar = navBar;
        }
    }

    public NavBar getNavBar() {
        return this.navBar;
    }

    protected void waitUntilExpectedNumberOfElementsPresent(int numberOfElements, String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIME_TO_WAIT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xPath), numberOfElements));
    }

    protected void waitUntilClickable(String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIME_TO_WAIT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    protected void waitUntilAllElementsVisible(String xPath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.of(TIME_TO_WAIT, ChronoUnit.SECONDS));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xPath)));
    }

    protected void scrollIntoView(String xPath) {
        int deltaY = getElementDeltaY(xPath);
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }

    protected void scrollElementIntoViewWithOffset(int elementDeltaY, int offset) {
        int deltaY = elementDeltaY - offset;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();
    }

    protected int getElementDeltaY(String xPath) {
        WebElement element = driver.findElement(By.xpath(xPath));
        WebElement navBar = driver.findElement(By.xpath(getNavBar().getHeader().getXPath()));
        return element.getRect().y - navBar.getRect().height;
    }
}
