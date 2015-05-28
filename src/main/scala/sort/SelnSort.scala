package sort

/**
 * Created by lamuel on 5/24/15.
 */
object SelnSort {

  def selnsort(aa: Array[Int]) {
    val n = aa.length
    var j = n-1
    while(j > 0) {
      var candmaxidx = 0
      var i = 1
      while(i <= j) {
        if(aa(i) > aa(candmaxidx)) {
          candmaxidx = i
        }
        i += 1
      }
      val t = aa(j)
      aa(j) = aa(candmaxidx)
      aa(candmaxidx) = t
      j -= 1
    }
  }

  def main(args: Array[String]) {
    val aa = Array(-12,12,3,4,-45,-23,59,389,4,10)
    println(aa.toList)
    selnsort(aa)
    println(aa.toList)
  }
}