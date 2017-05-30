FROM java:8
VOLUME /tmp
ADD benefit-plan-0.0.1-SNAPSHOT.jar benefit-plan.jar
RUN bash -c 'touch /benefit-plan.jar'
EXPOSE 8000
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/benefit-plan.jar"]