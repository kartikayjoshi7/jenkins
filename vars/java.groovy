def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }


//        triggers {
//            pollSCM('H/2 * * * *')
//        }

        environment{
            PROG_LANG_NAME = "java"
            PROG_LANG_VERSION = "1.8"
            NEXUS = credentials('NEXUS')
        }

        stages {

            stage('Compile the code') {
                steps {
                    sh 'mvn compile'
                }
            }
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

            stage('Publish Artifacts') {
                when {
                    expression { sh ([returnStdout:true, script : 'echo ${GIT_BRANCH} | grep tags || true'])}
                }
                steps {
                    script {
                        common.prepareArtifacts()
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