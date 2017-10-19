# Installing the CISpaces web UI and services

## Prerequisites
The CISpaces web services are Java based and have tested with OpenJDK 8 and Oracle JDK 8
http://www.oracle.com/technetwork/java/javase/downloads/index.html

The build process employs Apache Maven, and has been tested with version 3.3.9
https://maven.apache.org/download.cgi

The services run under a Java web application server, and have been tested with Apache Tomcat 8.0.45 to 8.0.47
http://tomcat.apache.org/download-80.cgi

## Installation

### Ubuntu 16.04
- Install git

```$ sudo apt-get install git```

- Clone CISpaces repository

```$ git clone https://gitlab.it-innovation.soton.ac.uk/IntelAnalysisDSTL/cispaces-web-services.git```

- Run the pre-requisites installation script from the cispaces directory

```
$ cd cispaces-web-services
$ ./install-prereqs.sh
```

- Update the environment

```$ source ~/.profile```

- Add local dependencies to Maven

```$ mvn initialize```


- Build and deploy the project using Maven

```$ mvn install```

## Running

### Ubuntu 16.04

- Start the Apache Derby database in a GNU Screen session (allows it to continue running in the background)

```
$ screen
$ cd ${CISPACES}/tools/derby
$ ${GAIAN}/bin/startNetworkServer
$ <CTRL+A>,<D>
```

- To re-attach:

```$ screen -r```

- Start Tomcat web server:

```$ $CATALINA_HOME/bin/startup.sh```

- To use CISpaces we interface, point your web browser to http://YOUR_IP:8080
- You can login with sample users 'Ella', 'Joe' or 'Miles' with password 'password'

- To stop Tomcat:

```$ $CATALINA_HOME/bin/shutdown.sh```
