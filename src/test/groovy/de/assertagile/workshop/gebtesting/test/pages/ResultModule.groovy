package de.assertagile.workshop.gebtesting.test.pages

import geb.Module

class ResultModule extends Module {

    static content = {
        heading { $("h3") }
        href { $("cite") }
    }
}
