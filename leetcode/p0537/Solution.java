// https://leetcode.com/problems/complex-number-multiplication/
class Solution {
    static private class ComplexNum {
        int real;
        int imaginary;
    }
    
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNum c1 = convertToComplex(num1);
        ComplexNum c2 = convertToComplex(num2);
        
        ComplexNum result = multiplyComplex(c1, c2);
        return convertToString(result);
    }
    
    private ComplexNum convertToComplex(String num) {
        ComplexNum c = new ComplexNum();
        int plusPos = getPlusPos(num);
        if (plusPos == -1) {
            return c;
        }
        String real = num.substring(0, plusPos);
        String imaginary = num.substring(plusPos + 1, num.length() - 1);
        c.real = Integer.parseInt(real);
        c.imaginary = Integer.parseInt(imaginary);
        return c;
    }
    
    private int getPlusPos(String num) {
        for (int i = 0; i < num.length(); ++i) {
            if (num.charAt(i) == '+') {
                return i;
            }
        }
        return -1;
    }
    
    private ComplexNum multiplyComplex(ComplexNum c1, ComplexNum c2) {
        ComplexNum result = new ComplexNum();
        
        result.real = c1.real * c2.real - c1.imaginary * c2.imaginary;
        result.imaginary = c1.real * c2.imaginary + c1.imaginary * c2.real;
        return result;
    }
    
    private String convertToString(ComplexNum c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.real);
        sb.append('+');
        sb.append(c.imaginary);
        sb.append('i');
        return sb.toString();
    }
}
