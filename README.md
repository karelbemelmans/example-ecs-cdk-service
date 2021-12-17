# Dummy Service

This is a dummy service running on AWS ECS.

There are 2 big parts inside this repo:

- the actual code that goes into the Dockerfile
- the CDK code that creates and manages the infrastructure

The CI/CD system to build and deploy this code is NOT part of this repository!

## CI/CD to run this

The CI/CD service that deploys this Dockerfile and infrastructure should:

- Use a template that assumes the same setup as this repo has, one Dockerfile, one cdk dir

## Building and running the Docker image

Build
```
DOCKER_BUILDKIT=1 docker build -t kry/dummy-service .
```

Run
```

docker run -p 8080:8080 kry/dummy-service
```
