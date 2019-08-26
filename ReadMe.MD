# LOGIN TEST

#### Installation

* You need to have Java8 JDK installed and update the PATH Environment Variable.

* Download the latest Eclipse IDE for Java Developers and add Installed JREs.

* Download latest Maven.
  - Add the path to Maven bin directory to the PATH environment variable.
  - Configure Maven - C:\Users\<Name>\.m2 folder
  - Install "Maven Integration for Eclipse (Luna and newer) 1.5" & configure Maven plugin(m2e) for Eclipse.




#### Framework Architecture


* Login_Test 

      *src/main/java   
        
          *com.ap.qa.base         
         		   *TestBase.java - Java file to execute the test cases in the xml file.
          *com.ap.qa.config
              	*configuration.properties- The Properties class provides methods to get data from the properties file and store data into the properties file
          *com.ap.qa.ExtentReportListener- The ExtentReports object is used to generate an HTML report in the specified location. The path of the report is given as an argument in the ExtentReports constructor.
          *com.ap.qa.pages- Page classes for UI  
          		*ForgotPwPg.java
          		*HomePage.java
          		*LoginPage.java
          		*MyAccountPg.java
          *com.ap.qa.testdata
          		*LoginTest.xlsx- Scenarios and data used to validate the test cases are saved in this excel file.
          *com.ap.qa.util
          
       *src/test/java
       	*com.ap.qa.testcases
       		*HomePageTest.java- contains Home webpage testcases
       		*LoginPageTest.java- contains Login webpage testcases with negative scerios and forgot password scenario
       		*MyAccount.java- contains My Account testcases
       		
       *src/main/resources
       	*testng.xml- It is configuration file in TestNG. It is used to define test suites and tests. It is also used to pass Parameters to the test methods.  
                                                                 
       *test-output - After the execution of testcases, Extent reports are saved in this folder
         
       *pom.xml - xml file to add/update the dependencies of the project.         
      
#### Technologies used 

Java,TestNG, Maven, Selenium Webdriver.

#### Framework used 

Page Object Model


#### Running test 

- Run testng.xml in src/main/resources as java application to execute the testcases.
- Update the arguments in the testng.xml file. 
   - In testng.xml file we can specify multiple name (s) which needs to be executed.We need to run the testng.xml file. (Right click on testng.xml and select Run as ‘TestNG Suite”)