recheck-web-example
===================

This is an minimal example project to setup [recheck-web](https://github.com/retest/recheck-web):

- It contains a [pom.xml](pom.xml) file, that defines recheck-web as a needed test dependency.
- It contains an example std. Selenium test [MySeleniumTest.java](src/test/java/de/retest/recheck/example/MySeleniumTest.java) together with a [login page](src/test/resources/demo-app.html) to test.
- It contains the corresponding [unbreakable recheck test](src/test/java/de/retest/recheck/example/MyUnbreakableSeleniumTest.java).
- It contains the [JUnit 5 extension file](src/test/resources/META-INF/services/org.junit.jupiter.api.extension.Extension) to integrate recheck into the JUnit life-cycle and omit calls to `capTest()`.
- It contains the Golden Master files (e.g. [retest.xml](src/test/resources/retest/recheck/de.retest.recheck.example.MyUnbreakableSeleniumTest/login.00.recheck/retest.xml)) to which the rendered website is compared against.
- It contains the recheck config files:
    - The [recheck.ignore](.retest/recheck.ignore) file defines which attributes (CSS and HTML) and elements (e.g. via XPath) should be ignored.
    - The [recheck.ignore.js](.retest/recheck.ignore.js) file allows you to define rules in JavaScript, which differences should be ignored. You can find examples on this in the [recheck-web project itself](https://github.com/retest/recheck-web/blob/master/.retest/recheck.ignore.js).
    - The [retest.properties](.retest/retest.properties) file contains properties for your project that are relevant for retest, such whether you use rehub.
- A [.travis.yml](.travis.yml) file, to have the build be executed on [Travis](https://travis-ci.com/retest/recheck-web-example).
- A [slightly changed](src/test/resources/demo-app_btn-change.html) and a [broken login page](src/test/resources/demo-app_CSS-broken.html), so you can see differences by switching used site in the the test.

In order to set it up correctly, you should install [Java](https://www.java.com/de/download/help/download_options.xml), [Maven](https://maven.apache.org/install.html) and [Selenium](https://www.seleniumhq.org/download/) on your local machine.


Further resources
=================

To correctly setup and use this project, it is probably helpful to install either the [review GUI](https://assets.retest.org/releases/review.html) or the [recheck CLI](https://github.com/retest/recheck.cli/releases). Help to setup the CLI can be found [in the docs](https://docs.retest.de/recheck.cli/setup/).

You might also want to try out our [Chrome Extension](https://chrome.google.com/webstore/detail/recheck-web-demo/ifbcdobnjihilgldbjeomakdaejhplii). You need to setup a [free account](https://sso.prod.cloud.retest.org/auth/realms/customer/account/) with us to use it.

recheck-web can be used in conjunction with the [Selenium IDE](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd), to create tests quickly. As is shown in a some of the [contained tests](src/test/java/de/retest/recheck/example/BrowserStackTest.java), you can even use recheck-web together with e.g. [BrowserStack](https://www.browserstack.com/) or [Sauce Labs](https://saucelabs.com/) to do cross-browser testing or cross-device testing. Note that you need an account with each of them.

This project was mentioned in various articles, the latest of which is on [opensource.com](https://opensource.com/article/19/10/test-automation-without-assertions). 

If you want to understand a bit more about the background, I suggest viewing a [recent presentation](https://www.youtube.com/watch?v=2CGu7vNVY00) or having a look at the [slides](https://www.slideshare.net/roesslerj/testing-without-assertions).

If you have any questions, please contact us at retest.de. 
