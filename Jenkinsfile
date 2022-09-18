pipeline {
    agent any
    stages {
        stage('Build') {
            withGradle {
                gradle 'build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
