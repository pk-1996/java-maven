def gv

pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    stages{
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build"){
            steps{
                script{
                    gv.buildJar()
                }
            }
        }
        stage("building image"){
            steps{
                script{
                    gv.buildImage
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    gv.deploy()
                }
            }
        }
    }
}