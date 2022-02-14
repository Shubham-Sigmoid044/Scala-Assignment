package Exercise
import scala.collection.immutable.ListMap


import scala.annotation.tailrec

object scala_assignment extends App {

  // Create the array from 0 to 100 with interval 0.05
  val bucket = (BigDecimal(0.000) to BigDecimal(100.05)).by(BigDecimal(0.05)).toArray

  
  // Used the upper bound to get the particular result
  def binarySearch_tailRec(arr: Array[BigDecimal], target: BigDecimal): Int = {
    @tailrec
    def bs_helper(arr: Array[BigDecimal], target: BigDecimal, start: Int, end: Int): Int = {
      if (start > end) return start
      val mid = start + (end - start) / 2
      arr(mid) match {
        case i if (i > target) => bs_helper(arr, target, start, mid - 1)
        case _ => bs_helper(arr, target, mid + 1, end)
      }
    }

    bs_helper(arr, target, 0, arr.length - 1)
  }


  val test = Array(12.05,
    12.03,
    10.33,
    11.45,
    13.50)

  test.foreach(x => {
    val p: Int = binarySearch_tailRec(bucket, x)
    println(bucket(p - 1) + "-" + (bucket(p) - 0.001))
  })

}
