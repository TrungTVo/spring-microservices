# Spring Microservices

### Usage
```bash
docker compose up -d
```

Stop all services:
```bash
docker compose down
```

### Manually run `consul` using docker

```bash
docker pull hashicorp/consul:1.22.4

docker run -d --name=consul-container -p 8500:8500 -e CONSUL_BIND_INTERFACE=eth0 hashicorp/consul:1.22.4 agent -server -ui -node dev-node -bootstrap-expect=1 -client=0.0.0.0
```

Check details:

```bash
docker exec consul-container consul members
```

Access: `localhost:8500`
