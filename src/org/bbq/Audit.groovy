// org.bbq.Audit.groovy
package org.bbq

import java.io.File // For writing to a log file

class Audit implements Serializable {

  def steps
  private String format = 'plain'
  private String target = 'logfile'
  private String logfile = '/var/log/escalate1'

  /**
   * Escalate: escalate an RFC with a comment
   *
   * @param {object} Steps - the steps object from the pipeline
   * @param {string} target - the place where to point the escalation
   * @param {format} formate - the format to use for the message
   */
  Audit( Steps, target ){
    this.steps = Steps
    this.target = target
    this.format = format
    this.logfile = logfile
  }

  def call( String message ){
    if( this.target == 'logfile' ) {
      writelogfile( message )
    }
  } // def escalate

  def writelogfile( String message ){
    // Make sure the logfile exists
    checklogfile()
    // Get the date in epoch
    def date = 'lol'
    // Append to the log file
    def f = new File( this.logfile )
    f.append( message + '\n' )
  } // def writelog

  def checklogfile(){
    if( ! new File( this.logfile ).isFile() ){
      new File( this.logfile).createNewFile()
    }
  } // def checklogfile

} // class Audit
