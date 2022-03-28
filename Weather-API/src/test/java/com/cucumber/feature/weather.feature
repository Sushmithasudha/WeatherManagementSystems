
Feature:
  Scenario:
    Given Adding the weather details
    And I perform POST operation
    Then I Should see the details of the city

Scenario:
   Given Update the Weather details by id
  And I Perform UPDATE operation
  Then I Should see the details of the updated city

  Scenario:
   Given Fetch Weather details by City
    And I perform GET operation


 Scenario:
   Given delete the Weather details by City
   And I Perform DELETE operation

  Scenario:
   Given A List of cities
  And I perform All GET operation