class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /** naive approach: store the element & no of occurrences
        in hashmap and then sort it to get the top K elements **/

        /** better approach: using a sort called bucket/bin sort.
        we are gonna have an array of size nums.length and put the
        keys in the index which matches with its value(can be a list 
        of elements). and the index+1 will
        indicate the number of occurrences of the element present
        in that index.
        
        Now we will traverse from the end of the array to find the
        top K elements with maximum frequencies **/

        HashMap<Integer, Integer> storage = new HashMap<>();
        ArrayList<Integer>[] bucket = new ArrayList[nums.length];
        int[] result = new int[k];

        //storing in hashmap
        for(int num : nums){
            if(storage.containsKey(num)){
                storage.put(num, storage.get(num)+1);
            }
            else{
                storage.put(num, 1);
            }
        }

        //popultaing bucket by iterating the map
        storage.forEach((key, value) -> {
            if(bucket[value-1]!=null){
                bucket[value-1].add(key);
            }
            else{
                ArrayList<Integer> bucketList = new ArrayList<>();
                bucketList.add(key);
                bucket[value-1] = bucketList;
            }
            
        });

        //reverse traversing and popultaing result
        for(int i = bucket.length-1; k>0 ; i--){
            if(bucket[i]!=null){
                if(bucket[i].size()==1){
                    result[k-1] = bucket[i].get(0);
                    k--;
                }
                else{
                    //traverse through smaller list unit k = 0 or end of list
                    for(int resNum : bucket[i]){
                        if(k == 0)
                            break;
                        result[k-1] = resNum;
                        k--;
                    }
                }
            }
        }

        return result;


    }
}
