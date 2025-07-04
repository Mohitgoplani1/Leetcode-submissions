class Solution {
    func countCollisions(_ directions: String) -> Int {
        var d = Deque(directions), stack = [Character](), result = 0
        while !d.isEmpty {
            // "RL" becomes "S"
            while let last = stack.last, last == "R", let f = d.first, f == "L" {
                result += 2
                stack.removeLast()
                d.removeFirst()
                d.prepend(contentsOf: "S")
            }
            // "RS" collision
            while let last = stack.last, last == "R", let f = d.first, f == "S" {
                result += 1
                stack.removeLast()
            }
            // "SL collision"
            while let last = stack.last, last == "S", let f = d.first, f  == "L" {
                result += 1
                d.removeFirst()
            }
            guard let f = d.first else { break }
            stack.append(f)
            d.removeFirst()
        }
        return result
    }
}