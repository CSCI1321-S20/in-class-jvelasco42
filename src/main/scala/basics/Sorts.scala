package basics


object Sorts extends App {
    def bubbleSort[A <% Ordered[A]](arr: Array[A]): Unit = {
        for(i <- 0 until arr.length; j <- 0 until arr.length - 1 - i) {
            if(arr(j) > arr(j+1)) {
                val temp = arr(j)
                arr(j) = arr(j+1)
                arr(j+1) = temp
            }
        } 
    }

    def bubbleSort2[A](arr: Array[A])(gt: (A,A) => Boolean): Unit = {
        for(i <- 0 until arr.length; j <- 0 until arr.length - 1 - i) {
            if(gt(arr(j), arr(j+1))) {
                val temp = arr(j)
                arr(j) = arr(j+1)
                arr(j+1) = temp
            }
        } 
    }

    val nums = Array.fill(20)(util.Random.nextInt(100))
    println(nums.mkString(","))
    bubbleSort2(nums)(_ < _)
    println(nums.mkString(","))
}