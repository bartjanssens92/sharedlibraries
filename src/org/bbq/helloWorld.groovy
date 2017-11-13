// HelloWorld
package org.bbq;

class helloWorld implements Serializable {
  def steps
  private String message = 'Hello, world!'

  helloWorld() {
    this.message = message
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
