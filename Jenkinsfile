pipeline {

    agent any

    tools {
        maven 'Maven 3.9'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/pushp93/OrangeHRMS-Automation-Framework.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Test Cases') {
            steps {
                bat 'mvn test'
            }
        }

    }

    post {

        always {
            publishTestNG testResultsPattern: 'test-output/testng-results.xml'
        }

        success {
            echo 'Build Successfully Executed'
        }

        failure {
            echo 'Build Failed'
        }
    }
}