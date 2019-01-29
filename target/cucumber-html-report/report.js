$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("HomePage.feature");
formatter.feature({
  "line": 1,
  "name": "Home page",
  "description": "",
  "id": "home-page",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Navigate to URl",
  "keyword": "Given "
});
formatter.match({
  "location": "HomeTest.navigate_to_URl()"
});
formatter.result({
  "duration": 6416988940,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 6,
      "value": "#  Scenario: Verify that \"About Us\" link in the footer open on the correct link"
    },
    {
      "line": 7,
      "value": "#    And Press on \u0027About us\u0027"
    },
    {
      "line": 8,
      "value": "#    Then \u0027About Us\u0027 page is opened"
    },
    {
      "line": 9,
      "value": "#"
    },
    {
      "line": 10,
      "value": "#  Scenario: Verify that \"Contact Us\" link in the footer open on the correct link"
    },
    {
      "line": 11,
      "value": "#    And Press on \u0027Contact Us\u0027"
    },
    {
      "line": 12,
      "value": "#    Then \u0027Contact Us\u0027 page is opened"
    },
    {
      "line": 13,
      "value": "#"
    },
    {
      "line": 14,
      "value": "#  Scenario: Verify that \"Sign in\" link in the footer open on the correct link"
    },
    {
      "line": 15,
      "value": "#    And Press on \u0027Sign in\u0027"
    },
    {
      "line": 16,
      "value": "#    Then \u0027Sign In\u0027 page is opened"
    },
    {
      "line": 17,
      "value": "#"
    },
    {
      "line": 18,
      "value": "#  Scenario: Verify that \"Sign up\" link in the footer open on the correct link"
    },
    {
      "line": 19,
      "value": "#    And Press on \u0027Sign up\u0027"
    },
    {
      "line": 20,
      "value": "#    Then \u0027Sign Up\u0027 page is opened"
    },
    {
      "line": 21,
      "value": "#"
    },
    {
      "line": 22,
      "value": "#  Scenario: Verify that \"Support Center\" link in the footer open on the correct link"
    },
    {
      "line": 23,
      "value": "#    And Press on \u0027Support Center\u0027"
    },
    {
      "line": 24,
      "value": "#    Then \u0027Support Center\u0027 page is opened"
    },
    {
      "line": 25,
      "value": "#"
    },
    {
      "line": 26,
      "value": "#  Scenario: Verify that \"FAQs\" link in the footer open on the correct link"
    },
    {
      "line": 27,
      "value": "#    And Press on \u0027FAQs\u0027"
    },
    {
      "line": 28,
      "value": "#    Then \u0027FAQs\u0027 page is opened"
    },
    {
      "line": 29,
      "value": "#"
    },
    {
      "line": 30,
      "value": "#  Scenario: Verify that \"Terms and Conditions\" link in the footer open on the correct link"
    },
    {
      "line": 31,
      "value": "#    And Press on \u0027Terms and Conditions\u0027"
    },
    {
      "line": 32,
      "value": "#    Then \u0027Terms and Conditions\u0027 page is opened"
    },
    {
      "line": 33,
      "value": "#"
    },
    {
      "line": 34,
      "value": "#  Scenario: Verify that \"Privacy policy\" link in the footer open on the correct link"
    },
    {
      "line": 35,
      "value": "#    And Press on \u0027Privacy policy\u0027"
    },
    {
      "line": 36,
      "value": "#    Then \u0027Privacy Policy\u0027 page is opened"
    }
  ],
  "line": 38,
  "name": "Verify that \"afta\" link in the footer open on the correct link",
  "description": "",
  "id": "home-page;verify-that-\"afta\"-link-in-the-footer-open-on-the-correct-link",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 39,
  "name": "Press on \u0027afta\u0027 and verify that page is opened",
  "keyword": "And "
});
formatter.match({
  "location": "AFTATest.pressOnAftaAndVerifyThatPageIsOpened()"
});
formatter.result({
  "duration": 15146789933,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //div[@id\u003d\u0027page_content\u0027]/h3 (tried for 15 second(s) with 500 milliseconds interval)\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\n\tat step_definition.AFTATest.pressOnAftaAndVerifyThatPageIsOpened(AFTATest.java:20)\n\tat ✽.And Press on \u0027afta\u0027 and verify that page is opened(HomePage.feature:39)\nCaused by: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//div[@id\u003d\u0027page_content\u0027]/h3\"}\n  (Session info: chrome\u003d71.0.3578.98)\n  (Driver info: chromedriver\u003d2.45.615355 (d5698f682d8b2742017df6c81e0bd8e6a3063189),platform\u003dMac OS X 10.13.6 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027Remons-MacBook-Pro.local\u0027, ip: \u0027fe80:0:0:0:18b3:9d08:690c:bc0f%en0\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.13.6\u0027, java.version: \u00271.8.0_191\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.45.615355 (d5698f682d8b27..., userDataDir: /var/folders/m0/v2qrt58j641...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:62313}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: MAC, platformName: MAC, proxy: Proxy(), rotatable: false, setWindowRect: true, strictFileInteractability: false, takesHeapSnapshot: true, takesScreenshot: true, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unexpectedAlertBehaviour: ignore, unhandledPromptBehavior: ignore, version: 71.0.3578.98, webStorageEnabled: true}\nSession ID: 658b2031989a168b10eab9aa0db237a4\n*** Element info: {Using\u003dxpath, value\u003d//div[@id\u003d\u0027page_content\u0027]/h3}\n\tat sun.reflect.GeneratedConstructorAccessor12.newInstance(Unknown Source)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:205)\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:201)\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\n\tat step_definition.AFTATest.pressOnAftaAndVerifyThatPageIsOpened(AFTATest.java:20)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:498)\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:124)\n\tat org.testng.internal.Invoker.invokeMethod(Invoker.java:583)\n\tat org.testng.internal.Invoker.invokeTestMethod(Invoker.java:719)\n\tat org.testng.internal.Invoker.invokeTestMethods(Invoker.java:989)\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:109)\n\tat org.testng.TestRunner.privateRun(TestRunner.java:648)\n\tat org.testng.TestRunner.run(TestRunner.java:505)\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:455)\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:450)\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:415)\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:364)\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:84)\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1208)\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1137)\n\tat org.testng.TestNG.runSuites(TestNG.java:1049)\n\tat org.testng.TestNG.run(TestNG.java:1017)\n\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:73)\n\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\n",
  "status": "failed"
});
formatter.uri("SignUpPage.feature");
formatter.feature({
  "line": 1,
  "name": "Sign Up",
  "description": "",
  "id": "sign-up",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify that the user can sign up",
  "description": "",
  "id": "sign-up;verify-that-the-user-can-sign-up",
  "type": "scenario",
  "keyword": "Scenario"
});
});