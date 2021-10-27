//Permutations
class Solution {
    List<List<Integer>> result;
    HashSet<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        set = new HashSet<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        
        helper(nums, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> path) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }
        
        for(int i = 0 ; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            set.add(nums[i]);
            helper(nums,i,path);
            int temp = path.get(path.size() - 1);
            set.remove(temp);
            path.remove(path.size() - 1);
        }
    }
    
}

//Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        } 
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}