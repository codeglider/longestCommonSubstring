## Instructions

This application is built using [Spring Boot](http://projects.spring.io/spring-boot)

### Set Up Maven
[Download](https://maven.apache.org/download.cgi) and [Install](https://maven.apache.org/install.html) [Maven](https://maven.apache.org)

### Set Up Git
Set up git on your command line, this just makes it easy to run a spring boot project.
Choose any git client. 

You can use source tree if you'd like, but you'll still need command line to run this.

For windows I use [Git SCM](https://git-scm.com/)

For Linux and Macs it should already be there.
For Ubuntu you can do an apt-get install if git is not installed already
For Centos you can use yum install if git is not installed
For Mac [See the following](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

### Clone Project On To Your Machine
Using git please clone on to your computer, you can also use source tree.
git clone https://github.com/codeglider/longestCommonSubstring.git

### Running Application
Open a terminal or command line
Go to the directory where you cloned the project
Make sure you see pom.xml

If you do then issue the command

mvn spring-boot:run

### Testing The Application
To test you can use [Postman](https://www.getpostman.com) or [SOAP UI](https://www.soapui.org)

You can also use curl

i.e. 

```
curl -H "Content-Type: application/json" -X POST -d '{"setOfStrings":[{"value":"sdropungard"},{"value":"sungarderdrop"},{"value":"dropgarden"}]}' http://localhost:8080/lcs
```


