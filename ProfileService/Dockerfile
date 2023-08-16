# Используйте официальный Maven-образ для фазы сборки
FROM maven:3.8.1-jdk-11-slim AS build

# Установите рабочий каталог
WORKDIR /workspace/app

# Копируйте pom.xml и скачивайте все зависимости для быстрой итерации
COPY pom.xml .
RUN mvn dependency:go-offline

# Теперь копируйте исходный код
