# any-api-weatherstack-serenity-BDD

## Clone the repo by running 
```
$ git clone https://github.com/ravindraten/serenity-any-api-weatherstack-BDD.git
```
## Resource 
```
You need access key which lasts for 250 runs after this acces key needes to be updated on to run the tests
https://weatherstack.com/dashboard
```

## Running the tests locally
```
$ mvn clean install
```
### Access serenity reports locally
```
target/site/serenity/index.html
```
## How to write test cases
> test classes are written under the below folder---
> 
>src/test/java/testcases
>
> And all test classes would have below tag in order to see them under serenity reports
> 
```
@RunWith(SerenityRunner.class)
```
> Each test method would have below tag
```
@Title("This is title visible as tile for for test")
   @Test
```
>src/test/java/steps
>package would have all the steps fore test methods
>and each would have a tag as below
```
@Step("This step can be written in given when then format")
```
