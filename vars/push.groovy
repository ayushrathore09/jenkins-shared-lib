def call(String imagename, String dockerhubuser){
  sh "pushing the code into the dcoekr hub repository."
  sh "docker tag ${imagename} ${dockerhubuser}/${imagename}:latest"
  withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
    sh "docker login -u ${env.USERNAME} -p ${env.PASSWORD}"
  }
  sh "docker push ${dockerhubuser}/${imagename}:latest"
} 
