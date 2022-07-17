def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

//        triggers {
//            pollSCM('H/2 * * * *')
//        }

        stages {


            stage('Check the code quality') {
                steps {
                    script {
                        common.sonarQube()
                    }
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