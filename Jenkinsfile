pipeline {
    agent {
        docker { image 'maven:3.9.2-eclipse-temurin-11' }
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
}
