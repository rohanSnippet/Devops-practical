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
            mail (
                to: 'rohan110620@gmail.com',
                subject: "SUCCESS: Build #${env.BUILD_NUMBER}",
                body: "Build successful! Check it out here: ${env.BUILD_URL}"
            )
        }
        failure {
            echo 'Build failed.'
        }
    }
}
