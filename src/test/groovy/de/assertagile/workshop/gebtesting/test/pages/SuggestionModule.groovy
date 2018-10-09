package de.assertagile.workshop.gebtesting.test.pages

import geb.Module

class SuggestionModule extends Module {

    static content = {
        supplement(wait: true) { $("b").text() }
        typed(wait: true) { text() - supplement }
   }
}
