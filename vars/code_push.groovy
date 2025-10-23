def call (String imagetag, String user){
    echo "Code Push Stage"
    withCredentials([usernamePassword(credentialsId:'dockerHub',usernameVariable:'dockerHubUser',passwordVariable:'dockerHubPass')]){
                    sh "docker login -u ${user} -p ${env.dockerHubPass}"
                    // using -p in cli is insecure but for demo purpose we are using it.
                    // also: sh 'docker login -u ${dockerHubUser} -p ${dockerHubPass}' will work interpolatoion won't happen inside single quotes it passes as it is to shell and shell will look for env vars, still -p is insecure.
                    // so will pass silently: sh ''' echo ${dockerHubPass} | docker login -u ${dockerHubUser} --password-stdin ''' passing password through std. input is more secure.
                    sh "docker tag ${imagetag} ${user}/${imagetag}"
                    sh "docker push ${user}/${imagetag}"
                }
}
