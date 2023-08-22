class Solution {
    public String convertToTitle(int columnNumber) {
        int colNum = columnNumber;
        StringBuilder sb = new StringBuilder();
        
        while (colNum > 0) {
            sb.insert(0, (char)('A' + ((colNum - 1) % 26)));
            colNum = (colNum - 1) / 26;                
        }
        return sb.toString();
    }
}
