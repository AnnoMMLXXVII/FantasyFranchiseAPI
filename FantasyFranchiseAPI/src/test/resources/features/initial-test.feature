@FAFR/Test
Feature: Initial Commit for FAFR-13

    Background: Predefined Steps for Test DAO
        Given: Test Data Access Object is not null


    @smoke
    Scenario: Validate TestData for DataAccesObject Layer - Get All Call
        Given: Test DAO get all call returns non empty list


    #@smoke
    Scenario: Validate TestData for DataAccesObject Layer - Get By Character
        Given: Test DAO get all call returns non empty list
        And: Test DAO get by character "c" is greater than 0

