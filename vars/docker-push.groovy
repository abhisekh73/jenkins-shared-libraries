def call(String Project, String ImageTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-hub-cred')]) {
      sh """
        echo "\$DOCKERHUB_PASS" | docker login --username "\$DOCKERHUB_USER" --password-stdin
        docker build -t "\$DOCKERHUB_USER/${Project}:${ImageTag}" .
        docker push "\$DOCKERHUB_USER/${Project}:${ImageTag}"
      """
  }
}
