# amazon-snickers test automation

### **How to run tests from cmd:**
1. Simple run with all default parameters 
   
   Run from project root folder: `mvn clean install`


2. Following parameters could be passed to test
        
    a. `-Denv=test` - to specify test config file with all parameters related to this environment
   
    b. `-Dbrowser=Chrome` - to specify particular browser for test execution. Supported only Chrome and Firefox
   
    c. `-Dhost=https://myhost.com` - to specify specific host

    d. `-DtestRunType=REGULAR` - to specify test run type. Amount and type of logged data depends on testRunType

    e. `-Dcucumber.options="classpath:features/amazonSearchTests.feature"` - to specify exact feature file to run (test suite)

For example:
`mvn clean install -Dcucumber.options="classpath:features/amazonSearchTests.feature" -Dbrowser=firefox -Denv=test -Dhost=https://amazon.de -DtestRunType=DEBUG`

### **How to run tests from IntelliJ:**

   1. Open following folder: `src/test/java/testrunners/`

   2. Use one of following classes to run your tests:
      
      a. `RunCucumberTestsInSeries` - run all tests in sequential mode
      
      b. `RunCucumberTestsInParallel` - run all tests in parallel mode
      
      c. `FailedTestsRunner` - run only previously failed tests

### **Reports**

Report will be available after test run in following folder: `/target/cucumber/index.html`