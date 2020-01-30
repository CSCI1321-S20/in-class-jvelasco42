package drlewis

class Pill(pieces: Seq[PillPiece]) extends Element {
    def cells: Seq[GridCell] = pieces
}