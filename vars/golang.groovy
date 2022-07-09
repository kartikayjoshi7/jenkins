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
                    sh 'echo compile the ${COMPONENT} code'
                }
            }
            stage('Check the code quality') {
                steps {
                    sh 'echo check the code quality'
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
                cleansws ()

            }
        }

    }
}

