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
  "duration": 5815745183,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Verify that \"Sign in\" link in the footer open on the correct link",
  "description": "",
  "id": "home-page;verify-that-\"sign-in\"-link-in-the-footer-open-on-the-correct-link",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@Remon"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "Press on \u0027Sign in\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "\u0027Sign In\u0027 page is opened",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeTest.pressOnSignIn()"
});
formatter.result({
  "duration": 77886640,
  "status": "passed"
});
formatter.match({
  "location": "SignInTest.signInPageIsOpened()"
});
formatter.result({
  "duration": 605160602,
  "status": "passed"
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
  "duration": 618956110,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "Verify that \"Sign up\" link in the footer open on the correct link",
  "description": "",
  "id": "home-page;verify-that-\"sign-up\"-link-in-the-footer-open-on-the-correct-link",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@Remon"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Press on \u0027Sign up\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "\u0027Sign Up\u0027 page is opened",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeTest.pressOnSignUp()"
});
formatter.result({
  "duration": 104746304,
  "status": "passed"
});
formatter.match({
  "location": "SignUpTest.signUpPageIsOpened()"
});
formatter.result({
  "duration": 584493260,
  "status": "passed"
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
  "duration": 540200990,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Verify that \"Support Center\" link in the footer open on the correct link",
  "description": "",
  "id": "home-page;verify-that-\"support-center\"-link-in-the-footer-open-on-the-correct-link",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 22,
      "name": "@Remon"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "Press on \u0027Support Center\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "\u0027Support Center\u0027 page is opened",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeTest.pressOnSupportCenter()"
});
formatter.result({
  "duration": 136691214,
  "status": "passed"
});
formatter.match({
  "location": "SupportCenterTest.supportCenterPageIsOpened()"
});
formatter.result({
  "duration": 579793131,
  "status": "passed"
});
});