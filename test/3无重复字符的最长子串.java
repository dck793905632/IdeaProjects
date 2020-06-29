public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int len = s.length();
        Set<Character> set = new HashSet<>();
        int res=0,i=0,j=0;
        while(i<len && j<len){
            if(!set.contains(c[j])){
                set.add(c[j]);
                j++;
                res = Math.max(j-i,res);
            }else{
                set.remove(c[i]);
                i++;
            }
        }
        return res;
    }