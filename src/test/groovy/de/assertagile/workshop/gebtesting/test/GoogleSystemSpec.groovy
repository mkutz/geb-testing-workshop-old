package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    def "the Google start page should be reachable"() {
        when:
        browser.go(GoogleStartPage.url)

        then:
        browser.at(GoogleStartPage)
    }
}
