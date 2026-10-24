pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                image 'maven:3.9-eclipse-temurin-21'
                }
            }
            steps {
            sh '''
            mvn clean install
            java --version
            '''
            }
        }
    }
}
