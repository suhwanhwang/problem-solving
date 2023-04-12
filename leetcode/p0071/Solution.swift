class Solution {
    func simplifyPath(_ path: String) -> String {
        var charArray = [Character]()
        var token = [Character]()

        for c in path {
            if c == "/" {
                if token.isEmpty {
                    if charArray.isEmpty {
                        charArray.append(c)
                    } else if charArray.last == "/" {
                        // ignore
                    }
                } else {
                    if String(token) == "." {
                        // ignore
                    } else if String(token) == ".." {
                        if charArray.count > 1 {
                            charArray.removeLast()
                        }
                        while charArray.last != "/" {
                            charArray.removeLast()
                        }
                    } else {
                        for ch in token {
                            charArray.append(ch)
                        }
                        charArray.append(c)
                    }
                }
                token = [Character]()
            } else {
                token.append(c)
            }
        }
        if String(token) == ".." {
            if charArray.count > 1 {
                charArray.removeLast()
            }
            while charArray.last != "/" {
                charArray.removeLast()
            }
        } else if String(token) == "." {
            // ignore
        } else {
            for ch in token {
                charArray.append(ch)
            }
        }
        if charArray.count > 1 && charArray.last == "/" {
            charArray.removeLast()
        }
        return String(charArray)
    }
}
