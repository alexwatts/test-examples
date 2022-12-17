## Test Examples

This is a test harness for TestHub. It simulates a real CI/CD pipeline that is running tests periodically.

It runs some tests steps in cucumber JVM, which are coded to randomly pass or fail. These test reports can be submitted to local/staging instances of TestHub to generate reports to view.

There is a staging version of testhub deployed here (http://206.189.116.189:30001/)

There is a jenkins pipeline configured [here](http://206.189.116.189:30000/) to run this job against the staging testhub and to generate test reports. It's named `test-examples`. You can access it with the below credentials

```
username: testhub
password: contributor

```

## Getting Started

To run this harness locally you need to add a chrome driver to your path.

You can find a specific chrome driver version for your browser version here (https://chromedriver.chromium.org/downloads)

One way to add this to your classpath is to download the driver to `/opt/chromedriver` and then use the following command to add chromedriver to the path.

```
export PATH=$PATH:/opt/chromedriver
```

Once chromedriver is added to the path you can run the harness locally with

```
gradle clean build
```

Once the test suite has run, can submit the test report to TestHub (local or staging) with a commands like these:

Local
```
curl -v -XPOST -H 'Content-Type:application/json' -d @build/cucumber-reports.json http://localhost:8080/reports/test-examples
```

Staging
```
curl -v -XPOST -H 'Content-Type:application/json' -d @build/cucumber-reports.json http://206.189.116.189:30001/reports/test-examples
```
