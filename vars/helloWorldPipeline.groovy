def call( body ) {
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
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
