def call(String imagename,){
  sh "pushing the code into the dcoekr hub repository."
  withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
    sh "docker login -u ${env.USERNAME} -p ${env.PASSWORD}"
    sh "docker tag ${imagename} ${env.USERNAME}/${imagename}:latest"
    sh "docker push ${env.USERNAME}/${imagename}:latest"
    sh "image pushed to docker hub"
  }
} 
