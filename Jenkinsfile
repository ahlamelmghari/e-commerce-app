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
                  steps {
                      // Utilisation du plugin Maven pour Sonar au lieu du scanner CLI
                      withSonarQubeEnv('SonarQube') {
                          sh 'mvn sonar:sonar -Dsonar.projectKey=e-commerce-app'
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
