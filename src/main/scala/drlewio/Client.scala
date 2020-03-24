package drlewio

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode
import java.net.Socket
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

object Client {
  val canvas = new Canvas(800,800)
  val gc = canvas.graphicsContext2D
  val renderer = new Renderer(gc)

  val sock = new Socket("localhost", 8000)
  val ois = new ObjectInputStream(sock.getInputStream())
  val oos = new ObjectOutputStream(sock.getOutputStream())

  stage = new JFXApp.PrimaryStage {
    title = "Dr. Lewio"
    scene = new Scene(800,800) {
      content = canvas
            
      onKeyPressed = (ke: KeyEvent) => oos.writeObject(ke.code) // Send to server. grid.keyPressed(ke.code)
      onKeyReleased = (ke: KeyEvent) => oos.writeObject(ke.code) // Send to server. grid.keyReleased(ke.code)
    }
  }
      //renderer.render(pg)

}