@US7
Feature: As a user, I should be able to add the folders and upload a file directly
  Story:As a user, I should be able to manage folders.


  Background: User is on the dashboard page and click on module "Files"
    Given user on the dashboard page
    When user clicks on "Files" module


  Scenario: Verify user can add the folder
    When user clicks on add icon on the top
    And user click "New folder"
    And user write a folder name
    And the user click submit icon
    Then Verify the folder is displayed on the page


  Scenario: Verify users can upload a file inside a folder
    When user choose a folder from the page
    And user clicks the add icon on the top
    And the user uploads a file with the upload file option
    Then Verify the file is displayed on the page