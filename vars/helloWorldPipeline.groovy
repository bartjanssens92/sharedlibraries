def call( String message )
  pipeline {
    agent any
    stages {
      stage('First') {
        steps {
          sh( "echo '$message'" )
        }
      } // stage First
    } // stages
  } // pipeline
} // call
