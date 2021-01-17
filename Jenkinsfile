pipeline {
    agent {
        label 'myslave'
    }
       environment {
       //once you sign up for Docker hub, use that user_id here
       registry = "manula96/starlink"
       //- update your credentials ID after creating credentials for connecting to Docker Hub
       //registryCredential = 'dockerhub'
       dockerImage = ''
    }
    stages {

        stage ('checkout') {
            steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/dev']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/manula96/Starlink:${env.BUILD_ID}']]])
            }
        }

        stage ('Build docker image') {
            steps {
                script {
                bat 'mvn clean install -DstarlinkTestSuite'
                Starlink = docker.build("manula96/Starlink:${env.BUILD_ID}")
                }
            }
        }

         // Uploading Docker images into Docker Hub
    stage('Upload Image') {
     steps{
         script {
            docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
            Starlink.push("latest")
            Starlink.push("${env.BUILD_ID}")
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