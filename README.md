# Dummy Service

This is a dummy service running on AWS ECS.

This repository contains:

- The actual Java code that defines the component and goes into the Dockerfile
- The CDK infrastructure code that creates and manages the infrastructure needed for this component

This repository does NOT contain:

- The ECS cluster, load balancer, CDN etc that is part of the shared infrastructure that runs multiple components
- Any other shared infrastructure as databases, queues and messages busses

TODO:

- CI/CD: Ideally we use Github Actions to build and deploy both the component and the infrastructure.


## Building and running the Docker image

```
DOCKER_BUILDKIT=1 docker build -t karbemkry/dummy-service .
docker run -p 8080:8080 karbemkry/dummy-service
```
