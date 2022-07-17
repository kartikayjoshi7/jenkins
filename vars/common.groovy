import org.jenkinsci.plugins.pipeline.modeldefinition.Utils

def sonarQube() {
//    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.6.50:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//    sh 'sonar-quality-gate.sh admin admin123 172.31.6.50 ${COMPONENT}'
    println 'SonarCube Testing'
}
def publishArtifacts() {
//    if (env.GIT_BRANCH == '*tag*') {
//        println 'ran on tag'
//    }
//    else {
//        Utils.markStageSkippedForConditional('Publish Artifacts')
//    }
        sh '''
        curl -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${gitTag}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${gitTag}.zip

        '''
}


def prepareArtifacts() {
    if(env.PROG_LANG_NAME == "nodejs"  && env.PROG_LANG_VERSION == "16")
    {
        sh '''
            npm install
            zip -r ${COMPONENT}-${gitTag}.zip node_modules server.js
            ls -ltr
        '''
    }
}