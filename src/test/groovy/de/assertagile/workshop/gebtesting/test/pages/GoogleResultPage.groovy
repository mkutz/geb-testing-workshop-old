package de.assertagile.workshop.gebtesting.test.pages

import geb.Page

class GoogleResultPage extends Page {

    static at = { $("#logocont") }

    static content = {
        suggestions(wait: true) { $(".sbqs_c").moduleList(SuggestionModule) }
        results(wait: true) { $(".g").moduleList(ResultModule) }
    }
}
