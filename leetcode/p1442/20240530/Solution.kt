class Solution {
    fun countTriplets(arr: IntArray): Int {
        var count = 0
            
        for (i in 0 until (arr.size - 1)) {
            for (k in (i + 1) until arr.size) {
                var a = 0
                var b = 0
                for (l in i..k) {
                    b = b xor arr[l]
                }
                
                for (j in (i + 1)..k) {
                    a = a xor arr[j - 1]
                    b = b xor arr[j - 1]
                    if (a == b) count++
                }
            }
        }
        
        return count
    }
}
