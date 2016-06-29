package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.pages.GoogleResultPage
import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    def "the Google start page should be reachable"() {
        when:
        browser.go(GoogleStartPage.url)

        then:
        browser.at(GoogleStartPage)
    }

    def "when entering one character suggestions should be displayed"() {
        given:
        GoogleStartPage startPage = browser.to(GoogleStartPage)

        when:
        startPage.searchInput = "t"

        then:
        GoogleResultPage resultPage = browser.at(GoogleResultPage)

        and:
        resultPage.suggestions
    }
}
