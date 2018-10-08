package de.assertagile.workshop.gebtesting.test.pages

import geb.Page
import geb.module.TextInput

class GoogleStartPage extends Page {

    static url = ""

    static at = { $("#hplogo") }

    static content = {
        searchInput { $("input", name: "q").module(TextInput) }
        suggestions(wait: true) { $(role: "option") }
    }
}
