FROM koenighotze/wildfly:stripped
MAINTAINER Koenig Hotze
ENV REFRESHED_AT 20151227

RUN /opt/jboss/wildfly/bin/add-user.sh admin geheim123 --silent

ADD booking-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

EXPOSE 8080
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
