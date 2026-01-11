pipeline {
    agent any

    environment {
        IMAGE_NAME = "ecommerce-app"
    }

     tools {
            maven 'maven'
            dockerTool 'docker'
     }
    stages {




        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

     stage('SonarQube Analysis') {
         steps {
             withSonarQubeEnv('SonarQube') {

                 sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.10.0.2594:sonar -Dsonar.projectKey=e-commerce-app'
             }
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
