# 명령어 
docker rm -f $(docker ps -aq)

docker rmi -f $(docker images -q)

./gradlew clean build


docker compose build

docker compose up 