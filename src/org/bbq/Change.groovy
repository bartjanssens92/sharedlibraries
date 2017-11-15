// org/bbq/Change.groovy
package org.bbq

class Change implements Serializable {

  def steps
  private String rfc
  private String tenant

  Change( Steps, Rfc ){
    this.steps = Steps
    this.rfc = Rfc
  }

  def transfer( group, assignee, comment ){
    println( "TFC_transfer.sh -C ${tenant} -R ${this.rfc} -c ${comment} -g ${group} -a ${assignee} -t" )
  } // def transfer

} //class
