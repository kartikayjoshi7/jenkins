def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

        triggers {
            pollSCM('*/2 * * * *')
        }

        stages {

            stage('Compile the code') {
                steps {
                    sh 'mvn compile'
                }
            }
            stage('Check the code quality') {
                steps {
                   common.sonarQube("shipping", java)
                }
            }

            stage('Lint checks') {
                steps {
                    sh 'echo Lint checks'
                }
            }

            stage('Test cases') {
                steps {
                    sh 'echo Test cases'
                }
            }
        }
        post {
            always {
                cleanWs()

            }
        }
    }
}