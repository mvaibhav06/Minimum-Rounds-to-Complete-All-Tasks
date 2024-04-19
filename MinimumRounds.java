import java.util.HashMap;

public class MinimumRounds {
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> temp = new HashMap<>();

        for(int a : tasks){
            if(temp.containsKey(a)){
                temp.put(a, temp.get(a)+1);
            }else{
                temp.put(a,1);
            }
        }

        int out = 0;

        for(int key: temp.keySet()){
            int count = temp.get(key);
            if(count%3 == 0){
                out += count/3;
            }else if(count%2 == 0){
                while (count > 0){
                    if (count%3 == 0){
                        out += count/3;
                        break;
                    }
                    count -= 2;
                    out++;
                }

            }else{
                while(count%3 != 0 && count>2){
                    out++;
                    count -= 2;
                }
                if(count%3==0){
                    out += count/3;
                }else{
                    return -1;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
        System.out.println(minimumRounds(nums));
    }
}
