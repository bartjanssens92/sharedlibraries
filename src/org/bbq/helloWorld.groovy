// HelloWorld
package org.bbq

// Import the audit
import org.bbq.Audit

class helloWorld implements Serializable {

  def steps
  def env
  def currentbuild

  /**
   * Testing class for passing the env and currentbuild envs
   */
  HelloWorld( Steps ){
    this.steps = Steps
    this.mAudit = new Audit( this.steps )
    this.mAudit.env = env
    this.mAudit.currentbuild = currentbuild
  }

  def call( String message ){
    mAudit('nested audit message')
  }

} // class hello
