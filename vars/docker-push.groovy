def call(String Project, String ImageTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'dockerhubpass', usernameVariable: 'dockerhubuser')]) {
      sh """
        echo "\$dockerhubpass" | docker login --username "\$dockerhubuser" --password-stdin
        docker push "\$dockerhubuser/${Project}:${ImageTag}"
      """
  }
}
