### Initiate Consul Agent Server locally through terminal

```
$ consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1
```

Bind: localhost IP address of the local machine -> IP of Cluster Node
-node <node_name> (default to be host name of local machine)
