// org.bbq.Escalate.groovy
package org.bbq

import java.io.File // For writing to a log file

class Escalate implements Serializable {

  def steps
  def format = plain
  def target = 'logfile'
  def logfile = '/var/log/escalate'

  // Constructor
  Escalate() {
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
