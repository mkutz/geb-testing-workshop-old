Geb Testing Workshop
====================
Just a project I use in exercises about UI testing with [Geb] and [Spock]. The workshop won't go into any detail
about [Spock] or testing in [Groovy], so if you realize you don't understand the general structure of the test files,
please checkout [Spock manual] and/or [Groovy documentation] first ;).

Objectives
----------
- [X] Open [GoogleSystemSpec] and try to execute it. The test should succeed unless
  - Somebody deleted the internet (quite unlikely).
  - The structure of the Google start page has changed (more likely). Please file a bug in that case.
  - Your local setup does not work (even more likely). Please check the [GebConfig] file and try `FirefoxDriver` instead
    of `ChromeDriver`. If it still does not work, please search for help on the exception you see and feel free to file
    a bug.
- [X] Add a feature method in the [GoogleSystemSpec] that verifies the type ahead feature of the Google homepage:
  when the user inputs one letter into the query field, the page changes to [GoogleResultsPage].
- [X] Write another test the verify that suggestions are offered in a dropdown that are based on the input text.
  You might want to look into [Geb manual on waiting DSL]. There is more than one way to solve this.
- [X] Add a test that verifies results are shown when entering three or more letters.
- [X] Try to put the duplicate code from your tests into methods of the [GoogleUserActor].
  For instance write a method, which returns all search results displayed as a list.

Helpful Resources and Further Reading
-------------------------------------
* [Spock manual]
* [Geb manual]


[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>

[Spock]: <https://github.com/spockframework/spock>
[Spock manual]: <http://docs.spockframework.org/>

[Geb]: <http://www.gebish.org/>
[Geb manual]: <http://www.gebish.org/manual/current/>
[Geb manual on browser]: <http://www.gebish.org/manual/current/#browser>
[Geb manual on pages]: <http://www.gebish.org/manual/current/#pages>
[Geb manual on waiting DSL]: <http://www.gebish.org/manual/current/#content-dsl-wait>

[GoogleSystemSpec]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/GoogleSystemSpec.groovy>
[GoogleStartPage]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/pages/GoogleStartPage.groovy>
[GoogleUserActor]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/actors/GoogleUserActor.groovy>
[GebConfig]: <src/test/resources/GebConfig.groovy>
