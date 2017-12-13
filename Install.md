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

- Run the fact-extraction installation script (currently requires GitLab access or a deployment key and usually takes ~15 minutes)

```$ FEWS/extra/install-fact-extraction.sh```

- Update the environment

```$ source ~/.profile```

- Add local dependencies to Maven

```$ mvn initialize```

- Build and deploy the project using Maven

```$ mvn install```

## Running

### Ubuntu 16.04

- To start:

```$ ./start-cispaces.sh```

- Start the fact-extraction engine running in a Screen session

```
$ screen
$ cd ${CISPACES}/tools/fact-extraction
$ source env/bin/activate
$ ant run.fact-extraction-app
$ <CTRL+A>,<D>
```

- To use CISpaces web interface, point your web browser to http://YOUR_IP:8080
- You can login with sample users 'Ella', 'Joe' or 'Miles' with password 'password'

- To stop:

```$ ./stop-cispaces.sh```

## Third party software
Cispaces has dependencies on a number of third party software libraries, none of
these dependencies are distributed here, but are fetched during the build 
process.  Details of the dependencies and their licenses can be aggregated by running:

```$  mvn license:add-third-party license:aggregate-download-licenses```

## Packaging for redistribution
To build a distributable zip file containing CISpaces, Tomcat and Derby and all dependencies, 
following the Installation instructions above with an additional step:

```$ ./package-cispaces-linux.sh```
