class Solution {
    val combination = mutableListOf<List<Int>>()
    
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        solve(k, n, 1, ArrayList<Int>())
        return combination
    }
    
    fun solve(k: Int, n: Int, num:Int, list: MutableList<Int>) {
        if (n < 0) return
        
        if (k == 0) {
            if (n == 0) {
                //println(list)
                combination.add(ArrayList(list))
            }
            return
        }
        
        for (i in num..9) {
            list.add(i)
            solve(k - 1, n - i, i + 1, list)
            list.removeAt(list.size - 1)
        }
    }
}
