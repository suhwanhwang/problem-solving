import java.util.Random

class RandomizedSet() {
    private val random = Random()
    private val list = mutableListOf<Int>()
    private val map = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if (map[`val`] != null) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        val index = map[`val`] ?: return false
        
        val lastIndex = list.size - 1
        val lastNum = list.last()
        map.remove(`val`)
        list.removeAt(lastIndex)
        
        if (index != lastIndex) {
            map[lastNum] = index
            list[index] = lastNum
        }
        return true
    }

    fun getRandom(): Int {
        //println(map)
        //println(list)
        
        val index = random.nextInt(list.size)
        return list[index]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
