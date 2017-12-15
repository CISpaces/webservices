Collaborative Intelligence Spaces
=================================

[CISpaces.org](https://cispaces.org)

Pre-alpha demonstrator - binary package
---------------------------------------

This archive contains pre-built binaries, along with dependencies, targetting Enterprise Linux 7.3.  It is recommended that a dedicated virtual machine is used for this deployment.

### Installation

#### Cispaces Web component
This component is Java-based, consising of a number of RESTful web services running inside an Apache Tomcat container.  All depedencies are included and it requires no explicit installation step.

### Usage

1. Start the Web Component

$ cd cispaces
$ ./start-cispaces

Access to the web interface from client machines will require firewall access:
- RHEL / CentOS 7.x
    $ sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent
    $ sudo firewall-cmd --reload


- Ubuntu 16.04
    $ sudo ufw allow 8080

2. To use CISpaces web interface, point your Chrome web browser to http://YOUR_IP:8080

You can login with sample users 'Ella', 'Joe' or 'Miles' with password 'password'

CIS files containing example analyses can be found in the directory example_cis_files/

4. To stop cispaces:

$ ./stop-cispaces.sh

### Configuration

By default the Web component tries to connect to the Fact Extraction database and message queue on the localhost.  
This configuration can be changed by editing:

cispaces/tools/tomcat/webapps/fewsservlet/postgresql.properties
cispaces/tools/tomcat/webapps/fewsservlet/rabbitmq.properties

NB. The application needs to have been started at least once for these files to be in place.
