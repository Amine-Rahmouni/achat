FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/achat-1.1.jar app.jar
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser
USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
