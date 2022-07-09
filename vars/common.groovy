def sonarQube() {
//    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.6.50:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//    sh 'sonar-quality-gate.sh admin admin123 172.31.6.50 ${COMPONENT}'
    println 'SonarCube Testing'
}