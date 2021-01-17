pipeline {
    agent {
        label 'myslave'
    }
       environment {
       //once you sign up for Docker hub, use that user_id here
       registry = "manula96/Starlink"
       //- update your credentials ID after creating credentials for connecting to Docker Hub
       registryCredential = 'dockerhub'
       dockerImage = ''
    }
    stages {

        stage ('checkout') {
            steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/dev']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/manula96/Starlink']]])
            }
        }

        stage ('Build docker image') {
            steps {
                script {
                dockerImage = docker.build registry
                }
            }
        }

         // Uploading Docker images into Docker Hub
    stage('Upload Image') {
     steps{
         script {
            docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            }
        }
      }
    }

    stage ('K8S Deploy') {
        steps {
            script {
                kubernetesDeploy(
                    configs: 'Starlink.yaml',
                    kubeconfigId: 'mykubeconfig',
                    enableConfigSubstitution: true
                    )

            }
        }
    }

    }
}