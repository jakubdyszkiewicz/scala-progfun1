package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars: List[Char], x: Int): Boolean =
      if (chars.isEmpty)
        x == 0
      else if (x < 0)
        false
      else if (chars.head == ')')
        balanceIter(chars.tail, x - 1)
      else if (chars.head == '(')
        balanceIter(chars.tail, x + 1)
      else
        balanceIter(chars.tail, x)
    balanceIter(chars, 0)
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countResult(money: Int, coins: List[Int], ways: Int): Int =
      if (money == 0)
        1
      else if (coins.isEmpty)
        0
      else if (money - coins.head >= 0)
        ways + countResult(money - coins.head, coins, ways) + countResult(money, coins.tail, ways)
      else
        ways + countResult(money, coins.tail, ways)
    countResult(money, coins, 0)
  }

}
