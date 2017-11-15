// org.bbq.Escalate.groovy
package org.bbq

// Get the change lib
import org.cgk.Change

class Escalate implements Serializable {

  def steps
  def env
  def currentbuild
  private Boolean mDryrun
  private String mRfc

  /*
   *
   */
  Escalate( Steps, type, message ){
    this.steps = Steps
    this.mRfc = Rfc
    this.mDryrun = Dryrun
    this.type = type
    this.message = message
  }

  def call( String message ){
    switch( this.type ){
      case "cegekaComponent":
        change.transfer( "", "", message )
        break
      case "argentaComponent":
        change.transfer( "", "", message )
        break
  } // call

} //class
