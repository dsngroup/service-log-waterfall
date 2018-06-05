# Dockerfile to containerize the site.
FROM openjdk:8
ADD slwf-0.1-SNAPSHOT.zip /usr/app/
# Unzip the production build.
RUN unzip /usr/app/slwf-0.1-SNAPSHOT.zip -d /usr/app/
EXPOSE 9000
ENTRYPOINT /usr/app/slwf-0.1-SNAPSHOT/bin/slwf