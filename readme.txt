This is a simple set of projects that represent a simple Phone Book 
application for the purposes of demonstrating how to automate the 
running of Eclipse 3.3 PDE unit tests using ant.

Pre-requisites
==============

You need to create an Eclipse 3.3 installation for testing. The 
default location is into a directory called "eclipse-3.3" in the
"projects" directory where you found this readme.txt file. You 
can create the Eclipse 3.3 installation for testing in any directory
and specify it to the build file using the -Dtest.eclipse.dir flag,
e.g.

C:\...\projects> ant test -Dtest.eclipse.dir=C:\testeclipse-3.3


Running PDE Tests
=================

To run the PDE unit tests using ant do the following:

C:\...\projects> ant test

This will build the plugins and the PDE unit test fragment, run the
tests and generate a html report.


*** this example is modified to work with eclipse 3.7 ***

prerequisites:
# eclipse-rcp-indigo-SR2-win32-x86_64 (2).zip
# jdk-7u6-windows-i586.exe
# JAVA_HOME : C:\Program Files\Java\jdk1.7.0_06    (64 bit version)