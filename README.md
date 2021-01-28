# Starlink CICD Deployment

<p> This software deployment uses Docker, Kubernetes and Jenkins to create an end to end CICD pipeline.  </p>

<p> DockerHub image : <a href="https://hub.docker.com/repository/docker/donmanula/starlink" target="_blank"> DockerHub:Starlink</a></p>

<p>2 Test Suites available: 1 within the source code using REST Assured which tests before packaging. The other gets executed after the Kubernetes deployment, as a seperate Jenkins job. The second test is a jmeter test</p>

<p>Viva check</p>
