package org.bbq
class helloAgain implements Serializable {
  def script
  def message
  helloAgain( script, String message ) {
    this.script = script
    this.message = message
    this.script.echo("Going to yell...")
  }

  def yell( String message ) {
    this.script.echo("YELL: $message" )
  }
}
