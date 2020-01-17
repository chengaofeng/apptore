#基础镜像基于openjdk，利用alpine
FROM openjdk:8u212-jdk-alpine
#所属团队
MAINTAINER chengf

ENV JAVA_OPTS="-server -Xms512m -Xmx512m" LOGGING_LEVEL="INFO"
#编译时变量无法在运行时用，此处做一次转换
ENV TARGET_JAR="appstore-business-0.0.1-SNAPSHOT.jar"

#将编译好的工程jar包copy到镜像容器中
COPY ${TARGET_JAR} /usr/src/${TARGET_JAR}


ENV OPTS=${JAVA_OPTS}" -Dfile.encoding=UTF8    -Duser.timezone=GMT+08"
WORKDIR /usr/src
#程序入口


#CMD java -jar ${OPTS} ${TARGET_JAR} --logging.level.root=${LOGGING_LEVEL}

RUN echo "java -jar \${OPTS} \${TARGET_JAR} --logging.level.root=\${LOGGING_LEVEL} \${CUSTOM_PARAMS}" > start.sh \
             && chmod 777 start.sh
CMD ./start.sh
