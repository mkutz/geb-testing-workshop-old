package de.assertagile.workshop.gebtesting.test

import geb.spock.GebReportingSpec
import spock.lang.PendingFeature

class GoogleUiSpec extends GebReportingSpec {

    @PendingFeature
    def "the Google logo can be found on the Google start page"() {
        when:
        browser.go("https://google.com")

        then:
        false // TODO
    }
}
