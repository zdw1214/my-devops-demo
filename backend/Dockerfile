FROM registry.cn-hangzhou.aliyuncs.com/zhengqing/openjdk:11-jre-slim
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
