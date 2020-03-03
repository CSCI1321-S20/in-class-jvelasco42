package networking

import akka.actor.Actor
import java.net.Socket
import java.io.BufferedReader
import java.io.PrintStream
import akka.actor.Props

class ChatManager extends Actor {
  import ChatManager._
  def receive = {
    case NewUser(name, sock, in, out) =>
      context.actorOf(Props(new User(name, sock, in, out)), name)
    case CheckAllInputs =>
      for(child <- context.children) child ! User.CheckInput
    case m => println("Unhandled message in User: " + m)
  }
}

object ChatManager {
  case class NewUser(name: String, sock: Socket, in: BufferedReader, out: PrintStream)
  case object CheckAllInputs
}