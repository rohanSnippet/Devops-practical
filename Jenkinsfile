pipeline {
    agent any
    
    tools {
        jdk 'JDK' // Matches the name in Global Tool Configuration
        maven 'M3'
    }

    stages {
        stage('Checkout') {
            steps {
                // Replace with your Git repository URL
                git 'https://github.com/rohanSnippet/Devops-practical.git'
            }
        }

        stage('Build & Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Test/App') {
            steps {
                // Assuming a simple execution to verify the factorial logic
                sh 'mvn exec:java -Dexec.mainClass="com.example.FactorialApp"'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: """Build was successful!
                         Project: ${env.JOB_NAME}
                         Build Number: ${env.BUILD_NUMBER}
                         Check console output here: ${env.BUILD_URL}""",
                to: 'rohan110620@gmail.com'
            )
        }
        failure {
            echo 'Build failed. No email sent for success.'
        }
    }
}
