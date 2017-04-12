# Docker EchoIP

A simple Spring Boot application with Dockerfile for testing Kubernetes deployment. Listens on 8080 and responds with hello message and IP.

## Compiling and running the project

Make a package:

    mvn clean install

Run app:

    mvn spring-boot:run

### Docker
    
Dockerize it:

	docker build -t ludva/echoip .

Run it via Docker on 8090:

	docker run -p 8090:8080 -t --name echoip --rm ludva/echoip

Test app:

	curl localhost:8090

Push to Docker Hub:

	docker login
	docker push ludva/echoip

### Kubernetes

Run it on Kubernetes:

	kubectl run echoip-deployment --replicas=2 --image=ludva/echoip  --port=8080

Check status:

	kubectl get pods

Expose it on nodes ip:

	kubectl expose deployment echoip-deployment --type=NodePort --name=echoip-service
	
Check status:

	kubectl get services

Test app:

	curl centos-minion-2:30391	//centos-minion-2 resolveable by DNS, or use machine's external IP. 30391 is port obtained from previous command.

Cleanup:

	kubectl delete services echoip-service
	kubectl delete deployment echoip-deployment
	

## References

* [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker/) - Spring Guide
* [Using a Service to Access an Application in a Cluster](https://kubernetes.io/docs/tutorials/stateless-application/expose-external-ip-address-service/) - Kubernetes Tutorial


