// HelloWorld
package org.bbq;

class helloWorld implements Serializable {
  def steps
  private String message = 'Hello, world!'

  // Constructor
  helloWorld() {
    this.message = message
    this.steps = Steps
  }

  def sayHello() {
    steps{
      try {
        steps.sh ( script: "echo '" + this.message + "'" ).trim()
      }catch(error){
        steps.input message: "Error: " + error
      }
    }
  }

} // class hello
