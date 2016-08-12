1. **Setup project**

    1.1.	   _Create Maven based project which has next structure:_
        - ui-model – package with Page Objects;
        - test-suite – package with test methods;
        - commons – package for utilities (optional).
    1.2.	   _Add as mvn dependency latest version of testNG and selenium web-driver._
    1.3.	   _Create public repo in GitHub and do initial commit and push._
    1.4.	   _Use firefox version 42.00._
    1.5.	   _Create separate Page Object for each different page (don’t forget about OOP principles)._

2.	 **Automate test cases:**

    2.1.	   _Test search suggestion._
        Scenario
            1.	Open firefox browser.
            2.	Search via Google search field term “translate google com”.
        Expected Result
            Next text is displayed: “Showing results for translate.google.com”.

    2.2.	   _Test google translate._
        Scenario
            1.	Open firefox browser.
            2.	Search via Google search field term “translate google com”.
            3.	Open first link.
            4.	Fill in first field “Apple”.
            >> The same text is displayed in the area with translation.
            5.	Get inactive languages from right panel, click on any.
        Expected Result
            Translated text was changed (doesn’t equal to the text before).

    2.3.	   _Test navigation._
        Scenario
            1.	Open firefox browser.
            2.	Search via Google search field term “Apple”.
            3.	Get number of results.
            4.	Navigate through second and tenth page.
            5.	Assert number of results.
        Expected Result
            The same number of results are displayed as on the first page was.
