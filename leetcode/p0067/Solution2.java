class Solution {
    /*
    public String addBinary(String a, String b) {
        String reversedA = new StringBuilder(a).reverse().toString();
        String reversedB = new StringBuilder(b).reverse().toString();
        int maxLen = Math.max(a.length(), b.length());

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < maxLen; ++i) {
            int numA = (reversedA.length() > i ? reversedA.charAt(i) - '0' : 0);
            int numB = (reversedB.length() > i ? reversedB.charAt(i) - '0' : 0);
            int sum = carry + numA + numB;
            int remain = sum % 2;
            carry = sum / 2;
            result.append(remain);
        }
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
    */

    public String addBinary(String a, String b) {
        int carry = 0;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (carry > 0 || indexA >= 0 || indexB >= 0) {
            int numA = (indexA >= 0 ? a.charAt(indexA--) - '0' : 0);
            int numB = (indexB >= 0 ? b.charAt(indexB--) - '0' : 0);
            int sum = carry + numA + numB;
            int num = sum % 2;
            carry = sum / 2;
            sb.append(num);
        }
        return sb.reverse().toString();
    }
}
