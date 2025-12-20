
# 🚀 PracticeAutomationExercise – Selenium Test Automation Framework

## 📌 Overview
This project is a **scalable Selenium test automation framework** built using **Java, TestNG, Maven**, and industry best practices.  
It automates **end-to-end functional UI test scenarios** for an e-commerce demo application and is designed with **maintainability, reusability, and reporting** in mind.

The framework demonstrates hands-on experience with **Page Object Model (POM)**, **data-driven testing**, and **advanced reporting**, simulating a real-world automation setup.

---

## 🎯 Key Objectives
- Design a **robust and modular automation framework**
- Implement **data-driven test execution**
- Generate **detailed and user-friendly test reports**
- Follow **clean code principles** and test automation best practices
- Create a framework suitable for **enterprise-level scaling**

---

## 🛠️ Tech Stack
- **Programming Language:** Java  
- **Automation Tool:** Selenium WebDriver  
- **Test Framework:** TestNG  
- **Build Tool:** Maven  
- **Reporting:** Extent Reports  
- **Design Pattern:** Page Object Model (POM)  
- **IDE Support:** IntelliJ IDEA / Eclipse  

---

## 🧩 Framework Features
- Page Object Model (POM) for better maintainability  
- **Data-Driven Testing** using external test data  
- **Extent Reports** with step-level logging and screenshots  
- Centralized WebDriver management  
- Reusable utility and helper classes  
- Cross-browser execution support (configurable)  
- Maven-based dependency management  

---

## ⭐ Framework Highlights

✔ Cross-Browser Testing (Chrome, Firefox, etc.)  
✔ Parallel Test Execution using TestNG  
✔ Thread-Safe WebDriver Management (ThreadLocal)  
✔ Page Object Model (POM) Design Pattern  
✔ Data-Driven Testing (Excel & JSON)  
✔ Retry Mechanism for Flaky Tests  
✔ Screenshot Capture on Test Failure  
✔ Extent Reports Integration  
✔ Reusable Base and Utility Classes  
✔ Configurable TestNG Suites  
✔ Scalable and Maintainable Architecture  

> This framework demonstrates how modern Selenium automation frameworks are built and maintained in enterprise environments.

---

## 🧪 Test Scenarios Covered

- Navigate to homepage
- Register a new user
- Log in with valid credentials
- Add item to cart
- Checkout process
- Log out



---

## 📁 Project Structure
PracticeAutomationExercise/
 src/
 main/
java/
utils/              # Generic utilities (e.g., config reader, logger, driver factory)


│
test/
java/
 - base/              # Base classes like TestBase or Driver setup
 - pages/             # Page Object classes (e.g., LoginPage.java, HomePage.java)
 - tests/             # Test classes (e.g., LoginTests.java)
 - testdata/          # Test data if needed (JSON, Excel, etc.)


│
- testng.xml                     # Test suite config
- pom.xml                        # Maven config with dependencies
- README.md                      # Project documentation
- .gitignore                     # Ignore files/folders from Git

---

PracticeAutomationExcercise/
├── src/main/java
│   ├── base/            # Base test and driver initialization
│   ├── pages/           # Page Object classes
│   ├── utils/           # Utilities (config, data reader, helpers)
│
├── src/test/java
│   ├── tests/           # Test classes
│
├── testng.xml           # TestNG suite configuration
├── pom.xml              # Maven dependencies & plugins
├── README.md            # Project documentation

---

## 🧪 Automated Test Scenarios
- User registration
- Login & logout
- Product search and selection
- Add to cart
- Checkout process
- Order confirmation

---

## ⚙️ Parallel & Cross-Browser Execution

Parallel execution is configured using **TestNG** with browser parameterization.

Example `crossBrowser.xml`:

```xml
<suite name="Automation Suite" parallel="tests" thread-count="3">
    <test name="Chrome Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>

    <test name="Firefox Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="tests.LoginTest"/>
        </classes>
    </test>
</suite>


## ⚙️ How to Run the Tests

1. **Clone the repository**
   ```bash
   git clone https://github.com/uday77u/PracticeAutomationExcercise.git
   cd PracticeAutomationExcercise
   Import the project into your IDE (Eclipse or IntelliJ as a Maven project)

2.Install dependencies
Maven will automatically download dependencies via pom.xml.

3.Run the tests

*Via IDE: Right-click on the test file or testng.xml → Run

*Via terminal:

bash: mvn test

## 📖 Future Improvements

- Integrate with Jenkins for CI

- Cross-browser testing using Selenium Grid

API test layer using RestAssured (future scope)

## 🙋‍♂️ About Me
I'm a QA enthusiast with a strong interest in automation testing. This project is part of my continuous learning journey and career preparation. Connect with me on LinkedIn or mail - uday77u@gmail.com. 

## 📄 License
This project is open-source and available under the MIT License.


