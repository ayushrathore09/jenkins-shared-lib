def call (String imagetag, String user){
    echo "Code Push Stage"
    withCredentials([usernamePassword(credentialsId:'dockerHub',usernameVariable:'dockerHubUser',passwordVariable:'dockerHubPass')]){
                    sh "docker login -u ${user} -p ${env.dockerHubPass}"
                    sh "docker tag ${imagetag} ${user}/${imagetag}"
                    sh "docker push ${user}/${imagetag}"
                    // use "" if using ${env.var} or use '' if using ${var}
                }
}
