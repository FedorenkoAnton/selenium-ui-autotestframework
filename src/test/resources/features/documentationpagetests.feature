Feature: Documentation page

  Background: selenium.dev user is on Home page
    Given User visit home page

  Scenario: As a selenium.dev user I want to see 'Writing your first Selenium script' examples on 'Documentation page
    When user clicks on Documentation link
    Then user sees code snippets of programing languages
      | Java       |
      | Python     |
      | CSharp     |
      | Ruby       |
      | JavaScript |
      | Kotlin     |