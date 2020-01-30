package mud

class Room(val name: String, val desc: String, private var items: List[Item], private val exits: Array[Int]) {
    def description(): String = ???
    def getExit(dir: Int): Option[Room] = ???
    def getItem(itemName: String): Option[Item] = {
        items.find(_.name.toLowerCase == itemName.toLowerCase) match {
            case Some(item) => 
                items = items.filter(_ != item)
                Some(item)
            case None => None
        }
    }

    def dropItem(item: Item): Unit = items ::= item
}

object Room {
    val world = readRooms()

    def readRooms(): Array[Room] = {
        val source = scala.io.Source.fromFile("world.xml")
        val lines = source.getLines()
        val r = Array.fill(lines.next.toInt)(readRoom(lines))
        source.close()
        ???
    }

    def readRoom(lines: Iterator[String]): Room = ???
}