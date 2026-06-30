class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length());
            sb.append('#');
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> r = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int size = 0;
            while(str.charAt(i)!= '#'){
                size*=10;
                size+=str.charAt(i) - '0';
                i++;
            }
            i++;
            r.add(str.substring(i, i+ size));
            i+=size;
        }
        return r;
    }
}
