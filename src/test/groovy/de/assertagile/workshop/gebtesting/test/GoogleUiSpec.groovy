package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebSpec

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
}
