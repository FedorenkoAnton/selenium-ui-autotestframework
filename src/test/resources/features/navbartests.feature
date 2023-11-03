Feature: Navigation bar menu

  Background: selenium.dev user is on Home page
    Given User visit home page

  Scenario Outline: As selenium.dev user I want to be sure that search bar suggested results contain input word
    When user clicks on search button
    And user input <search query> into search field
    Then user sees that each suggested result contain <search query>

    Examples:
      | search query |
      | Manager      |
      | Selenium     |
      | WebDriver    |