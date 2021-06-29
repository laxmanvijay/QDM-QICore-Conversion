This is a fork of https://github.com/MeasureAuthoringTool/QDM-QICore-Conversion.git

MeasureAuthoringTool has been included in this repo for convenient deployment. https://github.com/MeasureAuthoringTool/MeasureAuthoringTool

Everything needed to run MAT is included (including the default env configs, db and dump).

Prerequisites:

* Java 11 https://adoptopenjdk.net/
* Maven v2.81 https://maven.apache.org/download.cgi
* Docker

Steps to deploy:

1. Do a clean install, (prefer to include -DskipTests)

```shell

mvn clean install -DskipTests

```

2. build the image
   
```shell

docker-compose build

```

3. run the image as a daemon

```shell

docker-compose up -d

```

By default, MAT starts in port 8080.

It has three endpoint:

1. / - health check endpoint
2. /manager - opens tomcat manager
3. /MeasureAuthoringTool - opens MAT

* The default username and password for tomcat manager is `admin` and `adminadmin`
* MAT requires okta account and it must be signed-in in another tab for MAT to pick up auth token.

DB related configs can be found in,

1. `.env` file present in the root of the project and
2. `./MeasureAuthoringTool/deployment/context.xml` file.

Okta and other url configurations can be found in

* `./MeasureAuthoringTool/deployment/catalina.sh` file's `CATALINA_OPTS` variable.

Tomcat manager username and password are present in

* `./MeasureAuthoringTool/deployment/tomcat-users.xml` file

By default, MySQL is initialized with a dump file (its mysql version is 8.0.25). It is present in the `./mysql/dump.sql` file.

<hr>

*MAT version info:*

>The default version provided for deployment of MAT is version 6.0.4 which supports QDM version 5.5

> https://github.com/MeasureAuthoringTool/MeasureAuthoringTool/releases/tag/release%2Fprod_02-08-2021-2 is the branch that is pulled for 6.0.4 release.

> This can be changed by pulling the appropriate branch from the MAT repo, building it using `mvn clean install -DskipTests` and then replacing `./MeasureAuthoringTool/target/MeasureAuthoringTool.war` before building the image.
