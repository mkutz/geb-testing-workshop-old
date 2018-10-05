package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.pages.GoogleResultsPage
import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebSpec
import org.openqa.selenium.Keys

class GoogleUiSpec extends GebSpec {

    def "the Google logo can be found on the Google start page"() {
        expect:
        to(GoogleStartPage)
    }

    def "the main search input field can be found"() {
        expect:
        to(GoogleStartPage).searchInput
    }

    def "search suggestions are shown on typing once character"() {
        given:
        GoogleStartPage page = to(GoogleStartPage)

        when:
        page.searchInput = "t"

        then:
        page.suggestions
    }

    def "the search input content is changed to a suggestion selected by down key"() {
        given:
        GoogleStartPage page = to(GoogleStartPage)
        page.searchInput = "t"
        waitFor { page.suggestions }

        when:
        page.searchInput << Keys.DOWN

        then:
        page.searchInput.value() == page.suggestions.first().text()
    }

    def "clicking on a suggestion opens the result page for the suggestion"() {
        given:
        GoogleStartPage page = to(GoogleStartPage)
        page.searchInput = "t"

        when:
        page.suggestions.first().click()

        then:
        at(GoogleResultsPage)
    }
}
