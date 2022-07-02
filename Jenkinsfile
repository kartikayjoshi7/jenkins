// node {
//     stage('one') {
//         sh 'echo Hello'
//     }
//     stage('Two') {
//             sh 'echo Hello'
//         }
// }
//
//


pipeline {
    agent any
    agent none
    agent {
        node { 'node1' }
    }
    agent {
        lable { 'ANSIBLE && CENTOS' }
    }
    stages {
    stage('sample') {
        agent { label 'UBUNTU' }
        steps {
            sh 'echo hello'
        }
    }
  }
}