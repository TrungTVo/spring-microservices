# Consul

### Initiate Consul Agent Server locally through terminal

```bash
$ consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=127.0.0.1
```

Bind: localhost IP address of the local machine -> IP of Cluster Node

-node <node_name> (default to be host name of local machine)

### Services Check
```bash
$ curl http://localhost:8500/v1/agent/checks
```

Output:
```bash
{
   "service:school-service-a94c31c614f8f7cbeb69d79b5a382cc3":{
      "Node":"trungtvo",
      "CheckID":"service:school-service-a94c31c614f8f7cbeb69d79b5a382cc3",
      "Name":"Service 'school-service' check",
      "Status":"critical",
      "Notes":"",
      "Output":"HTTP GET http://10.0.0.212:9097/actuator/health: 404  Output: \u003chtml\u003e\u003cbody\u003e\u003ch1\u003eWhitelabel Error Page\u003c/h1\u003e\u003cp\u003eThis application has no explicit mapping for /error, so you are seeing this as a fallback.\u003c/p\u003e\u003cdiv id='created'\u003eTue Jan 12 23:02:09 EST 2021\u003c/div\u003e\u003cdiv\u003eThere was an unexpected error (type=Not Found, status=404).\u003c/div\u003e\u003cdiv\u003e\u003c/div\u003e\u003c/body\u003e\u003c/html\u003e",
      "ServiceID":"school-service-a94c31c614f8f7cbeb69d79b5a382cc3",
      "ServiceName":"school-service",
      "ServiceTags":[
         
      ],
      "Type":"http",
      "Definition":{
         
      },
      "CreateIndex":0,
      "ModifyIndex":0
   },
   "service:student-service-e06c4d1855ddc34f17ec556ffbff00a9":{
      "Node":"trungtvo",
      "CheckID":"service:student-service-e06c4d1855ddc34f17ec556ffbff00a9",
      "Name":"Service 'student-service' check",
      "Status":"critical",
      "Notes":"",
      "Output":"HTTP GET http://10.0.0.212:9098/actuator/health: 404  Output: \u003chtml\u003e\u003cbody\u003e\u003ch1\u003eWhitelabel Error Page\u003c/h1\u003e\u003cp\u003eThis application has no explicit mapping for /error, so you are seeing this as a fallback.\u003c/p\u003e\u003cdiv id='created'\u003eTue Jan 12 23:02:15 EST 2021\u003c/div\u003e\u003cdiv\u003eThere was an unexpected error (type=Not Found, status=404).\u003c/div\u003e\u003cdiv\u003e\u003c/div\u003e\u003c/body\u003e\u003c/html\u003e",
      "ServiceID":"student-service-e06c4d1855ddc34f17ec556ffbff00a9",
      "ServiceName":"student-service",
      "ServiceTags":[
         
      ],
      "Type":"http",
      "Definition":{
         
      },
      "CreateIndex":0,
      "ModifyIndex":0
   }
}
```

### Check on services health

```bash
$ curl http://localhost:8080/actuator/health
$ curl http://localhost:8081/actuator/health
```

If `spring actuator` isn't included in classpath -> this will failed -> service status will be `critical`

### Deregister a service instance

```bash
$ consul services deregister -id=student-service-e06c4d1855ddc34f17ec556ffbff00a9
```

id: ID of the service instance
