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

    def "when entering one character the page should chang to the results page"() {
        given:
        GoogleStartPage startPage = browser.to(GoogleStartPage)

        when:
        startPage.searchInput = "t"

        then:
        browser.at(GoogleResultPage)
    }

    def "when entering one character suggestions should be displayed"() {
        given:
        GoogleStartPage startPage = browser.to(GoogleStartPage)

        when:
        startPage.searchInput = "t"

        then:
        GoogleResultPage resultPage = browser.at(GoogleResultPage)
        resultPage.suggestions

        and:
        resultPage.suggestions.every { it.text().startsWith("t") }
    }

    def "when entering three or more letters results should be displayed"() {
        given:
        GoogleStartPage page = browser.to(GoogleStartPage)

        when:
        page.searchInput = "rew"

        then:
        GoogleResultPage resultPage = browser.at(GoogleResultPage)

        and:
        resultPage.results
    }
}
