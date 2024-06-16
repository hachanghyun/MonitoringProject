# 프로젝트 개요
    이 프로젝트는 실시간 모니터링 시스템을 구축하기 위해 Kafka, Redis, Spring Batch, 그리고 WebSocket을 사용합니다. 데이터는 Kafka를 통해 실시간으로 스트리밍되고, Redis는 데이터 저장소로 사용되며, Spring Batch는 배치 작업을 수행합니다. WebSocket은 실시간 데이터 업데이트를 위해 사용됩니다.

## 데이터 흐름
### 데이터 생산:
    데이터는 Kafka의 Producer를 통해 생성됩니다.
    Kafka는 분산 메시징 시스템으로, 데이터를 다양한 Consumer에게 스트리밍합니다.
### 데이터 스트리밍:
    생성된 데이터는 Kafka의 토픽에 게시됩니다.
    Kafka Broker는 데이터를 관리하며, 토픽을 통해 데이터를 분산합니다.
### 데이터 소비:
    Spring Boot 애플리케이션의 Kafka Consumer가 Kafka 토픽에서 데이터를 읽어들입니다.
    읽어들인 데이터는 Redis에 저장됩니다.
    Spring Batch 작업이 주기적으로 Redis에서 데이터를 가져와 배치 처리를 수행합니다.
### 실시간 업데이트:
    WebSocket을 통해 클라이언트는 실시간으로 데이터 업데이트를 받습니다.
    Spring Boot 애플리케이션은 WebSocket을 사용하여 클라이언트에게 실시간으로 데이터 변경 사항을 전송합니다.
    Docker와 Kubernetes 설정

## Docker 설정
    Docker는 컨테이너화된 애플리케이션을 실행하기 위한 플랫폼입니다. Docker Compose는 여러 컨테이너를 정의하고 실행할 수 있는 도구입니다.

### docker-compose.yml:
    Zookeeper: Kafka가 분산 시스템으로 동작할 수 있도록 관리합니다.
    Kafka: 메시징 시스템으로, 데이터 스트리밍을 처리합니다.
    Redis: 인메모리 데이터베이스로, 실시간 데이터 저장소로 사용됩니다.
    

### Kubernetes 설정
    Kubernetes는 컨테이너화된 애플리케이션의 배포, 스케일링, 관리를 자동화하는 플랫폼입니다. 각 애플리케이션 구성 요소를 관리하기 위해 다양한 YAML 파일이 사용됩니다.

### kubernetes-deployment.yaml:
    Deployment: 애플리케이션의 특정 개수를 실행하고, 업데이트 및 롤백을 관리합니다.
    Service: 외부 트래픽을 내부 애플리케이션으로 라우팅합니다.
    이 파일은 애플리케이션의 배포와 서비스 설정을 정의합니다. Deployment는 애플리케이션의 인스턴스를 관리하고, Service는 외부에서 접근할 수 있도록 포트를 노출합니다.

### 데이터 흐름 순서
    Kafka Producer가 데이터를 생성하고 Kafka Broker에 게시합니다.
    Kafka Broker는 데이터를 토픽으로 분산합니다.
    Spring Boot 애플리케이션의 Kafka Consumer가 Kafka 토픽에서 데이터를 읽어 Redis에 저장합니다.
    Spring Batch 작업이 주기적으로 Redis에서 데이터를 가져와 처리합니다.
    WebSocket을 통해 클라이언트는 실시간으로 데이터 업데이트를 받습니다.
    이 모든 과정은 Docker와 Kubernetes를 통해 관리되고 오케스트레이션됩니다. Docker는 각 서비스의 컨테이너를 관리하고, Kubernetes는 이러한 컨테이너들을 배포, 스케일링, 업그레이드 등의 작업을 자동화합니다.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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
