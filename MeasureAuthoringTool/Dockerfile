FROM tomcat:9

ARG STOREPASS="changeit"
ARG WAR_PATH="MeasureAuthoringTool.war"

RUN curl -O https://s3.amazonaws.com/rds-downloads/rds-ca-2019-root.pem \
    && curl -O https://s3.amazonaws.com/rds-downloads/rds-ca-2019-us-east-1.pem \
    && keytool -import -keystore $JAVA_HOME/lib/security/cacerts -trustcacerts -storepass ${STOREPASS} -alias "AWSrdsRootCACert" -file rds-ca-2019-root.pem --noprompt \
    && keytool -import -keystore $JAVA_HOME/lib/security/cacerts -trustcacerts -storepass ${STOREPASS} -alias "AWSrdsIntCACert" -file rds-ca-2019-us-east-1.pem --noprompt

RUN curl -O https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip \
    && unzip newrelic-java.zip \
    && sed -i "/common: &default_settings/a \ \ host: gov-collector.newrelic.com" newrelic/newrelic.yml

RUN apt-get update
RUN apt-get install -y vim

COPY target/MeasureAuthoringTool.war /usr/local/tomcat/webapps/${WAR_PATH}
COPY deployment/manager /usr/local/tomcat/webapps/manager
COPY deployment/ROOT /usr/local/tomcat/webapps/ROOT
COPY deployment/context.xml /usr/local/tomcat/conf/
COPY deployment/tomcat-users.xml /usr/local/tomcat/conf/
COPY deployment/catalina.sh /usr/local/tomcat/bin/

