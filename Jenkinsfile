pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Amine-Rahmouni/achat.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://localhost:9001 -Dsonar.login=$SONAR_AUTH_TOKEN'
                }
            }
        }
        stage('Publish to Nexus') {
            steps {
                sh 'mvn deploy -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t achat-app:1.1 .'
            }
        }
        stage('Docker Run') {
            steps {
                sh 'docker stop achat-app || true'
                sh 'docker rm achat-app || true'
                sh 'docker run -d --name achat-app -p 8082:8080 achat-app:1.1'
            }
        }
    }
    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
