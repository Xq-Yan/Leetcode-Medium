import java.util.ArrayList;
import java.util.List;

public class No78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(num);
                res.add(temp);
            }
        }
        return res;
    }
}
