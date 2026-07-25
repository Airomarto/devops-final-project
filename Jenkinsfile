pipeline {
    agent any

    environment {
        COMPOSE_CMD = "docker compose"
    }

    stages {

        stage('Checkout Source') {
            steps {
                checkout scm
            }
        }

        stage('Show Docker Version') {
            steps {
                sh 'docker --version'
                sh 'docker compose version'
            }
        }

        stage('Build Docker Images') {
            steps {
                sh '${COMPOSE_CMD} build'
            }
        }

        stage('Stop Existing Containers') {
            steps {
                sh '${COMPOSE_CMD} down || true'
            }
        }

        stage('Deploy Application') {
            steps {
                sh '${COMPOSE_CMD} up -d'
            }
        }

        stage('Verify Deployment') {
            steps {
                sh 'docker ps'
            }
        }

        stage('Cleanup') {
            steps {
                sh 'docker image prune -f'
            }
        }
    }

    post {
        success {
            echo 'Deployment completed successfully!'
        }

        failure {
            echo 'Deployment failed!'
        }

        always {
            echo 'Pipeline finished.'
        }
    }
}
