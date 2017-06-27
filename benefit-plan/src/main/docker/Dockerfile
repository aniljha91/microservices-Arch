FROM java:8
VOLUME /tmp
ADD benefit-plan-0.0.1-SNAPSHOT.jar benefit-plan.jar
RUN bash -c 'touch /benefit-plan.jar'
EXPOSE 7000
ENTRYPOINT ["nohup","java","-jar","/benefit-plan.jar","&"]