pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                image 'maven:3.9-eclipse-temurin-24'
                }
            }
            steps {
            sh '''
            mvn clean install
            java --version
            java -jar target/singleton-1.0.jar
            '''
            }
        }
    }
}
