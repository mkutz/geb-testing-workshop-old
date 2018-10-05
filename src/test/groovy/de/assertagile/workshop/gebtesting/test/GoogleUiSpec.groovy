package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import geb.spock.GebSpec

class GoogleUiSpec extends GebSpec {

    def "the Google logo can be found on the Google start page"() {
        when:
        to(GoogleStartPage)

        then:
        $("#hplogo")
    }

    def "the main search input field can be found"() {
        when:
        to(GoogleStartPage)

        then:
        $("#lst-ib")
    }
}
