def call(String imagename){
    echo 'Building the project'
    sh "docker build -t ${imagename} ."
    echo 'Project built'
}