FROM java:8
VOLUME /tmp
ADD benefit-determination-0.0.1-SNAPSHOT.jar benefit-determination.jar
RUN bash -c 'touch /benefit-determination.jar'
EXPOSE 7000
ENTRYPOINT ["nohup","java","-jar","/benefit-determination.jar","&"]
