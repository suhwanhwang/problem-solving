class Solution {
    public int[] threeEqualParts_bf(int[] arr) {
        
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 2; j < arr.length; ++j) {
                int first = toInt(arr, 0, i);
                int second = toInt(arr, i + 1, j - 1);
                int third = toInt(arr, j, arr.length - 1);
                if (first == second && second == third) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    private int toInt(int[] arr, int s, int e) {
        int result = 0;
        for (int i = s; i <= e; ++i) {
            result <<= 1;
            result |= arr[i];
        }
        return result;
    }
    
    public int[] threeEqualParts(int[] arr) {
        int oneCount = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 1) {
                oneCount++;
            }
        }
        
        if (oneCount == 0) {
            return new int[]{0, arr.length -1};
        }
        
        if (oneCount % 3 != 0) {
            return new int[]{ -1, -1 };
        }
        
        int[] part = new int[3];
        int oneByPart = oneCount / 3;
        int count = 0;
        
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 1) {
                if (count == 0 || count == oneByPart || count == oneByPart * 2) {
                    part[count / oneByPart] = i;
                } 
                count++;
            }
        }
        
        while(part[2] < arr.length) {
            if (arr[part[0]] != arr[part[1]] || arr[part[1]] != arr[part[2]]) {
                return new int[]{-1, -1};
            }
            part[0]++;
            part[1]++;
            part[2]++;
        }
        
        return new int[]{part[0] -1, part[1]};
    }
}
