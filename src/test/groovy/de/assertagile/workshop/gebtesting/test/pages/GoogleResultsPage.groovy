package de.assertagile.workshop.gebtesting.test.pages

import geb.Page

class GoogleResultsPage extends Page {

    static url = "/search"

    static at = { $("#navcnt") }
}
