### Run consul using docker

```
$ docker pull consul
$ docker run -d --name=consul-container -p 8500:8500 -e CONSUL_BIND_INTERFACE=eth0 consul agent -server -ui -node dev-node -bootstrap-expect=1 -client=0.0.0.0
```

Check details:

```
$ docker exec consul-container consul members
```

Access: `localhost:8500`
