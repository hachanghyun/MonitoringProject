### 실행중인 Docker 컨테이너 목록 확인
    docker ps

### Kafka 컨테이너에 접속
    docker exec -it 71d1db7c61c5 /bin/sh

### Docker Compose 서비스 재시작
    docker-compose down
    docker-compose up -d

### Kafka 브로커 로그 확인
    docker logs <kafka-container-id>

### 모든 Docker 컨테이너 중지
    docker stop $(docker ps -q)
    
### 필요하지 않은 Docker 컨테이너 삭제
    docker rm $(docker ps -a -q)
