// // node {
// //     stage('one') {
// //         sh 'echo Hello'
// //     }
// //     stage('Two') {
// //             sh 'echo Hello'
// //         }
// // }
// //
// //
//
//
// pipeline {
//     agent any
//     agent none
//     agent {
//         node { 'node1' }
//     }
//     agent {
//         lable { 'ANSIBLE && CENTOS' }
//     }
//     stages {
//     stage('sample') {
//         agent { label 'UBUNTU' }
//         steps {
//             sh 'echo hello'
//         }
//     }
//   }
// }


// pipeline {
//     agent any
//     options { disableConcurrentBuilds() }
//     stages {
//         stage ('ONE') {
//             steps {
//                 sh 'sleep 10'
//             }
//
//         }
//     }
// }



// pipeline {
//     agent any
//     environment {
//     URL1 = "google.com"
//     SSH = credentials("CENTOS")
//     SSH1 = credentials('common/ssh')
//     }
//     stages {
//         stage ('ONE') {
//             steps {
//                 sh 'echo ${URL1}'
//                 sh 'env'
//                 echo SSH
//                 echo SSH1
//                  sh 'echo ${SSH1} | base64'
//
//             }
//
//         }
//     }
// }

//PARAMETER EXAMPLE
// pipeline {
//     agent any
//     parameters {
//         string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//
//         text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
//
//         booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
//
//         choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
//
//         password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
//     }
//     stages {
//         stage('Example') {
//             steps {
//                 echo "Hello ${params.PERSON}"
//
//                 echo "Biography: ${params.BIOGRAPHY}"
//
//                 echo "Toggle: ${params.TOGGLE}"
//
//                 echo "Choice: ${params.CHOICE}"
//
//                 echo "Password: ${params.PASSWORD}"
//             }
//         }
//     }
// }



//TOOLS EXAMPLE


pipeline {
    agent any
    stages {
        stage ('MAVEN') {
            steps {
                sh 'mvn --version'
            }

        }
    }
}
