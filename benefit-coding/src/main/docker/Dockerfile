FROM java:8
VOLUME /tmp
ADD benefitcoding-service-0.0.1-SNAPSHOT.jar benefitcoding-service.jar
RUN bash -c 'touch /benefitcoding-service.jar'
EXPOSE 6000
ENTRYPOINT ["nohup","java","-jar","/benefitcoding-service.jar","&"]