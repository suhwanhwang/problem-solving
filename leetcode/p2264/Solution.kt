class Solution {
    fun largestGoodInteger(num: String): String {
        var maxNum = -1
        for (i in 0 until (num.length - 2)) {
            if (num[i] != num[i+1] || num[i+1] != num[i+2]) continue
            
            maxNum = max(maxNum, num.substring(i, i + 3).toInt())
      }
        if (maxNum == -1) {
            return "" 
        } else if (maxNum == 0) {
            return "000"
        } else {
            return maxNum.toString()
        }
    }
}
