pipeline {
    agent any

    stages {
        stage('One') {
            steps {
                echo 'Hi, World'
                echo 'One more Hello'
                sh '''echo Hello World
                echo Bye World
                '''
                mail bcc: '', body: 'Test', cc: '', from: '', replyTo: '', subject: 'Test', to: 'kartikay@local.com'
            }
        }

    }
}
