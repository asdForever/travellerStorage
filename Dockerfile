FROM openjdk:17-alpine
COPY target/travellerStorage-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]



# docker run --env GIT_USERNAME=sorokin1990@gmail.com GIT_PASSWORD=_asdForever1990 --publish=8080:8080 asdforever:traveller_storage

#FROM maven:3.8.5

# Make ssh dir
# Set the required permissions.
# Create known_hosts
# Add github key
#RUN mkdir /root/.ssh/ && \
#    chmod -R 700 /root/.ssh/ && \
#    touch /root/.ssh/known_hosts && \
#    ssh-keyscan github.com >> /root/.ssh/known_hosts
#
#RUN mkdir /usr/travellerStorage/ &&  \
#    chmod -R 600 /usr/travellerStorage/
#
# Clone the conf files into the docker container
#RUN --mount=type=secret,id=ssh_id,target=/root/.ssh/id_rsa \
#   git clone git@github.com:sorokinandrey/travellerStorage.git /usr/travellerStorage


#ARG username=$GIT_USERNAME
#ARG password=$GIT_PASSWORD
#RUN git clone https://username:password@asdForever/travellerStorage.git