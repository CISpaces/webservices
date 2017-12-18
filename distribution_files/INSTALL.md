Collaborative Intelligence Spaces
=================================

[CISpaces.org](https://cispaces.org)

Pre-alpha demonstrator - binary package
---------------------------------------

This archive contains pre-built binaries, along with dependencies, targetting Enterprise Linux 7.3. 
It is recommended that a dedicated virtual machine is used for this deployment.

### Installation

As root, run:

# ./install.sh

### Usage

As a non-root user run:

$ ./start-cispaces

Access to the web interface from client machines will require firewall access:

$ sudo firewall-cmd --zone=public --add-port=8080/tcp --permanent
$ sudo firewall-cmd --reload

3. To use CISpaces web interface, point your Chrome web browser to http://YOUR_IP:8080

You can login with sample users 'Ella', 'Joe' or 'Miles' with password 'password'
To stop:

4. To stop cispaces:

$ ./stop-cispaces.sh


