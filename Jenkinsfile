pipeline {
    agent any

    stages {
        stage('Build') {
            agent {
                docker {
                image 'maven:3.9-eclipse-temurin-24'
                reuseNode true
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

        stage('Test') {
        agent {
                        docker {
                        image 'maven:3.9-eclipse-temurin-24'
                        reuseNode true
                        }
                    }
                    steps {
                    sh '''
                    mvn test
                    '''
                    }
        }
    }

   post {

     always {

       junit 'target/surefire-reports/TEST-org.example.test.SingletonTest.xml'
     }

    }
}
