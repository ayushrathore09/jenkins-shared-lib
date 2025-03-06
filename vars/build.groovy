def call(string ImageName){
    echo 'Building the project'
    sh "docker build -t ${ImageName} ."
    echo 'Project built'
}