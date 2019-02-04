# Automation Site Guidelines
Please keep the following format among the whole project

- Elements: Any elements should be written with combination of two phrases {Description}+{FieldType} where Description start with lowercase and FieldTypes as follows TXT: Text, DDL: Drop Down List, BTM: Button, BOX: Check Box, LINK: Link, TAB: Tab, MSG: Message, DPK: Date Picker
For example, selectDepartureDateFromDPK
In case of validation messages it should contains 3 phrases {Description}+{FieldName}+{Success or Warning or Error} 
For example, empty_IDNumber_Error_MSG
- Variables: Any variable should be begin with lowercase and capitalize first letters for other words 
For example, emailAddress
- Methods: Any method must be created from feature file with the same step name except general method 
For example, executeDBS
- Class: It should be per page and it's name should be written capitalize first letters+{Test} 
For example, SignUpPageTest
- Feature: It should be per system feature and it's name should be written capitalize first letters 
For example, SignUp.feature
- helper: This folder contains all general classes which configurable for all the project like, TestBase and DataBase Note: Any changes in these classes should be announced among the team before push to master branch
# General Notes
- Test data should be send within feature file except Faker Data
- Scenario Outline should be written for using invalid paramters to the same field having the same expected result
- Scenario with Data table should be written for scenarios required mutliaple data to fill
- Scenarios should be separate if the expected results are different
