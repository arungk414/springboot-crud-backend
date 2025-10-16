pipeline {
    agent any  // Use the Jenkins node (container) directly
    environment {
        DOCKER_HOST = 'unix:///var/run/docker.sock'  // for docker commands
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/arungk414/springboot-crud-backend.git'
            }
        }

        stage('Build EurekaServer') {
            steps {
                dir('EurekaServer') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Demo Service') {
            steps {
                dir('demo') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Demo2 Service') {
            steps {
                dir('demo2') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                sh 'docker build -t eurekaserver ./EurekaServer'
                sh 'docker build -t demo ./demo'
                sh 'docker build -t demo2 ./demo2'
            }
        }

        stage('Run Containers') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
