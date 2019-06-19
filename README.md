recheck-web-example
===================

This is an minimal example project to setup recheck-web:

- It contains a [pom.xml](pom.xml) file, that defines recheck-web as a needed test dependency.
- It contains an example test [MyFirstTest.java](src/test/resources/de/retest/recheck/example/MyFirstTest.java) together with some [HTML](src/test/resources/formPage.html) from the [Selenium project](https://github.com/SeleniumHQ/selenium/blob/master/common/src/web/formPage.html) to test.
- It contains the Golden Master files (e.g. [retest.xml](src/test/resources/retest/recheck/de.retest.recheck.example.MyFirstTest/check_formPage.00.recheck/retest.xml)) to which the rendered website is compared against.
- It contains the recheck config files:
    - The [recheck.ignore](.retest/recheck.ignore) file defines which attributes (CSS and HTML) and elements (e.g. via XPath) should be ignored. Since this is no visual regression test, nor a cross-browser test, we ignore most of the CSS attributes (like color, font, etc.).
    - The [recheck.ignore.js](.retest/recheck.ignore.js) file allows you to define rules in JavaScript, which differences should be ignored. You can find examples on this in the [recheck-web project itself](https://github.com/retest/recheck-web/blob/master/.retest/recheck.ignore.js).
    - The [retest.properties](.retest/retest.properties) file contains properties for your project that are relevant for retest, such whether you use rehub.
- A [.travis.yml](.travis.yml) file, to have the build be executed on [Travis](https://travis-ci.com/retest/recheck-web-example).
- A slightly changed [HTML](src/test/resources/formPage-changed.html) site, so you can see differences by switching used site in the the [test](src/test/resources/de/retest/recheck/example/MyFirstTest.java).