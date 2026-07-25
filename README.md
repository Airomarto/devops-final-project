# DevOps Final Project - Modern End-to-End Deployment

## Project Overview

This project demonstrates an end-to-end DevOps implementation for deploying and managing two applications using modern cloud and automation tools.

The project includes:

1. A Portfolio Web Application built with HTML and CSS.
2. A Java Spring Boot Application.

Both applications are containerized using Docker and deployed on AWS EC2. Infrastructure provisioning is automated using Terraform, server configuration is managed using Ansible, and Continuous Integration is implemented using GitHub Actions.

---

# Architecture Overview


Developer
|
|
v
GitHub Repository
|
|
v
GitHub Actions CI Pipeline
|
|
+----------------+
| |
v v
Docker Build Maven Build
|
|
v
AWS EC2 Instance
|
|
v
Docker Compose
|
|
+----------------------+
| |
v v
Portfolio Website Spring Boot Application
(Nginx Container) (Java Container)


---

# Technologies Used

## Cloud Platform

- AWS EC2
  - Hosts the deployed applications
  - Provides the production environment

## Infrastructure as Code

- Terraform

Used to provision AWS infrastructure consistently and repeatably.

Terraform manages:

- AWS provider configuration
- Network resources
- EC2 infrastructure

## Configuration Management

- Ansible

Used to automate server configuration and application environment preparation.

## Containerization

- Docker

Used to package applications and their dependencies into portable containers.

Applications containerized:

- Portfolio website container
- Java Spring Boot application container

## Container Orchestration

- Docker Compose

Used to manage multiple application containers together.

Services:

- Portfolio service
- Java application service

## Programming Technologies

- HTML
- CSS
- Java
- Spring Boot
- Maven

## CI/CD

- GitHub Actions

Used for Continuous Integration automation.

The pipeline:

1. Triggers automatically on every push to the main branch.
2. Checks out the repository.
3. Builds the Java Spring Boot application.
4. Builds Docker images for both applications.
5. Confirms successful image creation.

---

# Project Structure


devops-final-project
│
├── portfolio
│ ├── Dockerfile
│ ├── index.html
│ └── style.css
│
├── java-app
│ ├── Dockerfile
│ ├── pom.xml
│ ├── src
│ └── target
│
├── terraform
│ ├── main.tf
│ ├── provider.tf
│ ├── variables.tf
│ └── outputs.tf
│
├── .github
│ └── workflows
│ └── deploy.yml
│
├── docker-compose.yml
│
├── Jenkinsfile
│
└── README.md


---

# Deployment Process

## 1. Infrastructure Provisioning

Terraform was used to create AWS infrastructure.

Commands:

```bash
terraform init

terraform plan

terraform apply

Terraform provisions the required AWS resources for deployment.

2. Server Configuration

Ansible was used to configure the EC2 environment.

Tasks include:

Installing required packages
Preparing the server
Configuring application requirements
3. Application Containerization

Docker images were created for both applications.

Portfolio Application

Build:

docker build -t portfolio ./portfolio
Java Application

First build the Spring Boot application:

cd java-app

./mvnw clean package

Build Docker image:

docker build -t java-app .
4. Running Applications with Docker Compose

The applications are deployed together using:

docker compose up -d

Check running containers:

docker ps

Example output:

portfolio     Up
java-app      Up
CI/CD Pipeline

GitHub Actions workflow location:

.github/workflows/deploy.yml

Pipeline workflow:

Git Push
    |
    v
GitHub Actions Triggered
    |
    v
Checkout Repository
    |
    v
Build Java Application
    |
    v
Build Docker Images
    |
    v
Pipeline Successful
Running Applications
Portfolio Website

URL:

http://44.222.97.125
Java Spring Boot Application

URL:

http://44.222.97.125:8080
Verification

The deployment was verified by:

Checking running containers
docker ps
Testing Portfolio Application
curl http://localhost
Testing Java Application
curl http://localhost:8080
Project Achievements

This project demonstrates practical implementation of:

✅ Infrastructure as Code using Terraform
✅ Configuration Management using Ansible
✅ Docker containerization
✅ Multi-container deployment using Docker Compose
✅ Cloud deployment on AWS EC2
✅ CI automation using GitHub Actions
✅ Version control using Git and GitHub

Author

Martins Airende

DevOps Final Project
