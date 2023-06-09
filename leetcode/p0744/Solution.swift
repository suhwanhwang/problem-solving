class Solution {
    /*
    0 1 2
    c f j
l   ^
r   ^
m   ^    
    */
    func nextGreatestLetter(_ letters: [Character], _ target: Character) -> Character {
        let first = letters[0]
        let letters = letters.sorted()
        let n = letters.count

        var left = 0
        var right = n - 1
        while left < right {
            let mid = left + (right - left) / 2

            if letters[mid] > target {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return (letters[left] > target ? letters[left] : first)
    }
}
