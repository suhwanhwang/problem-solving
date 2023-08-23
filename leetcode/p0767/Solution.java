class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        Queue<Character> pq = new PriorityQueue<>((a, b) -> - Integer.compare(map.get(a), map.get(b)));
        
        for (char c : map.keySet()) {
            pq.offer(c);
        }
        
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            char first = pq.poll();
            char prev = (sb.length() == 0 ? ' ' : sb.charAt(sb.length() - 1));
            char cur = first;
            
            if (prev == first) {
                if (pq.isEmpty()) {
                    return "";
                } else {
                    cur = pq.poll();
                }
            }
            
            sb.append(cur);
            int count = map.get(cur) - 1;
            map.put(cur, count);
            if (count > 0) {
                pq.offer(cur);
            }
            if (cur != first) {
                pq.offer(first);
            }
            
            /*
            if (pq.isEmpty()) {
                if (map.get(first) > 1 || first == sb.charAt(sb.length() - 1)) {
                    return "";
                } else {
                    sb.append(first);
                    return sb.toString();
                }
            }
            char second = pq.poll();
            int firstNum = map.get(first);
            int secondNum = map.get(second);
            while (firstNum > 0 && secondNum > 0) {
                sb.append(first);
                sb.append(second);
                firstNum--;
                secondNum--;
            }
            */
            /*
            if (firstNum > 0) {
                sb.append(first);
                firstNum--;
            }*/
            /*
            map.put(first, firstNum);
            map.put(second, secondNum);
            if (firstNum > 0) {
                pq.offer(first);
            }
            */
        }
        return sb.toString();
    }
}
