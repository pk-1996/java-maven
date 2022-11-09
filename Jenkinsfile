pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("build"){
            steps{
                script{
                echo "building the application"
                sh'mvn package'
                }
            }
        }
        stage("building image"){
            steps{
                script{
            withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')])
                sh 'docker build -t prasadk10/my-repo:jma-2.0 .'
                sh "echo $PASS | docker login -u $USER --password-stdin"
                sh 'docker push prasadk10/my-repo:jma-2.0'
                }
            }
        }
    }
}