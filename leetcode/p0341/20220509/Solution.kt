class NestedIterator(nestedList: List<NestedInteger>) {
    val flattenList = mutableListOf<Int>()
    val iterator: Iterator<Int>
    init {
        flattenList(nestedList)
        iterator = flattenList.iterator()
        //println(allList)
    }
    
    fun flattenList(list: List<NestedInteger>) {
        for (ni in list) {
            if(ni.isInteger) {
                flattenList.add(ni.getInteger())
            } else {
                flattenList(ni.getList())
            }
        }
    }
    
    fun next(): Int {
        return iterator.next()
    }
    
    fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}
