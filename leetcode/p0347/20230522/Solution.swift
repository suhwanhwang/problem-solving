class Solution {
    func topKFrequent(_ nums: [Int], _ k: Int) -> [Int] {
        var map = [Int:Int]()
        for num in nums {
            map[num] = map[num, default: 0] + 1
        }
        return Array(map.keys
        .sorted { map[$0]! > map[$1]! }
        .prefix(k))
    }
}
