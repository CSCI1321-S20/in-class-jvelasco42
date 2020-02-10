package basics

object Utility extends App {
    //A is a variable type, and can be replaced with anything you want
    //If you name it Int, any Int in the function is the type instead of an int; shadowing the name 
    def findAndRemove[A](lst: List[A])(pred: A => Boolean): (Option[A], List[A]) = {
        def helper(rest: List[A]): (Option[A], List[A]) = rest match {
            case Nil => (None, Nil)
            case h :: t => 
                if(pred(h)) (Some(h), t) else {
                    val (o, l) = helper(t)
                    (o, h :: l)
                }
        }
        helper(lst)
    }

    val nums = List(7, 8, 5, 6)
    println(findAndRemove(nums)(_ %2 == 0))
    println(findAndRemove(nums)(_ > 100))
}