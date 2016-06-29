package de.assertagile.workshop.gebtesting.test.pages

import geb.Module

class SuggestionModule extends Module {

    static content = {
        suppliment { $("b").text() }
    }
}
