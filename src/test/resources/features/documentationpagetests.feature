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

    Scenario: As a selenium.dev user I want to be sure that link to GitHub below code examples tab lead exactly to selenium.github.io
      When user clicks on Documentation link
      And clicks on 'View full example on GitHub'
      Then new tab's URL with host github.com is open
      And user is on seleniumhq.github.io repository page
