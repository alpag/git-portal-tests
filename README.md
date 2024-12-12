# git-portal-tests

## How to run the tests?
### Prerequisites
- Java 8 installed
- Google Chrome
- Repo pulled thru git or extracted from zip

1. Go into the directory with the code
2. Type into the console 
```
   mvn test
   ```
4. Tests will be run automatically using forks (in parallel)

## Major features
- Page Object Model
  - Custom PageElement wrapper class (with lazy loading), to override default Selenium behavior (eliminate flakiness, StaleElementExceptions and so on)
  - No Page Factory (as per Selenium creators it's an antipattern!)
  - Component classes (reusable modules that are responsible for repetetive page parts, like headers) to meet DRY and SRP principles
  - I have tried to write as simple selectors as possible - used xpath a few times (cause I enjoy working with it and imo it's an underestimated way of finding elements!)
- Extendability
  - So far only github is supported
  - The 'Portal' classes structure and inheritance and POMs are adjusted to add new portals
  - Product-related POMs are independent and there should be no risk of name duplications or namespace/package naming issues
- Basic settings management using properties files
  - Any environment-dependent settings files linking to jsons with test data would be needed
  - Simple reusable properties to class mapping using 'owner' package
- Driver factory
  - Using webdrivermanager
  - Compatible with chrome as for MVP
  - RemoteWebDriver and FirefoxDriver extension possible
- Custom annotation @Url
  - Created to start from the page with given url (POM-level specified)
  - Added exception handling with user-friendly messages
  - POM object creator using reflection
- TestNG hooks
  - Configured a few hooks to meet DRY and SRP principles
    - For example automated logging user in for tests where scenario context starts at the HomePage (after login)
- Assertions
  - I wish I had more time for more diversified assertions
  - Utilized assertj (similiar to FluentAssertions which I am fan of) for higher-level assertions
  - A few assertion scopes for Soft Assertions
  - Custom messages for assertions (in whenANewUserTriesToSignUpThenUserCanContinueAndNoErrorMessageIsNotDisplayed)
- Test Data
  - For static test data, I have hardcoded it into .properties file
  - Enough for MVP, but eventually it would have to be stored in json or any key vault (depends on security measures) 
  - For dynamic, random data, I have utilized Faker package
- Concurrency
  - Utilized surefire for maven test runner
  - It provided parallel testing
  - As honestly I was not familiar with it and had limited time, it turned out that fork setting is the most stable one
  - It could be improved
