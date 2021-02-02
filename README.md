recheck-web-showcases
=====================

In this project you will find several showcases for [recheck-web](https://github.com/retest/recheck-web) for demo purposes.
To start a new project is't better to use the [recheck-web-archetype](https://github.com/retest/recheck-web-archetype).


## Usage

Import this project as maven project in your IDE and play around.
In the Junit test classes, changed versions of the tested pages are
mentioned, so you can easily switch between the versions.


Further resources
=================

To apply changes to your golden masters, you need to install either the [review GUI](https://assets.retest.org/releases/review.html) or the [recheck CLI](https://github.com/retest/recheck.cli/releases). Help to setup the CLI can be found [in the docs](https://docs.retest.de/recheck.cli/setup/).

You might also want to try out our [Chrome Extension](https://chrome.google.com/webstore/detail/recheck-web-demo/ifbcdobnjihilgldbjeomakdaejhplii). You need to setup a [free account](https://rehub.retest.de/) with us to use it. You can e.g. compare the [old budget](https://assets.retest.org/demos/budget/OriginalBudget.htm) with the [new budget](https://assets.retest.org/demos/budget/AdaptedBudget.htm) or the online version of the [login page](https://assets.retest.org/demos/app/demo-app.html) to the changed [login page](https://assets.retest.org/demos/app/demo-app_btn-change.html).

recheck-web can be used in conjunction with the [Selenium IDE](https://chrome.google.com/webstore/detail/selenium-ide/mooikfkahbdckldjjndioackbalphokd), to create tests quickly. As is shown in a some of the [contained tests](src/test/java/de/retest/recheck/example/BrowserStackTest.java), you can even use recheck-web together with e.g. [BrowserStack](https://www.browserstack.com/) or [Sauce Labs](https://saucelabs.com/) to do cross-browser testing or cross-device testing. Note that you need an account with each of them.

This project was mentioned in various articles, the latest of which is on [opensource.com](https://opensource.com/article/19/10/test-automation-without-assertions). 

If you want to understand a bit more about the background, I suggest viewing a [recent presentation](https://www.youtube.com/watch?v=2CGu7vNVY00) or having a look at the [slides](https://www.slideshare.net/roesslerj/testing-without-assertions).

If you have any questions, please contact us at [retest.de](http://retest.de/). 
