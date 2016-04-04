import org.openqa.selenium.firefox.FirefoxDriver

/*
 * Configuration script for Geb tests. Configuration values might be overwritten using system properties or may be
 * during runtime in Groovy code.
 *
 * See http://www.gebish.org/manual/current/configuration.html for further details.
 */

/* put a directory to put reports in here (only filled by ReportingSpecs */
reportsDir = "target/geb-reports"

/* only report if test failed */
reportOnTestFailureOnly = true

/* clear cookies after each test */
autoClearCookies = true

/* Implicit waiting timings of any element */
waiting {
    timeout = 2
    retryInterval = 0.1
}

driver = { new FirefoxDriver() }
