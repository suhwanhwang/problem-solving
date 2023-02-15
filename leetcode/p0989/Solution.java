class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> resultList = new ArrayList<>();
        int kNum = k;
        int index = num.length - 1;
        int carry = 0;
        while(carry > 0 || index >= 0 || kNum > 0) {
            int num1 = (index >= 0 ? num[index--] : 0);
            int num2 = (kNum % 10);
            kNum /= 10;
            int sum = carry + num1 + num2;
            carry = sum / 10;
            resultList.add(sum % 10);
        }
        Collections.reverse(resultList);
        return resultList;
    }

}
