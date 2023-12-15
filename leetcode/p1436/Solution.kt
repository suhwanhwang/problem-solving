class Solution {
    fun destCity(paths: List<List<String>>): String {
        
        val map = mutableMapOf<String, String>()
        for (path in paths) {
            map[path[0]] = path[1]
        }
        
        for (path in paths) {
            if (map[path[1]] == null) {
                return path[1]
            }
        }
        
        return ""
    }
}
