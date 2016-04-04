package de.assertagile.workshop.gebtesting.test

import de.assertagile.workshop.gebtesting.test.actors.GoogleUserActor
import geb.spock.GebReportingSpec

class GoogleSystemSpec extends GebReportingSpec {

    final GoogleUserActor user = new GoogleUserActor(browser)

    def "typing a single letter should make suggestions appear"() {
        // TODO
    }
}