def call(String imagename, String USERNAME){
  echo "pushing the code into the docker hub repository."
  sh "docker tag ${imagename} ${USERNAME}/${imagename}:latest"
  withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
    sh "docker login -u ${env.USERNAME} -p ${env.PASSWORD}"
  }
  sh "docker push ${USERNAME}/${imagename}:latest"
} 
