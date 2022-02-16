Feature: Example
  A example feature with tests contributed

  @TeamOne
  Scenario: An example of some test
    Given A login to a directory
    When A combo box is selected
    Then A text box is visible

  @TeamOne
  Scenario: Steps to be done
    Given A login to a directory
    When A texbox is filled in
    Then A submit button is active

  @TeamOne
  Scenario: A test with a Web Driver
    Given I navigate to a site
    When and enter some search
    Then I get some results

  @TeamTwo
  Scenario: Test for new Transaction
    Given I make a new Transaction
    When I click Confirm
    Then The transaction is accepted

  @TeamTwo
  Scenario: Transaction Rollback Test
    Given I locate a transaction
    When A request a rollback of the transaction
    Then The transaction is rolled back

  @TeamTwo
  Scenario: View Transaction Test
    Given I navigate to the transaction screen
    When The transactions are loaded
    Then The active transactions are highlighted