pipeline {
    agent any
    
    tools {
        jdk 'JDK' // Ensure this matches the name in your Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/rohanSnippet/Devops-practical.git'
            }
        }

        stage('Compile') {
            steps {
                // Compile the Java file. 
                // Note: If your file is in a folder, use: bat 'javac folderName/FactorialApp.java'
                bat 'javac Program1.java'
            }
        }

        stage('Run & Verify') {
            steps {
                // Run the compiled class
                bat 'java Program1'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "SUCCESS: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: """Great news! The simple Java build was successful.
                         Project: ${env.JOB_NAME}
                         Build Number: ${env.BUILD_NUMBER}
                         Console Link: ${env.BUILD_URL}""",
                to: 'rohan110620@gmail.com'
            )
        }
        failure {
            emailext (
                subject: "FAILED: Build #${env.BUILD_NUMBER} - ${env.JOB_NAME}",
                body: "The build failed. Check the syntax in your Java file or the file path.",
                to: 'rohan110620@gmail.com'
            )
        }
    }
}
