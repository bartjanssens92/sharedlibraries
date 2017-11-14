// org.bbq.Audit.groovy
package org.bbq

// For writing to a log file
import java.io.File

class Audit implements Serializable {

  def steps
  def env
  private String format = 'plain'
  private String target = 'logfile'
  private String date = new Date().format('yyyy-MM-dd').toString()
  private String logfile = "/var/log/jenkins_auditlog/audit-${date}"

  /**
   * Escalate: escalate an RFC with a comment
   *
   * @param {object} Steps - the steps object from the pipeline
   * @param {string} target - the place where to point the escalation ( defaults to logfile )
   * @param {format} format - the format to use for the message ( defaults to plain )
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
    def dateepoch = System.currentTimeMillis().toString()
    // Append to the log file
    def f = new File( this.logfile )
    f.append( dateepoch + ': ' + env.JOB_NAME + ' ' + message + '\n' )
  } // def writelog

  def checklogfile(){
    if( ! new File( this.logfile ).isFile() ){
      new File( this.logfile).createNewFile()
    }
  } // def checklogfile

} // class Audit
