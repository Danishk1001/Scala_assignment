import scala.math.BigDecimal.double2bigDecimal

object Bucketise {
  // defining search function - binary search
  def search(num : Double , arr:Array[BigDecimal]): Int={

    // eliminating the case when value greater than 100.049
    if(num >= 100.05)
      return -1

    // last range is the answer
    if(100.00<= num && num <= 100.049)
      return arr.length-1
    else {
      var low = 0
      var high = arr.length - 1
      while (low <= high) {
        var mid = low + (high - low) /2
        if (num >= arr(mid) && num < arr(mid + 1)) {
          return mid
        } else if (arr(mid) > num)
          high = mid - 1
        else
          low = mid + 1
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {

    // creating array for searching the specific value
    val arr = (0d to 100d by 0.05d).toArray

    val list_to_check = List(12.05, 12.03, 10.33, 11.45, 13.50)

    for (x<-list_to_check){
      var ans = search(x, arr)
      if (ans>0) {
        println(s"Bucket for $x is: [${arr(ans)} - ${arr(ans)+0.049}]")
      }
      else {
          println(s"Out of range. There is no bucket for $x")
        }
    }
  }
}
