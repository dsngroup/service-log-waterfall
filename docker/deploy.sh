#!/bin/bash
sbt dist
# Temporary copy to tmp. see: https://github.com/moby/moby/issues/2745
cp target/universal/slwf-0.1-SNAPSHOT.zip docker/slwf-0.1-SNAPSHOT.zip
echo "Temporarily copy the production build archive to docker folder."
docker build -t tz70s/slwf docker
rm docker/slwf-0.1-SNAPSHOT.zip
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker push tz70s/slwf
