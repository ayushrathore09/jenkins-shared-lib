def call(string url,string branch){
    echo 'Cloning the repository'
    git url: "${url}", branch: "${branch}"
    echo 'Repository cloned'
}