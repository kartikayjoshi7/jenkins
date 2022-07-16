def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

        triggers {
            pollSCM('H/2 * * * *')
        }

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
                    sh 'echo lint checks'
                }
            }

            stage('Test cases') {
                steps {
                    sh 'echo Test cases'
                }
            }

            stage('Publish Artifacts') {
                steps {
                    script {
                        common.publishArtifacts()
                    }
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