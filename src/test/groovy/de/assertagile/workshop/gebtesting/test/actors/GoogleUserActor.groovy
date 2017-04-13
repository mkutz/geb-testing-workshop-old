package de.assertagile.workshop.gebtesting.test.actors

import de.assertagile.workshop.gebtesting.test.pages.GoogleResultPage
import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import de.assertagile.workshop.gebtesting.test.pages.ResultModule
import de.assertagile.workshop.gebtesting.test.pages.SuggestionModule
import geb.Browser

class GoogleUserActor {

    @Delegate
    final Browser browser

    GoogleUserActor(final Browser browser) {
        this.browser = browser
    }

    void searchFor(String query) {
        at(GoogleStartPage).searchInput = query
    }

    List<SuggestionModule> readSuggestions() {
        at(GoogleResultPage).suggestions
    }

    List<ResultModule> readResults() {
        at(GoogleResultPage).results
    }
}
