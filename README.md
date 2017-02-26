Geb Testing Workshop
====================
Just a project I use in exercises about UI testing with [Geb] and [Spock]. The workshop won't go into any detail
about [Spock] or testing in [Groovy], so if you realize you don't understand the general structure of the test files,
please checkout [Spock manual] and/or [Groovy documentation] first ;).

Project Setup with Maven
------------------------
In order to get [Spock] and [Geb] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy as a (test) dependency (see [pom.xml](pom.xml#L27-L32)).
2. Add Spock dependency (see [pom.xml](pom.xml#L34-L39)).
3. Add compiler configuration for Groovy since Maven’s default only compiles Java (see [pom.xml](pom.xml#L94-L120)).
4. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L77)).
5. Make Maven Surefire plugin aware of files ending with `*Spec` are test class files since Surefire’s default is `*Test` (see [pom.xml](pom.xml#L122-L133)).
6. Add Geb dependency (see [pom.xml](pom.xml#L41-L46)).
7. Add Selenium dependency (see [pom.xml](pom.xml#L62-L67)).
8. Add something to actually get a [WebDriver] implementation. In this project I chose [WebDriverManager], which can easily be utilized in [Geb]'s configuration (see [pom.xml](pom.xml#L69-L73)).

Objectives
----------
Please checkout the [start branch](https://github.com/mkutz/geb-testing-workshop/tree/01-start) first:
```bash
git checkout 01-start
```

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
[WebDriver]: <http://www.seleniumhq.org/projects/webdriver/>
[WebDriverManager]: <https://github.com/bonigarcia/webdrivermanager>

[GoogleSystemSpec]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/GoogleSystemSpec.groovy>
[GoogleStartPage]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/pages/GoogleStartPage.groovy>
[GoogleUserActor]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/actors/GoogleUserActor.groovy>
[GebConfig]: <src/test/resources/GebConfig.groovy>
