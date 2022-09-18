pipeline {
    agent any

    stages {
        stage('Build') {
            withGradle {
                gradle 'build'
            }
        }
    }
}
