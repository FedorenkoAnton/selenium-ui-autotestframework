package dev.selenium.stepdefinitions;

import dev.selenium.containers.PageFactoryContainer;
import dev.selenium.containers.WebDriverContainer;
import dev.selenium.enums.WebBrowsers;
import dev.selenium.manager.PageFactoryManager;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static dev.selenium.constants.UrlConstants.BASE_URL;

public class GeneralSteps {
    private final PageFactoryContainer pageFactoryContainer;
    private final WebDriverContainer webDriverContainer;

    public GeneralSteps(PageFactoryContainer pageFactoryContainer, WebDriverContainer webDriverContainer) {
        this.pageFactoryContainer = pageFactoryContainer;
        this.webDriverContainer = webDriverContainer;
    }


    @Given("User visit home page")
    public void user_visit_home_page() {
        String browser = System.getenv("browser");
        WebDriver driver = initDriver(browser);
        manageDriver(driver);
        driver.get(BASE_URL);
        pageFactoryContainer.setPageFactoryManager(new PageFactoryManager(driver));
        webDriverContainer.setDriver(driver);
    }

    private void manageDriver(WebDriver driver) {
        driver.manage().window().maximize();
    }

    private WebDriver initDriver(String browserName) {
        WebBrowsers webBrowser = WebBrowsers.from(browserName);
        WebDriver driver = null;

        switch (webBrowser) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
        }

        return driver;
    }
}

