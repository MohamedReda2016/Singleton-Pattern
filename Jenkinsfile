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
                    mvn test surefire-report:report
                    '''
                    }
        }
    }

   post {

     always {
       junit 'target/surefire-reports/TEST-org.example.test.SingletonTest.xml'
       publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, icon: '', keepAll: false, reportDir: 'target/reports', reportFiles: 'surefire.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
     }

    }
}
