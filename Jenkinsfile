pipeline {
    agent any
    tools {
        maven 'Maven3'
        jdk 'JDK21'
    }
    stages {
        stage('Checkout') {
            steps {
                // Clone le dépôt
                git branch: 'master', url: 'https://github.com/asrir-imrane/covidapp.git'
            }
        }
        stage('Build') {
            steps {
                // Compile et package avec Maven
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                // Exécute les tests unitaires
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            // Archive les artefacts générés, par exemple le fichier JAR/WAR
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
