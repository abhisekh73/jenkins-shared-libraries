def dockerPush(Map args) {
    def image = args.image
    def tag = args.tag
    def registry = args.registry

    sh "docker tag ${image}:${tag} ${registry}/${image}:${tag}"
    sh "docker push ${registry}/${image}:${tag}"
}
