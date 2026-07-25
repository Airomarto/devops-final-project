pipeline {
    agent any

    stages {

        stage('Checkout Source') {
            steps {
                checkout scm
            }
        }

        stage('Show Versions') {
            steps {
                sh 'git --version'
                sh 'docker --version'
                sh 'docker compose version'
            }
        }

        stage('Build Java Application') {
            steps {
                dir('java-app') {
                    sh 'chmod +x mvnw'
                    sh './mvnw clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker compose build'
            }
        }

        stage('Stop Existing Containers') {
            steps {
                sh 'docker compose down || true'
            }
        }

        stage('Deploy Containers') {
            steps {
                sh 'docker compose up -d'
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'docker ps'
                sh 'curl -I http://localhost || true'
                sh 'curl -I http://localhost:8080 || true'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }

        success {
            echo 'Deployment Successful!'
        }

        failure {
            echo 'Deployment Failed!'
        }
    }
}
