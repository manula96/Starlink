pipeline {
	agent any
	stages {
		stage('Checkout Source') {
			steps {
				git url:' https://github.com/manula96/Starlink.git', branch:'dev'
			}
		}

		stage("Build image") {
			steps {
				script {
					Starlink = docker.build("manula96/Starlink:${env.BUILD_ID}")
				}
			}
		}

		stage("Push image") {
			steps {
				script {
					docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
						Starlink.push("latest")
						Starlink.push("${env.BUILD_ID}")
					}
				}
			}
		}

		stage('Deploy App') {
			steps {
				script {
					kubernetesDeploy(configs: "Starlink.yml", kubeconfigId: "mykubeconfig")
				}
			}
		}

	}
}