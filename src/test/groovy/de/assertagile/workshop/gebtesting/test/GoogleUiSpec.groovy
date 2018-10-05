package de.assertagile.workshop.gebtesting.test

import geb.spock.GebSpec
import spock.lang.PendingFeature

class GoogleUiSpec extends GebSpec {

    @PendingFeature
    def "the Google logo can be found on the Google start page"() {
        when:
        browser.go("https://google.com")

        then:
        false // TODO
    }
}
