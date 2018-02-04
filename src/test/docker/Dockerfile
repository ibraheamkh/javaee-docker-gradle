FROM websphere-liberty:latest

## Copy the app server xml
COPY app/server.xml /opt/ibm/wlp/usr/servers/defaultServer/server.xml

## adding the war manually to apps inside the default server
ADD javaee-docker-gradle.war /opt/ibm/wlp/usr/servers/defaultServer/apps/javaee-docker-gradle.war
## making the expanded directory manually
RUN mkdir /opt/ibm/wlp/usr/servers/defaultServer/apps/expanded/
## extracting the war file manually
RUN unzip /opt/ibm/wlp/usr/servers/defaultServer/apps/javaee-docker-gradle.war -d /opt/ibm/wlp/usr/servers/defaultServer/apps/expanded/javaee-docker-gradle.war/





##installing the admin center
#RUN /opt/ibm/wlp/bin/installUtility install --acceptLicense adminCenter-1.0

##Each app in websphere runs in its own container which is a server
##our app runs on the default container which is created by default
##if we need to add another app, we have to create server for that app
##idea: copy and run bash script within the container

### create admin center server
#RUN /opt/ibm/wlp/bin/server create adminServer
#
###add server.xml
#COPY admin-app/server.xml /opt/ibm/wlp/usr/servers/adminServer/server.xml
#
#RUN /opt/ibm/wlp/bin/server run adminServer &&
#RUN /opt/ibm/wlp/bin/server run defaultServer &&
#
###starting the server manually
###RUN /opt/ibm/wlp/server run adminServer
#
###Exposing Admin panel
#EXPOSE 9060
#EXPOSE 9043




##Instructions for wildfly
#FROM wildfly:latest

##ADD  javaee-docker-gradle.war /opt/ibm/wlp/usr/servers/

#Adding managment user to wildfly
#RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#007 --silent

#Adding the war file to the deployments folder
#ADD javaee-docker-gradle.war /opt/jboss/wildfly/standalone/deployments/

#Exposing the management port also
#EXPOSE 9990

#CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

