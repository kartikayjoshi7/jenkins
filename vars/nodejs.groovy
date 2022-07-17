def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }

//        triggers {
//            pollSCM('H/2 * * * *')
//        }


        environment{
            PROG_LANG= "nodejs"
        }

        stages {

            stage('Label Builds') {
                steps {
                    script {
                        def gitTag = GIT_BRANCH.split('/').last()
                        addShortText background: '', borderColor: 'white', color: 'red', link: '', text: "${gitTag}"
                    }
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