package de.assertagile.workshop.gebtesting.test.actors

import de.assertagile.workshop.gebtesting.test.pages.GoogleResultPage
import de.assertagile.workshop.gebtesting.test.pages.GoogleStartPage
import de.assertagile.workshop.gebtesting.test.pages.ResultModule
import de.assertagile.workshop.gebtesting.test.pages.SuggestionModule
import geb.Browser

class GoogleUserActor {

    @Delegate
    final Browser browser

    public GoogleUserActor(final Browser browser) {
        this.browser = browser
    }

    public void searchFor(String query) {
        at(GoogleStartPage).searchInput = query
    }

    public List<SuggestionModule> readSuggestions() {
        at(GoogleResultPage).suggestions
    }

    public List<ResultModule> readResults() {
        at(GoogleResultPage).results
    }
}
