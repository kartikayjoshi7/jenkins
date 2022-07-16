def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

        triggers {
            pollSCM('H/2 * * * *')
        }

        stages {

            stage ('Label Builds') {
                script {
                    addShortText background: '', borderColor: 'white', color: 'red', link: '', text: 'Demo'
                }
            }


            stage('Check the code quality') {
                steps {
                    script {
                        common.sonarQube()
                        addShortText background: '', borderColor: '', color: 'red', link: '', text: 'Demo'
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
                when {
                    expression { sh ([returnStdout:true, script : 'echo ${GIT_BRANCH} | grep tags || true'])}
                }
                steps {
                    script {
                       // common.publishArtifacts()
                        println 'Publish Artifacts'
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