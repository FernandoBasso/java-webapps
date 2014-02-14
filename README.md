
----------------------------------------------------------------------------------------------------
conf/server.xml

In the section <Host>, set appBase='/path/to/webapps'

Start and stop:

    ~/bin/tomcat7/bin/startup.sh
    ~/bin/tomcat7/bin/shutdown.sh

Access the server:

    http://localhost:8080


A sample jaxrs application:

    http://localhost:8080/jaxrs/rest/calc/soma?arg1=5&arg2=3




 vim: set filetype=txt:
