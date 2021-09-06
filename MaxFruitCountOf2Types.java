import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, max = 0;
        Map<Character, Integer> values = new HashMap<>();
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            char c = arr[windowEnd];
            values.put(c, values.getOrDefault(c, 0) + 1);
            while(values.size()>2){
                char r = arr[windowStart++];
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

