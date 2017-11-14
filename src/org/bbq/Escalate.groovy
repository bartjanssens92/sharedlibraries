// org.bbq.Escalate.groovy
package org.bbq

import java.io.File // For writing to a log file

class Escalate implements Serializable {

  def steps
  private String format = 'plain'
  private String target = 'logfile'
  private String logfile = '/var/log/escalate'

  /**
   * Escalate: escalate an RFC with a comment
   *
   * @param {object} Steps - the steps object from the pipeline
   * @param {string} target - the place where to point the escalation
   * @param {format} formate - the format to use for the message
   */
  Escalate( Steps, target ) {
    this.steps = Steps
    this.target = target
    this.format = format
    this.logfile = logfile
  }

  def escalate( String message ){
    if( this.target == 'logfile' ) {
      writelogfile( message )
    }
  } // def escalate

  def writelogfile( String message ){
    new File(this.logfile).withWriter('utf-8') {
      writer -> writer.writeLine message
    }
  } // def writelog

} // class Escalate
