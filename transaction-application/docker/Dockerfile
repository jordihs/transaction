FROM @docker.base.tag@

LABEL PROJECT_NAME="@project.name@" \
      PROJECT=@project.artifactId@

RUN mkdir -p /user/share/@project.artifactId@/bin

ADD /@project.artifactId@-@project.version@.jar /user/share/@project.artifactId@/bin/@project.artifactId@.jar


ENTRYPOINT ["java", "-jar", "/user/share/transaction-application/bin/@project.artifactId@.jar"]
EXPOSE 8080