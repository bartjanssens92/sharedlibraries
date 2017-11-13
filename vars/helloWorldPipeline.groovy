pipeline {
  agent any
  stages {
    stage('First') {
      steps {
        hello('Hallo, World!!!')
      }
    } // stage First
  } // stages
} // pipeline
