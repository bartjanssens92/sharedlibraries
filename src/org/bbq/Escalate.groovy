// org.bbq.Escalate.groovy
package org.bbq

// Get the change lib
import org.cgk.Change

class Escalate implements Serializable {

  def steps
  def env
  def currentbuild

  /*
   *
   */
  Escalate( Steps, type, message ){
    this.steps = Steps
    this.type = type
    this.message = message
  }

  def call( String message ){
    switch( this.type ){
      case "cegekaComponent":
        change.transfer( "", "", message )
      case "argentaComponent":
        change.transfer( "", "", message )
  } // call

} //class
