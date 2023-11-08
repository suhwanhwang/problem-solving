class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val hor = abs(fx - sx)
        val ver = abs(fy - sy)
        if (hor == 0 && ver == 0 && t == 1) return false
        return t >= hor + ver - min(hor, ver)
    }
}
