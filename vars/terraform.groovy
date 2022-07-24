def call() {
    pipeline {
        agent {
            label "${BUILD_LABEL}"
        }


        environment {}


        pipeline {
            agent any
            parameters {

                choice(name: 'ENVIRONMENT', choices: ['', 'dev', 'prod'], description: 'Pick environment')
                choice(name: 'ACTION', choices: ['', 'apply', 'destroy'], description: 'Pick Terraform action')

            }
            stages {

                stage('Label Builds') {
                    steps {
                        script {
                            addShortText background: '', borderColor: 'white', color: 'red', link: '', text: "${ENVIRONMENT}"
                            addShortText background: '', borderColor: 'white', color: 'red', link: '', text: "${ACTION}"
                        }
                    }
                }


                stage('Apply Terraform action') {
                    steps {
                        sh '''
                    terraform init -backend-config=env/${ENVIRONMENT}-backend.tfvars
                    terraform ${ACTION} -auto-approve -var-file=env/${ENVIRONMENT}.tfvars
                  '''
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
}