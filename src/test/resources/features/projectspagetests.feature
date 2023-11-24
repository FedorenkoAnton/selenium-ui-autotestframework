Feature: Projects page

  Background: selenium.dev user is on Home page
    Given User visit home page

  Scenario: As a selenium.dev user I want to know what selenium projects are exist
    When user clicks on Projects link
    Then user can see following selenium projects
      | Selenium WebDriver |
      | Selenium IDE       |
      | Selenium Grid      |
