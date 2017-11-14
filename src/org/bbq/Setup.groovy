// org/bbq/Setup.groovy
package org.bbq

import org.bbq.*

class Setup implements Serializable {

  def steps
  def env
  def currentbuild

  /*
   * Setup: A class to setup all the needed objects
   */
  Setup() {
    def audit = new Audit( steps, 'logfile' )
    audit.env = env
    audit.currentbuild = currentBuild
  } // def

} // class
