package drlewio

import scalafx.scene.canvas.GraphicsContext

class PillPiece(val x: Int, val y: Int, val color: ColorOption.Value) extends GridCell {
    def move(dx: Int, dy: Int): PillPiece = {
        new PillPiece(x + dx, y + dy, color)
    }
    def moveAllowed(dx: Int, dy: Int, isClear: (Int, Int) => Boolean): Boolean = {
        
    }
}