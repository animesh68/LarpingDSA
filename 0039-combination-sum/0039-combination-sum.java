class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        bt(candidates,target,res,0,0, new ArrayList<>());
        return res;
    }
    static void bt(int[] candidates,int target,List<List<Integer>> res,int i,int sum,List<Integer> diary){
        if(sum==target){
            res.add(new ArrayList<>(diary));
            return;
        }
        if(sum>target) return ;

         for(int j = i; j < candidates.length; j++) {
            diary.add(candidates[j]);
            sum += candidates[j];

            bt(candidates,target,res,j,sum,diary);

            diary.remove(diary.size() - 1);
            sum -= candidates[j];
        }
    }
}