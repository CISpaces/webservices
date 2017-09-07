# Installing the CISPaces web services

## Prerequisites
The CISPaces web services are Java based and have tested with OpenJDK 8 and Oracle JDK 8
http://www.oracle.com/technetwork/java/javase/downloads/index.html

The build process employs Apache Ant, and has been tested with version 1.9 and 1.10
http://ant.apache.org/bindownload.cgi

The services run under a Java web application server, and have been test with Apache Tomcat 8.0.45
http://tomcat.apache.org/download-80.cgi

## Installation

### Ubuntu Linux 16.04
0. Clone this repository:
`$ git clone https://gitlab.it-innovation.soton.ac.uk/IntelAnalysisDSTL/cispaces-web-services.git`

1. Install Java 8

`$ sudo apt install default-jdk`

2. Install Apache Ant

`$ sudo apt install ant`

3. Install Tomcat:

`$ wget http://www-us.apache.org/dist/tomcat/tomcat-8/v8.0.45/bin/apache-tomcat-8.0.45.tar.gz`
`$ tar xf apache-tomcat-8.0.45.tar.gz`

4. Install Maven:
`$ sudo apt install maven`

Set up the environment

`$ echo "export CATALINA_HOME=$(readlink -f apache-tomcat-8.0.45)" >> ~/.profile`
`$ source ~/.profile`

4. Build the services:

`$ ant `

Build VC using maven. Run this command from VC folder.

`$ cd VC`
`$ mvn clean install`

5. Deploy the services to Tomcat

`$ ant deploy`

TODO - Install / configure Derby / Context
