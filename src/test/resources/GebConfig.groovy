import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.testcontainers.containers.BrowserWebDriverContainer

/*
 * Configuration script for Geb tests. Configuration values might be overwritten using system properties or may be
 * during runtime in Groovy code.
 *
 * See http://www.gebish.org/manual/current/#configuration for further details.
 */

/*
 * using WebDriverManager
 * see https://github.com/bonigarcia/webdrivermanager
 */
chrome = {
    WebDriverManager.chromedriver().setup()
    return new ChromeDriver()
}
chromeHeadless = {
    WebDriverManager.chromedriver().setup()
    return new ChromeDriver(new ChromeOptions().addArguments("headless", "disable-gpu"))
}
chromeTestcontainers = {
    BrowserWebDriverContainer container = new BrowserWebDriverContainer()
            .withCapabilities(new ChromeOptions())
    container.start()
    return container.webDriver
}
firefox = {
    WebDriverManager.firefoxdriver().setup()
    return new FirefoxDriver()
}
firefoxHeadless = {
    WebDriverManager.firefoxdriver().setup()
    return new FirefoxDriver(new FirefoxOptions().addArguments("-headless"))
}
firefoxTestcontainers = {
    BrowserWebDriverContainer container = new BrowserWebDriverContainer()
            .withCapabilities(new FirefoxOptions())
    container.start()
    return container.webDriver
}

driver = chrome

environments {
    ci {
        driver = firefoxTestcontainers
    }
}
