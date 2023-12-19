class Solution {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        
        val output = Array<IntArray>(img.size) {IntArray(img[0].size)}
        
        for (i in 0 until img.size) {
            for (j in 0 until img[i].size) {
                
                output[i][j]=nineAvg(img, i, j)
            }
        }
        return output
    }

    private fun nineAvg(img: Array<IntArray>, row: Int, col: Int): Int {
        var sum = 0
        var count = 0
        for (i in (row - 1)..(row + 1)) {
            for (j in (col - 1)..(col + 1)) {
                if (i < 0 || i >= img.size || j < 0 || j >= img[i].size) continue
                
                sum+=img[i][j]
                count++
            }
        }
        return sum / count
    }
}
