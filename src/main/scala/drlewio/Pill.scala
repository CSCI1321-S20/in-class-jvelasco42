package drlewio

class Pill(val pieces: Seq[PillPiece]) extends Element {
    def cells: Seq[GridCell] = pieces

    def move(dx: Int, dy: Int, isClear: (Int, Int) => Boolean): Pill = {
        if(pieces.forall(_.moveAllowed(dx, dy, isClear))) {
            new Pill(pieces.map(_.move(dx, dy)))
        } else this
    }

    def rotate(isClear: (Int, Int) => Boolean): Pill = {
        if(pieces.length < 2) this
        else  {
            val newPill = if(pieces(0).y == pieces(1).y) {
                val sort = pieces.sortBy(_.x)
                new Pill(Seq(sort(0).move(1, 0), sort(1).move(0, -1)))
            } else {
                val sort = pieces.sortBy(_.y)
                new Pill(Seq(sort(0).move(-1, 1), sort(1)))
            }
            if(newPill.pieces.forall(pp => isClear(pp.x, pp.y))) newPill else this
        }
    }
}