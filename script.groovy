def buildJar() {
    echo "building the application"
    sh'mvn package'
}

def buildImage() {
    echo "building docker image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t prasadk10/my-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push prasadk10/my-repo:jma-2.0'
    }
}

def deploy() {
    echo 'deploying the application . . .'
}

return this
