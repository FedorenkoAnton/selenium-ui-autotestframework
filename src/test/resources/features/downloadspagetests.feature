Feature: Downloads page tests

  Background: selenium.dev user is on Home page
    Given User visit home page

  Scenario: As a selenium.dev user I want to know what programing languages are supported
    When user clicks on Download link
    Then user sees following programing languages
      | C#                   |
      | Ruby                 |
      | Java                 |
      | Python               |
      | JavaScript           |

  Scenario: As a selenium.dev user I want to know what browsers are supported
    When user clicks on Download link
    And user clicks on Browser button
    Then user sees following list of supported browsers
      | Firefox           |
      | Internet Explorer |
      | Safari            |
      | Opera             |
      | Chrome            |
      | Edge              |