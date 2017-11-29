// HelloWorld
package org.bbq

// Import the audit
import org.bbq.Audit

class helloWorld implements Serializable {

  static def say( message ) {
    script.sh( "echo $message" )
  }

} // class hello
