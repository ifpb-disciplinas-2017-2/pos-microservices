docker stop app
docker kill app
docker rm app
docker rmi -f teste

docker stop banco
docker kill banco
docker rm banco
docker rmi -f ricardojob/banco

mvn clean