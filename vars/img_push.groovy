def call(String Project, String ImageTag) {
  withCredentials([usernamePassword(credentialsId: 'docker-hub-cred', passwordVariable: 'DOCKERHUB_PASS', usernameVariable: 'DOCKERHUB_USER')]) {
      sh """
        docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PASS}"
        docker build -t ${DOCKERHUB_USER}/${Project}:${ImageTag} .
        docker push ${DOCKERHUB_USER}/${Project}:${ImageTag}
      """
  }
}
