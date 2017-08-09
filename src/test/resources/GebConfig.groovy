import io.github.bonigarcia.wdm.ChromeDriverManager
import io.github.bonigarcia.wdm.FirefoxDriverManager
import io.github.bonigarcia.wdm.PhantomJsDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

/*
 * Configuration script for Geb tests. Configuration values might be overwritten using system properties or may be
 * during runtime in Groovy code.
 *
 * See http://www.gebish.org/manual/current/#configuration for further details.
 */

/* put a directory to put reports in here (only filled by ReportingSpecs */
reportsDir = "target/geb-reports"

/* only report if test failed */
reportOnTestFailureOnly = true

/* clear cookies after each test */
autoClearCookies = true

/* at checks implicitly wrapped with waitFor */
atCheckWaiting = true

/* Implicit waiting timings of any element */
waiting {
    timeout = 2
    retryInterval = 0.1
}

/*
 * using WebDriverManager
 * see https://github.com/bonigarcia/webdrivermanager
 */
phantomJs = { PhantomJsDriverManager.instance.setup(); return new PhantomJSDriver() }
chrome = { ChromeDriverManager.instance.setup(); return new ChromeDriver() }
firefox = { FirefoxDriverManager.instance.setup(); return new FirefoxDriver() }

driver = chrome

environments {
    travis {
        driver = phantomJs
    }
}
