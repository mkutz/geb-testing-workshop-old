Geb Testing Workshop
====================
Just a project I use in exercises about UI testing with [Geb] and [Spock]. The workshop won't go into any detail
about [Spock] or testing in [Groovy], so if you realize you don't understand the general structure of the test files,
please checkout [Spock manual] and/or [Groovy documentation] first ;).

Objectives
----------
- [ ] Open [GoogleSystemSpec] and try to execute it. The test should succeed unless somebody deleted the internet or
  (more probable) the structure of the Google start page has changed (please file a bug in that case).
- [ ] Write a simple feature method in [GoogleSystemSpec] that steers the browser to [GoogleStartPage].
  See [Geb manual on browser] and [Geb manual on pages].
- [ ] Write a feature method in the [GoogleSystemSpec] that verifies the type ahead feature of the Google homepage:
  when the user inputs three or more letters into the query field, the page changes to display search results.
- [ ] Write another test the verify that suggestions are offered in a dropdown that are based on the input text.
- [ ] Try to put the duplicate code from your tests into methods of the [GoogleUserActor].
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

[GoogleSystemSpec]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/GoogleSystemSpec.groovy>
[GoogleStartPage]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/pages/GoogleStartPage.groovy>
[GoogleUserActor]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/actors/GoogleUserActor.groovy>
