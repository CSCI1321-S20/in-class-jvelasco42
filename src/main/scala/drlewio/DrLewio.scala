package drlewio

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color
import scalafx.animation.AnimationTimer
import scalafx.scene.input.KeyEvent
import scalafx.scene.input.KeyCode

object DrLewio extends JFXApp {
    val grid = new Grid
    val canvas = new Canvas(800,800)
    val gc = canvas.graphicsContext2D
    val renderer = new Renderer(gc)

    def draw(gc: GraphicsContext): Unit = {
        gc.fill = Color.Black
        gc.fillRect(0, 0, 800, 800)
        renderer.render(grid)
    }
    stage = new JFXApp.PrimaryStage {
        title = "Dr. Lewio"
        scene = new Scene(800,800) {
            content = canvas
            
            onKeyPressed = (ke: KeyEvent) => {
                ke.code match {
                    case KeyCode.Left => grid.leftPressed()
                    case KeyCode.Right => grid.rightPressed()
                    case _ => 
                }
            }

            onKeyReleased = (ke: KeyEvent) => {
                ke.code match {
                    case KeyCode.Left => grid.leftReleased()
                    case KeyCode.Right => grid.rightReleased()
                    case _ => 
                }
            }

            val lastTime = -1L
            val timer = AnimationTimer(time => {
                if(lastTime >= 0) {
                    val delay = time - lastTime / le9
                }
                lastTime = time
            })
            timer.start()
        }
    }
}