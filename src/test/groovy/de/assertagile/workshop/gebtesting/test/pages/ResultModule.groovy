package de.assertagile.workshop.gebtesting.test.pages

import geb.Module

class ResultModule extends Module {

    static content = {
        title { $(".r").text() }
        url { $(".f").text() }
    }
}
