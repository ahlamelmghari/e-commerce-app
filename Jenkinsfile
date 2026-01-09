pipeline {
    agent {
            docker {
                image 'maven:3.9.6-eclipse-temurin-17'
                args '-v /var/run/docker.sock:/var/run/docker.sock'
            }
    }

    environment {
        IMAGE_NAME = "ecommerce-app"
    }

    stages {


        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Run Container') {
            steps {
                sh "docker run -d -p 8081:8081 ${IMAGE_NAME}"
            }
        }
    }
}
