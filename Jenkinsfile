pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("build"){
            steps{
                echo "building the application"
                sh'mvn package'
            }
        }
        steps("building image"){
            withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
                sh 'docker build -t prasadk10/my-repo:jma-2.0 .'
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh 'docker push prasadk10/my-repo:jma-2.0'
        }
    }
}