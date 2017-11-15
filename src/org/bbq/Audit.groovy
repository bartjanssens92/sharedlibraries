// org/bbq/Audit.groovy
package org.bbq

// For writing to a log file
import java.io.File

// testing
import org.bbq.Change

class Audit implements Serializable {

  def steps
  def env
  def currentbuild
  private Boolean mDryrun
  private String mRfc
  private String format = 'plain'
  private String target = 'logfile'
  private String date = new Date().format('yyyy-MM-dd').toString()
  private String logfile = "/var/log/jenkins_auditlog/audit-${date}"

  /**
   * Audit: log a message with a comment
   *
   * @param {object} Steps - the steps object from the pipeline
   * @param {string} target - the place where to point the escalation ( defaults to logfile )
   * @param {format} format - the format to use for the message ( defaults to plain )
   */
  Audit( Steps, Dryrun, Rfc, target ){
    this.steps = Steps
    this.mRfc = Rfc
    this.mDryrun = Dryrun
    this.TestUsd = TestUsd
    this.target = target
    this.format = format
    this.logfile = logfile
  }

  def call( String message ){
    //writeMessage( formLine( message ) )
    def change = new Change( this.steps, this.mRfc, this.mDryrun, this.TestUsd )
    this.change.transfer( "grouptest", "me", message )
  } // def audit

  def writeMessage( String line ){
    // Figure out what to do with it
    switch( this.target ) {
      case "logfile":
        writeLogFile( line )
      case "syslog":
        writeSyslog( line )
    }
  }

  def user( String user ){
    writeMessage( formLine( "Created user: ${user}" ) )
  }

  def formLine( String message ){
    def dateepoch = System.currentTimeMillis().toString()
    // Build the line to add
    // Parameters available: everthing in the env and currentbuild objects
    def line = "${dateepoch} : ${env.JOB_NAME}_${currentbuild.id} : ${message}"
    // Return the line
    return line
  }

  def writeLogFile( String line ){
    // Make sure the logfile exists
    checkLogFile()
    // Append to the log file
    def f = new File( this.logfile )
    f.append( line + '\n' )
    //f.append( dateepoch + ': ' + env.JOB_NAME + " took ${currentbuild.duration} to build \n" )
  } // def writelog

  def checkLogFile(){
    if( ! new File( this.logfile ).isFile() ){
      new File( this.logfile).createNewFile()
    }
  } // def checklogfile

  def writeSyslog( String line ){
    System.out.println( line )
  } //def printmessage


} // class Audit
