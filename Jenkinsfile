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



pipeline {
    agent any
    environment {
    URL1 = "google.com"
    SSH = credentials("CENTOS")
    SSH1 = credentials("common/ssh")
    }
    stages {
        stage ('ONE') {
            steps {
                sh 'echo ${URL1}'
                sh 'env'
                echo SSH
                echo SSH1
                 sh 'echo ${SSH1} | base64'

            }

        }
    }
}