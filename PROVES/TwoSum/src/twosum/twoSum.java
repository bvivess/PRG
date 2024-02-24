package twosum;

class twoSum {
    
    static private int[] solution(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        //
        return null;
    }
    
    public static void main(String[] args) {
        int entrada[] = { 1, 2, 3, 4, 5};
        int sortida[] = solution( entrada, 8);
        
        for (int i = 0; i < sortida.length; i++) {
            System.out.println(sortida[i]);
        }
    }
}