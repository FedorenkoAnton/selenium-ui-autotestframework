pipeline {
    agent any

    tools {
        maven '3.8.4'
    }

    environment {
        browser = 'Chrome'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }

    post {
        always {
            allure([
                reportBuildPolicy: 'ALWAYS',
                results:[[path: 'build/allure-results']]
            ])
        }
    }
}