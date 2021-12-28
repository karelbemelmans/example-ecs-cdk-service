# Dummy Service

This is a dummy service running on AWS ECS.

This repository contains:

- The actual Java code that defines the component and goes into the Dockerfile
- The CDK infrastructure code that creates and manages the infrastructure needed for this component
- A Github workflow that does a test build as part of the CI process

TODO:

- Also push the resulting container to our repository
- A Github workflow that deploys the AWS infrastructure

This repository does NOT contain:

- The ECS cluster, load balancer, CDN etc that is part of the shared infrastructure that runs multiple components
- Any other shared infrastructure as databases, queues and messages busses



## Building and running the Docker image

```
DOCKER_BUILDKIT=1 docker build -t karbemkry/dummy-service .
docker run -p 8080:8080 karbemkry/dummy-service
```
