package funsets

object Main extends App {
  import FunSets._
  val s: Set = x => x > 0 && x < 5
  printSet(s)
  print(forall(s, x => x < 5))

  val s1: Set = x => x == 1 || x == 3 || x == 4 || x == 5 || x == 7 || x == 1000
  print(forall(s1, x => x < 5))
}
