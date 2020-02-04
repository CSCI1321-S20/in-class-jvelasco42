package drlewio

class Pill(pieces: Seq[PillPiece]) extends Element {
    def cells: Seq[GridCell] = pieces

    def move(dx: Int, dy: Int, isClear: (Int, Int) => Boolean): Pill = {
        if(pieces.forall(_.moveAllowed(dx, dy, isClear))) {
            new Pill()
        }
        new Pill(pieces.map(_.move(dx, dy)))
    }
}