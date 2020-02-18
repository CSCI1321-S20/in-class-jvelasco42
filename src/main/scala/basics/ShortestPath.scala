package basics

import adt.ArrayQueue
import collection.mutable

object ShortestPath {
    val maze = Array(
        Array(0,1,0,0,0,0,0,0,0,0),
        Array(0,1,0,1,1,1,1,1,1,0),
        Array(0,1,0,0,0,1,0,0,0,0),
        Array(0,1,1,1,0,1,0,1,1,1),
        Array(0,1,0,0,0,1,0,0,0,0),
        Array(0,0,0,0,0,1,0,1,1,0),
        Array(0,1,1,1,1,1,0,0,0,0),
        Array(0,1,0,0,0,1,1,0,1,0),
        Array(0,1,0,1,0,1,0,0,1,0),
        Array(0,0,0,1,0,0,0,0,1,0)
    )

    //add four more directions for diagonal
    val offsets = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    def breadthFirstShortestPath(sx: Int, sy: Int, ex: Int, ey: Int): Int = {
        //if isClear
        val queue = new ArrayQueue[(Int, Int, Int)]()
        val visited = mutable.Set[(Int, Int)]((sx, sy))
        queue.enqueue((sx, sy, 0))
        while (!queue.isEmpty) {
            val (x, y, steps) = queue.dequeue()
            for ((offsetx, offsety) <- offsets) {
                val nx = x + offsetx
                val ny = y + offsety
                if (nx == ex && ny == ey) return steps + 1
                if (nx >= 0 && nx < maze.length && ny >= 0 && ny < maze(nx).length &&
                        maze(nx)(ny) == 0 && !visited((nx, ny))) {
                    queue.enqueue((nx, ny, steps + 1))
                    visited += nx -> ny
                }
            }
        }
        //return huge number if path doesn't exist so min comparison works
        1000000000
        
        //else 1000000000
    }

    def main(args: Array[String]): Unit = {
        println(breadthFirstShortestPath(0, 0, 9, 9))
    }
}

/*
wrap whole thing in another if so that if starting in a wall, return 1000000000; check for isClear
steps and return value stay Ints, everything else is Doubles
(nx - ex).abs < 1, same for y. checking for distance because Doubles
*/