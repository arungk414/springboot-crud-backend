pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/arungk414/springboot-crud-backend.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t eurekaserver ./EurekaServer'
                sh 'docker build -t demo ./demo'
                sh 'docker build -t demo2 ./demo2'
            }
        }
    } // stages closed
    post {
        always {
            echo 'Pipeline finished'
        }
    } // post closed
} // pipeline closed
