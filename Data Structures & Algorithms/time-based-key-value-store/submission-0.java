class TimeMap {

    private Map<String,List<Pair>> map; 

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
   .add(new Pair(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (values.get(mid).getTimeStamp() <= timestamp) {
                result = values.get(mid).getEmotionValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

}

class Pair {

    private String emotionValue;
    private Integer timeStamp;

    public Pair(Integer key, String value){
        this.emotionValue = value;
        this.timeStamp = key;
    }

    public String getEmotionValue(){
        return this.emotionValue;
    }

    public void setEmotionValue(String value){
        this.emotionValue = value;
    }

    public Integer getTimeStamp(){
        return this.timeStamp;
    }

    public void setTimeStamp(int key){
        this.timeStamp = key;
    }



}
