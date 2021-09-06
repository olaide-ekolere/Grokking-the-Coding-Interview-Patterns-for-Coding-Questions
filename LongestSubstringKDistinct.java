import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int windowStart = 0, max = 0;
        Map<Character, Integer> values = new HashMap<>();
        for(int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char c = str.charAt(windowEnd);
            values.put(c, values.getOrDefault(c, 0) + 1);
            while(values.size()>k){
                char r = str.charAt(windowStart++);
                values.put(r, values.get(r)-1);
                if(values.get(r)==0){
                    values.remove(r);
                }
            }
            max = Math.max(max, (windowEnd-windowStart)+1);
        }
        return max;
    }
}
