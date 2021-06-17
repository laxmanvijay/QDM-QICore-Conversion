This is a fork of https://github.com/MeasureAuthoringTool/QDM-QICore-Conversion.git

MeasureAuthoringTool has been included in this repo for convenient deployment.

Everything needed to run MAT is included (including the default env configs, db and dump).


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