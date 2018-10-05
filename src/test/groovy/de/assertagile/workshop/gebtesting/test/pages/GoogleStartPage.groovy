package de.assertagile.workshop.gebtesting.test.pages

import geb.Page

class GoogleStartPage extends Page {

    static url = "https://google.com"

    static at = { $("#hplogo") }
}
