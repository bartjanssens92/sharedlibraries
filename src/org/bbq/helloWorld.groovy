// HelloWorld
package org.bbq

class helloWorld implements Serializable {
  static def say( message ) {
    script.sh( "echo $message" )
  }
} // class hello
