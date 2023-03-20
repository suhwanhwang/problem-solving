class Solution {
    func canPlaceFlowers(_ flowerbed: [Int], _ n: Int) -> Bool {
        var flowerbed = flowerbed
        var count = 0
        for i in 0..<flowerbed.count {
            if flowerbed[i] == 1 {
                continue
            }
            var prev = 0
            if i != 0 {
                prev = flowerbed[i-1]
            }
            var next = 0
            if i != flowerbed.count - 1 {
                next = flowerbed[i+1]
            }
            if prev == 0 && next == 0 {
                flowerbed[i] = 1
                count+=1
            }
        }
        return count >= n
    }
}
