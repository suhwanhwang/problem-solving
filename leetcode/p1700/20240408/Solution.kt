class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val queue = ArrayDeque(students.toList())
        val stack = ArrayDeque(sandwiches.toList())
        
        var count = 0
        while(!queue.isEmpty()) {
            if (queue.first() == stack.first()) {
                queue.removeFirst()
                stack.removeFirst()
                count = 0
            } else {
                val front = queue.removeFirst()
                queue.addLast(front)
                count++
                if (count == queue.size) return queue.size
            }
        }

        return 0
    }
}
