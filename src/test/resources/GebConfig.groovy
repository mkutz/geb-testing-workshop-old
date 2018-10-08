import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.RemoteWebDriver

/*
 * Configuration script for Geb tests. Configuration values might be overwritten using system properties or may be
 * during runtime in Groovy code.
 *
 * See http://www.gebish.org/manual/current/#configuration for further details.
 */

baseUrl = "https://google.com"

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
chromeDocker = {
    return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new ChromeOptions())
}
firefox = {
    WebDriverManager.firefoxdriver().setup()
    return new FirefoxDriver()
}
firefoxHeadless = {
    WebDriverManager.firefoxdriver().setup()
    return new FirefoxDriver(new FirefoxOptions().addArguments("-headless"))
}
firefoxDocker = {
    return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), new FirefoxOptions())
}

driver = chrome

environments {
    travis {
        driver = firefoxDocker
    }
}
