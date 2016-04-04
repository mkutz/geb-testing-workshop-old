package de.assertagile.workshop.gebtesting.test.actors

import geb.Browser

class GoogleUserActor {

    @Delegate
    final Browser browser

    public GoogleUserActor(final Browser browser) {
        this.browser = browser
    }
}