FROM tomcat:8.5


WORKDIR /usr/local/tomcat

RUN rm -rf webapps/*

RUN rm -rf work/Catalina/localhost/*

COPY build/libs/dragons.war /usr/local/tomcat/webapps

COPY setenv.sh /usr/local/tomcat/bin

CMD ["catalina.sh", "run"]