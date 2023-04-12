class Solution {
    func simplifyPath(_ path: String) -> String {
        let tokens = path.components(separatedBy: ["/"])
        var simplify = [String]()

        for t in tokens {
            if t == "" || t == "." {
                // ignore
            } else if t == ".." {
                if simplify.count > 0 {
                    simplify.removeLast()
                }
            } else {
                simplify.append(t)
            }
        }

        return "/" + simplify.joined(separator: "/")
    }
}
