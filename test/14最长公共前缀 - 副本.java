public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<strs.length;i++){
            int index = compare(strs[0],strs[i]);
            min=Math.min(index,min);
        }
        return min==0? "" : strs[0].substring(0,min);
    }
    public int compare(String str1,String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int len = Math.min(c1.length,c2.length);
        int i;
        for(i =0;i<len;i++){
            if(c1[i]==c2[i]){
                continue;
            }else{
                break;
            }
        }
        return i;
    }