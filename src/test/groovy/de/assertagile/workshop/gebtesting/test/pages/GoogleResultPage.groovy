package de.assertagile.workshop.gebtesting.test.pages

import geb.Page

class GoogleResultPage extends Page {

    static at = { $("#logocont") }

    static content = {
        suggestions(wait: true) { $(".sbsb_b li").moduleList(SuggestionModule) }
    }
}
