Feature: Downloads page tests

    Scenario: As a selenium.dev user I want to know what programing languages are supported
      Given User visit home page
      When clicks on Download link
      Then user sees list of available programing languages