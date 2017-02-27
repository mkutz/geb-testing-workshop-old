Geb Testing Workshop (WORK IN PROGRESS)
====================
Just a project I use in exercises about UI testing with [Geb] and [Spock]. The workshop won't go into any detail
about [Spock] or testing in [Groovy], so if you realize you don't understand the general structure of the test files,
please checkout [Spock manual], the [Groovy documentation] or my [Spock Testing Workshop] first ;).

Project Setup with Maven
------------------------
In order to get [Spock] and [Geb] into our Maven project, we need to do the following in our [pom.xml].

1. Add Groovy as a (test) dependency (see [pom.xml](pom.xml#L27-L32)).
2. Add Spock dependency (see [pom.xml](pom.xml#L34-L39)).
3. Add compiler configuration for Groovy since Maven’s default only compiles Java (see [pom.xml](pom.xml#L94-L120)).
4. Make Maven aware of `/src/test/groovy` being a test source directory since Maven’s default is `/src/test/java` (see [pom.xml](pom.xml#L77)).
5. Make Maven Surefire plugin aware of files ending with `*Spec` are test class files since Surefire’s default is 
`*Test` (see [pom.xml](pom.xml#L122-L133)).
6. Add Geb dependency (see [pom.xml](pom.xml#L41-L46)).
7. Add Selenium dependency (see [pom.xml](pom.xml#L62-L67)).
8. Add something to actually get a [WebDriver] implementation. In this project I chose [WebDriverManager], which can 
easily be utilized in [Geb]'s configuration (see [pom.xml](pom.xml#L69-L73)). It is used in [GebConfig] to download 
and setup the driver binary (see [GebConfig](src/test/resources/GebConfig.groovy#L28-L35)).

Part 1: Engine Check
--------------------
In general this project should work just fine. However, we are dealing with quite a stack of technology here: you are
using [Geb], which relies on [WebDriver] to automate a browser that you have installed on your system (and which may
or may not be of the latest version for your system).

So lets check if everything works fine first:
- [ ] Open [GoogleSystemSpec] and execute it via your IDE.
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
TODO

- [ ] Add a new feature method to [GoogleSystemSpec], that checks if the Google logo can be found on the Google start
page.
- [ ] Write another one to check if the main search input field can be found.

Part 3: Interaction
-------------------
TODO

- [ ] Add a feature to check if the footer link to the "about Google" page is actually taking us to a different page.

Part 4: Pages
-------------
TODO

- [ ] Create a `GoogleStartPage` class containing the URL. Now change your features to use the `to` instead of `go` for
navigating to the page.
- [ ] Add an `at` check to your page. Use your selector for the bigger Google logo for this.
- [ ] Move your selector for the main search input field to the page's content.
- [ ] Refactor your features to use the `GoogleStartPage` and contain no more knowledge about the HTML structure.

Part 4: More interaction and waiting
------------------------------------
TODO

- [ ] Add a new feature method to [GoogleSystemSpec], which inputs one character into the main search input field.
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
- [ ] Add a feature to your [GoogleSystemSpec] to check that when searching for "Wiki" then the top result is 
"Wikipedia".

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
[Spock Testing Workshop]: <https://github.com/mkutz/spock-testing-workshop>

[Geb]: <http://www.gebish.org/>
[Geb manual]: <http://www.gebish.org/manual/current/>
[Introduction section]: <http://www.gebish.org/manual/current/#introduction>
[The Browser section]: <http://www.gebish.org/manual/current/#browser>
[The WebDriver implementation section]: <http://www.gebish.org/manual/current/#driver>
[Interacting with content section]: <http://www.gebish.org/manual/current/#navigator>
[Pages section]: <http://www.gebish.org/manual/current/#pages>
[Modules section]: <http://www.gebish.org/manual/current/#modules>
[Configuration section]: <http://www.gebish.org/manual/current/#configuration>
[Implicit assertions section]: <http://www.gebish.org/manual/current/#implicit-assertions>
[Spock, JUnit & TestNG section]: <http://www.gebish.org/manual/current/#spock-junit-testng>
[Javascript, AJAX and dynamic pages seaction]: <http://www.gebish.org/manual/current/#javascript-ajax-and-dynamic-pages>
[Waiting section]: <http://www.gebish.org/manual/current/#waiting>

[WebDriver]: <http://www.seleniumhq.org/projects/webdriver/>
[WebDriverManager]: <https://github.com/bonigarcia/webdrivermanager>

[GoogleSystemSpec]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/GoogleSystemSpec.groovy>
[GoogleStartPage]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/pages/GoogleStartPage.groovy>
[GoogleUserActor]: <src/test/groovy/de/assertagile/workshop/gebtesting/test/actors/GoogleUserActor.groovy>
[GebConfig]: <src/test/resources/GebConfig.groovy>

[issues]: </issues>
