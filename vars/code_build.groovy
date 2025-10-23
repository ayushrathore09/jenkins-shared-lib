def call(String imagetag) {
    echo "Building the code..."
    sh "docker build -t ${imagetag}"
}