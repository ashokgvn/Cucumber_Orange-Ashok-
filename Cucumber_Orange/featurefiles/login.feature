Feature: login functionality to orangehrm website as admin
@MissingUsername
  Background: 
    Given launch url in browser "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  @ValidCredentials
  Scenario: Login as admin 
    When Enter the username in textbox as "Admin" and Password as "admin123"
    Then Click login button and Home page should open

  @InvalidCredentials
  Scenario Outline: Login with invalid data
    When Enter Username text as "<username>" and Password as "<password>"
    Then User should see the error message as "<errormessage>"

    Examples: 
      | username | password | errormessage        |
      | Adminer  | adm      | Invalid credentials |
      | sfsdgfdb | sdsdfr   | Invalid credentials |
      | dewrrett | dfrgttgg | Invalid credentials |

  
  Scenario Outline: Login with blank username
    When Enter Username text as "<username>" and Password as "<password>"
    Then User should see the required message as "<required>"

    Examples: 
      | username | password | required |
      |          | admin189 | Required |
      | Admin767 |          | Required |
      |          |          | Required |
