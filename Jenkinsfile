pipeline {
    agent any

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
