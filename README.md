# ITWorx Project - Winjigo Test Automation

![Selenium](https://img.shields.io/badge/Selenium-43B02A?logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/Cucumber-23D96C?logo=cucumber&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-DD2233?logo=testng&logoColor=white)

## 📌 Overview
Automated test framework for Winjigo platform using:
- **Selenium WebDriver** for browser automation
- **Cucumber** for BDD (Behavior-Driven Development)
- **TestNG** for test execution and reporting
- **Page Object Model** design pattern

## 🛠️ Prerequisites
- Java JDK 11+
- Maven 3.8+
- Chrome/Firefox browser
- ChromeDriver/GeckoDriver (compatible with your browser version)

## 🚀 Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/Abdullahmostafah/ITWorx_Final.git
   ```
2. Navigate to project directory:
   ```bash
   cd ITWorx_Final
   ```
3. Configure `config.properties`:
   ```properties
   browser=chrome
   url=https://winjigo.azurewebsites.net
   login.username=your_username
   login.password=your_password
   course.name=Test Course
   course.grade=10
   course.subject=Math
   course.teacher=John Doe
   ```

## 🏗️ Project Structure
```
src/
├── main/java/
│   ├── Base/               # Core framework classes
│   │   ├── TestBase.java
│   │   └── ...
│   ├── Pages/              # Page Objects
│   │   ├── P01_LoginPage.java
│   │   └── ...
│   └── Utils/              # Utilities
│       ├── ConfigReaderWriter.java
│       ├── ScreenshotUtils.java
│       └── ...
├── test/java/
│   ├── Runners/            # Test runners
│   │   └── TestRunner.java
│   ├── StepDefinitions/    # Cucumber steps
│   │   ├── D01_LoginStepDefinitions.java
│   │   └── ...
│   └── Features/           # Feature files
│       ├── Login.feature
│       └── ...
└── resources/
    ├── config.properties   # Configuration
    └── drivers/            # WebDriver executables
```

## 🔧 How to Run Tests
1. Run all tests:
   ```bash
   mvn test
   ```
2. Run specific tag (e.g., `@smoke`):
   ```bash
   mvn test -Dcucumber.filter.tags="@smoke"
   ```
3. Generate reports:
   After execution, find reports in:
   - **HTML**: `target/reports/cucumber.html`
   - **JSON**: `target/reports/cucumber.json`
   - **Screenshots**: `target/screenshots/` (for failed tests)

## 🧪 Test Scenarios Covered
### Login Feature
- Successful login with valid credentials
- (Add more scenarios as needed)

### Course Management
- Create new course with valid details
- Verify course appears in course list

## 🛠️ Framework Components
- **Driver Management**: Thread-safe WebDriver initialization
- **Config Reader**: Reads from `config.properties`
- **Soft Assertions**: TestNG soft asserts for non-fatal verifications
- **Screenshot Utility**: Automatic screenshots on failure

## 🤝 Contribution
1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



## Key Features Highlighted:
1. **Clear Setup Instructions**: With prerequisites and configuration steps
2. **Visual Badges**: For quick tech stack identification
3. **Directory Structure**: Visual representation of project organization
4. **Multiple Execution Options**: For different test scenarios
5. **Reporting Information**: Where to find test results
6. **Contribution Guidelines**: Standard GitHub workflow
