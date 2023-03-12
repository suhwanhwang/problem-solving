class Solution {
    fun simplifyPath(path: String): String {
        val tokens = path.split("/")
        //println(tokens)
        val simplify = mutableListOf<String>()
        
        for (t in tokens) {
            if (t == "" || t == ".") {
                continue
            } else if (t == "..") {
                if(simplify.size > 0) {
                    simplify.removeAt(simplify.size - 1)
                }
            } else {
                simplify.add(t)
            }
        }
        //println(simplify)
        
        if (simplify.size == 0) {
            return "/"
        }

        val sb = StringBuilder()
        for (t in simplify) {
            sb.append('/')
            sb.append(t)
        }
        return sb.toString()
    }
}
