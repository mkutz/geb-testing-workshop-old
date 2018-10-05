Geb Testing Workshop (WORK IN PROGRESS)
====================

[![Build Status](https://travis-ci.org/mkutz/geb-testing-workshop.svg?branch=master)](https://travis-ci.org/mkutz/geb-testing-workshop)

Workshop for UI testing with [Geb] and [Spock]. The workshop won't go into any detail
about [Spock] or testing in [Groovy], so if you realize you don't understand the general structure of the test files,
please checkout [Spock manual], the [Groovy documentation] or my [Spock Testing Workshop] first ;).

Project Setup with Maven
------------------------
There are several options to get Groovy code compiled in Maven. See the Groovy documentation on [Groovy Maven integration] for an overview.

In order to get [Spock] and [Geb] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy as a (test) dependency (see [pom.xml](pom.xml#L27-L32)).
2. Add Spock dependency (see [pom.xml](pom.xml#L34-L39)).
3. Add Geb dependency (see [pom.xml](pom.xml#L41-L46)).
4. Add Selenium dependency (see [pom.xml](pom.xml#L62-L67)).
5. Add something to actually get a [WebDriver] implementation. In this project I chose [WebDriverManager], which can easily be utilized in [Geb]'s configuration (see [pom.xml](pom.xml#L69-L73)). It is used in [GebConfig] to download and setup the driver binary (see [GebConfig](src/test/resources/GebConfig.groovy#L28-L35)).
6. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L79)).
7. Add [GMavenPlus] to compile Groovy sources, since Maven’s default settings only compile Java (see [pom.xml](pom.xml#L81-L105)).
8. Make Maven Failsafe plugin aware of files ending with `*UiSpec` are test class files since its default is `*IT` and execute it during integration-test phase (see [pom.xml](pom.xml#L107-L125)).

Part 1: Engine Check
--------------------
In general this project should work just fine. However, we are dealing with quite a stack of technology here: you are
using [Geb], which relies on [WebDriver] to automate a browser that you have installed on your system (and which may
or may not be of the latest version for your system).

So lets check if everything works fine first:
- [ ] Open [GoogleUiSpec] and execute it via your IDE.
  If this did not work for you, please check the following things:
  - Can you (manually) reach the Google start page? If not, please check your internet connection.
  - Did your IDE understand the project structure? Is it fit for [Groovy]? It should generally work out of the box
  for [IntelliJ Idea](https://www.jetbrains.com/idea/download/).
  - If your browser just starts and then does nothing, you probably need a new version of Selenium. So change the
  version in the [pom.xml](pom.xml#L62-L67). Notice that you probably will also need a new version of
  [WebDriverManager] (see [pom.xml](pom.xml#L69-L73)). You can also try to configure a different browser in the
  [GebConfig].
  - If the test fails but generally executes, the structure of the Google start page might have changed and the test
  needs adjustments. Please check for [issues] and feel free to raise a new one.
  - In any other case, please raise an [issue][issues].

Part 2: The Browser
-------------------
First we'll use the Browser instance provided by `GebSpec` to navigate to the main Google page.

- [ ] Add a new feature method to [GoogleUiSpec], that checks if the Google logo can be found on the Google start
page.
- [ ] Write another one to check if the main search input field can be found.

Part 3: Pages
-------------
If you did not refactor your test code, you now have at least one duplicate line of code for navigating to the Google
page. Also you have put some knowledge about the page structure into your test, which will probably keep being
duplicated: the selector for the main search input.

- [ ] Create a `GoogleStartPage` class containing the URL. Now change your features to use the `to` instead of `go` for
navigating to the page.
- [ ] Add an `at` check to your page. Use your selector for the bigger Google logo for this.
- [ ] Move your selector for the main search input field to the page's content.
- [ ] Refactor your features to use the `GoogleStartPage` and contain no more knowledge about the HTML structure.

Part 4: More interaction and waiting
------------------------------------
TODO

- [ ] Add a new feature method to [GoogleUiSpec], which inputs one character into the main search input field.
As you might know, the page will change quite significantly. E.g. the logo disappears and a smaller version appears.
Make your feature method check for that change.

Part 5: Configuration
---------------------
TODO baseUrl, waiting, atCheckWaiting, reporting

- [ ] Configure the `baseUrl` in the [GebConfig] script and change your `GoogleStartPage` to rely on that.

Part 5: Modules
---------------
TODO

- [ ] Create a `ResultModule` allows to access search result's title and URL.
- [ ] Add a list of `ResultModule`s to your `GoogleResultsPage`.
- [ ] Add a feature to your [GoogleUiSpec] to check that when searching for "Wiki" then the top result is
"Wikipedia".

Helpful Resources and Further Reading
-------------------------------------
* [Spock manual]
* [Geb manual]


[Groovy]: <http://www.groovy-lang.org/>
[Groovy documentation]: <http://www.groovy-lang.org/documentation.html>
[Groovy Maven integration]: <http://docs.groovy-lang.org/latest/html/documentation/tools-groovyc.html#_maven_integration>

[Spock]: <https://github.com/spockframework/spock>
[Spock manual]: <http://docs.spockframework.org/>
[Spock Testing Workshop]: <https://github.com/mkutz/spock-testing-workshop>

[Geb]: <http://www.gebish.org/>
[Geb manual]: <http://www.gebish.org/manual/current/>
[Introduction section]: <http://www.gebish.org/manual/current/#introduction>
[Browser section]: <http://www.gebish.org/manual/current/#browser>
[WebDriver implementation section]: <http://www.gebish.org/manual/current/#driver>
[Interacting with content section]: <http://www.gebish.org/manual/current/#navigator>
[Pages section]: <http://www.gebish.org/manual/current/#pages>
[Modules section]: <http://www.gebish.org/manual/current/#modules>
[Configuration section]: <http://www.gebish.org/manual/current/#configuration>
[Implicit assertions section]: <http://www.gebish.org/manual/current/#implicit-assertions>
[Spock, JUnit & TestNG section]: <http://www.gebish.org/manual/current/#spock-junit-testng>
[Javascript, AJAX and dynamic pages seaction]: <http://www.gebish.org/manual/current/#javascript-ajax-and-dynamic-pages>
[Waiting section]: <http://www.gebish.org/manual/current/#waiting>

[GMavenPlus]: <http://groovy.github.io/GMavenPlus/>

[WebDriver]: <http://www.seleniumhq.org/projects/webdriver/>
[WebDriverManager]: <https://github.com/bonigarcia/webdrivermanager>

[GoogleUiSpec]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/GoogleUiSpec.groovy>
[GoogleStartPage]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/pages/GoogleStartPage.groovy>
[GoogleUserActor]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/actors/GoogleUserActor.groovy>
[GebConfig]: <src/test/resources/GebConfig.groovy>

[issues]: </issues>
