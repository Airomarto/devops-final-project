# DevOps Final Project - End-to-End Cloud Deployment Pipeline

## Project Overview

This project demonstrates a complete end-to-end DevOps implementation for deploying and managing applications using modern cloud, automation, containerization, and CI/CD practices.

The project consists of two applications:

1. **Portfolio Web Application**
   - A simple HTML/CSS portfolio website
   - Containerized using Docker
   - Served through an Nginx container

2. **Java Spring Boot Application**
   - A backend application built with Java and Spring Boot
   - Packaged using Maven
   - Containerized using Docker


The applications are deployed on **AWS EC2** using automated infrastructure provisioning, configuration management, and CI automation.

---

# Project Objectives

The main objectives of this project are:

- Provision cloud infrastructure using Infrastructure as Code
- Automate server configuration
- Containerize applications
- Deploy multiple services together
- Implement CI automation using GitHub Actions
- Demonstrate a complete DevOps workflow

---

# Architecture Overview

```
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
    +----------------------+
    |                      |
    v                      v
 Maven Build          Docker Build
    |                      |
    +----------+-----------+
               |
               v
          AWS EC2 Instance
               |
               v
        Docker Compose
               |
       +-------+-------+
       |               |
       v               v
 Portfolio App     Java Spring Boot App
 (Nginx)           (Java Container)
```

---

# Technologies Used

## Cloud Platform

### AWS EC2

Used as the production hosting environment for running the containerized applications.

---

## Infrastructure as Code

### Terraform

Terraform is used to provision AWS infrastructure consistently and repeatably.

Responsibilities:

- AWS provider configuration
- Infrastructure creation
- Resource management

Terraform files:

```
terraform/
├── main.tf
├── provider.tf
├── variables.tf
└── outputs.tf
```

---

## Configuration Management

### Ansible

Ansible is used to automate server configuration and prepare the EC2 environment.

Responsibilities:

- Installing required packages
- Configuring Docker environment
- Managing server setup

Ansible files:

```
ansible/
├── inventory
└── playbook.yml
```

---

## Containerization

### Docker

Docker is used to package applications and dependencies into portable containers.

Containers:

- Portfolio Web Container
- Java Spring Boot Container

---

## Container Orchestration

### Docker Compose

Docker Compose manages multiple containers running together.

Services:

- Portfolio service
- Java application service

---

## CI/CD Automation

### GitHub Actions

GitHub Actions provides Continuous Integration automation.

The pipeline automatically runs when changes are pushed to the main branch.

Pipeline steps:

1. Checkout repository
2. Build Java Spring Boot application
3. Build Docker images
4. Validate successful builds

Workflow location:

```
.github/workflows/deploy.yml
```

---

# Repository Structure

```
devops-final-project
│
├── ansible
│   ├── inventory
│   └── playbook.yml
│
├── portfolio
│   ├── Dockerfile
│   ├── index.html
│   └── style.css
│
├── java-app
│   ├── Dockerfile
│   ├── pom.xml
│   ├── src
│   └── target
│
├── terraform
│   ├── main.tf
│   ├── provider.tf
│   ├── variables.tf
│   └── outputs.tf
│
├── .github
│   └── workflows
│       └── deploy.yml
│
├── docker-compose.yml
│
├── Jenkinsfile
│
└── README.md
```

---

# Deployment Process

## Step 1: Provision Infrastructure

Terraform is used to create the required AWS resources.

Commands:

```bash
terraform init

terraform plan

terraform apply
```

---

## Step 2: Configure Server Using Ansible

Run the Ansible playbook:

```bash
ansible-playbook \
-i ansible/inventory \
ansible/playbook.yml \
--private-key ~/cohort-7-keypair.pem
```

This prepares the EC2 environment for deployment.

---

## Step 3: Build Applications

### Java Application

Navigate to the Java application:

```bash
cd java-app
```

Build the Spring Boot application:

```bash
./mvnw clean package
```

---

## Step 4: Build Docker Images

Portfolio:

```bash
docker build -t portfolio ./portfolio
```

Java Application:

```bash
docker build -t java-app ./java-app
```

---

## Step 5: Deploy Using Docker Compose

Start all services:

```bash
docker compose up -d
```

Check running containers:

```bash
docker ps
```

Expected containers:

```
portfolio
java-app
```

---

# CI Pipeline Workflow

The GitHub Actions pipeline follows this process:

```
Developer Push
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
```

---

# Application URLs

## Portfolio Website

```
http://44.222.97.125
```

## Java Spring Boot Application

```
http://44.222.97.125:8080
```

---

# Verification

The deployment was verified using:

## Check Docker Containers

```bash
docker ps
```

## Test Portfolio Application

```bash
curl http://localhost
```

## Test Java Application

```bash
curl http://localhost:8080
```

---

# Project Achievements

This project successfully demonstrates:

✅ Cloud deployment using AWS EC2  
✅ Infrastructure as Code using Terraform  
✅ Configuration Management using Ansible  
✅ Docker containerization  
✅ Multi-container deployment using Docker Compose  
✅ CI automation using GitHub Actions  
✅ Source control using Git and GitHub  

---

# Author

**Martins Airende**

DevOps Final Project
