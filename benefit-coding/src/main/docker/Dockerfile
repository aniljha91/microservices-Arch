FROM java:8
VOLUME /tmp
ADD benefit-coding-0.0.1-SNAPSHOT.jar benefit-coding.jar
RUN bash -c 'touch /benefit-coding.jar'
EXPOSE 6000
ENTRYPOINT ["nohup","java","-jar","/benefit-coding.jar","&"]