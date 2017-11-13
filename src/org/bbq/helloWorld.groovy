// HelloWorld
package org.bbq;

class helloWorld implements Serializable {
  def steps
  private String message = 'Hello, world!'

  helloWorld() {
    this.message = message
  }

  def sayHello() {
    println "Hello, world!"
  }

} // class hello
