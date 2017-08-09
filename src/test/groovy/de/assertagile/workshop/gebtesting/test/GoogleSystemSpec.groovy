package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.actors.GoogleUserActor
import de.assertagile.workshop.gebtesting.test.pages.GoogleResultPage
import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    GoogleUserActor user = new GoogleUserActor(browser)

    def setup() {
        user.to(GoogleStartPage)
    }

    def "the Google start page should be reachable"() {
        expect:
        browser.at(GoogleStartPage)
    }

    def "when entering one character the page should chang to the results page"() {
        when:
        user.searchFor("t")

        then:
        browser.at(GoogleResultPage)
    }

    def "when entering one character suggestions should be displayed"() {
        when:
        user.searchFor("t")

        then:
        user.readSuggestions()

        and:
        user.readSuggestions()*.text().every { it.startsWith("t") }
    }

    def "pressing enter should display the results page"() {
        when:
        user.searchFor("rewe.")

        and:
        user.submitSearch()

        then:
        user.readResults()
    }
}
