# NYTimes
NYTimes is a Mobile Application developed in Kotlin and implementing the Model-View-ViewModel (MVVM) design pattern.
The oriented object approach is represent in the applied design pattern and base classes implemented in the CommonLib library.
In the sample, I used Koin for the dependency injection framework

## Project Hierarchy
The project contains app module implementing CommonLib library. CommonLib contains all the base classes, common Retrofit API Client, common listeners and all common features that can be used in different modules

  
## Installation and Configuration

#### IDE Installation - Android Studio
Download Android Studio from https://developer.android.com/studio and install it in order to be able to build and run the application.

#### Get the application
Download the application as a zip file from git https://github.com/faditanios/NYTimes_CC.git and then open the project or from Android studio, select `File --> New --> Project from Version Control --> Git`
Enter the clone repositore URL https://github.com/faditanios/NYTimes_CC.git, select the local destination and click clone

#### Build
From Android Studio, select Build --> Make Project
or from the terminal, type
gradlew build

## Testing
#### Unit Testing
You can always run Unit Tests within a single specific class with android studio by right clicking on the class and execute, or, run a single method annotated with @Test.
In this project, I added the method `APIAvailabilityTest` to test if the API is accessible and valid

## Git Hooks
I added a pre-commit check that will run the Unit Test prior to any commit action. In case the Unit Test fails, the commit will not occur.
```
#!/bin/sh

######## UNIT TESTS HOOK START ########
echo "Begin Unit Tests"
./gradlew test --continue
RESULT=$?
if [ $RESULT -ne 0 ]; then
  
  exit $RESULT
fi
######## UNIT TESTS HOOK END ########
```

## Continuous Integration
This project uses Github Actions for CI. The workflow will run on push to git. The status can be checked under the Actions tab in Git

#### Workflows
The workflows can be found under `root\.github\workflows`

#### Android Features CI
- Build Action
- Unit Tests Action
- Default Android Lint Checker

The unit test and lint checker depend on Build Action. If the build was not successully, the other actions will not run
