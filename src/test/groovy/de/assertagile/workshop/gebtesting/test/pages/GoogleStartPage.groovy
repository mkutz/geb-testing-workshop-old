package de.assertagile.workshop.gebtesting.test.pages

import geb.Page

class GoogleStartPage extends Page {

    static url = ""

    static at = { $("#hplogo") }

    static content = {
        searchInput { $("#lst-ib") }
        suggestions(wait: true) { $(".sbqs_c") }
    }
}
