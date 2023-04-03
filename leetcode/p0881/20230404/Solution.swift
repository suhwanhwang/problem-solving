class Solution {
    /*
    1 2 2 3
      lr
  c 2 
    */
    func numRescueBoats(_ people: [Int], _ limit: Int) -> Int {
        let sorted = people.sorted()
        var left = 0
        var right = sorted.count - 1
        var count = 0
        while left <= right {
            let leftPerson = sorted[left]
            let rightPerson = sorted[right]

            if left != right && leftPerson + rightPerson <= limit {
                count += 1
                left += 1
                right -= 1
            } else {
                count += 1
                right -= 1
            }
        }
        return count
    }

}
