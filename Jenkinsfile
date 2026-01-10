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

       stage('SonarQube Analysis') {
           environment {
               SONAR_SCANNER_HOME = tool 'SonarScanner'
           }
           steps {
               withSonarQubeEnv('SonarQube') {
                   sh """
                   ${SONAR_SCANNER_HOME}/bin/sonar-scanner \
                   -Dsonar.projectKey=e-commerce-app \
                   -Dsonar.sources=src
                   """
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
