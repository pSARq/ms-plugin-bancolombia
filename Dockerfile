#Java version
FROM openjdk:17-jdk-slim
#puerto en el que corre la imagen
EXPOSE 8080

#Creacion de 2 carpetas
RUN mkdir /app
RUN mkdir /config

#Copia lo que se encuentra en las rutas en los paquetes creados anteriormente
COPY *.jar app/app.jar
COPY applications/app-service/build/resources/main/application.yaml config/application.yaml

# 3 Argumentos:
# 1: El commando inicial para ejecutar. En este caso es "java" para iniciar la máquina virtual de Java y ejecutar una aplicación Java.
# 2: Indica que el siguiente argumento es el nombre de un archivo JAR ejecutable
# 3: Es el nombre el archivo JAR que deberá ejecutar. En este caso es ese nombre, porque es el que se define arriba al crear las carpetas
#y copiar el codigo en esa carpeta
ENTRYPOINT [ "java", "-jar", "app/app.jar" ]
