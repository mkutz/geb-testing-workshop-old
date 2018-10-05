package de.assertagile.workshop.gebtesting.test


import geb.spock.GebSpec

class GoogleUiSpec extends GebSpec {

    def "the Google logo can be found on the Google start page"() {
        when:
        go("https://google.com")

        then:
        $("#hplogo")
    }

    def "the main search input field can be found"() {
        when:
        go("https://google.com")

        then:
        $("#lst-ib")
    }
}
