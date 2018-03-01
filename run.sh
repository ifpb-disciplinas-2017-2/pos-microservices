cd app-autor
docker-compose up --build -d
cd ..
cd app-livro-web
mvn clean package
docker-compose up --build -d
cd ..
cd app-reserva
mvn clean package
docker-compose up --build -d
cd ..
