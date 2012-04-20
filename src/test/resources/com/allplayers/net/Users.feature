Feature: User
  As a user, I would like to login with my credential
  so I may use the site.

  Scenario Outline: User can login
    Given the email <email>
      And the password <password>
    When the User logs in
    Then they should have email <email>
      And they should have a UUID

  Examples:
    | email                 | password   |
    | ymcaadmin@example.com | 123testing |
    | intern@example.com    | password   |

