    
//������Ӵ�
  String str = "";
    int max=0;
    public String longestPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            compare(s,i,i);
            compare(s,i,i+1);
        }
        return str;
    }

    public void compare(String s,int start,int end){
        int len=0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        len=end-start-1;
        if(max<len){
            max=len;
            str=s.substring(start+1,start+len+1);
        }
    }


//�����Ӵ��ĸ���
public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //����ż����
            res += countSegment(s, i, i);
            res += countSegment(s, i, i + 1);
        }
        return res;
    }

    //start������ܣ�end���ұ���, �ж�s[start, end]�Ƿ�Ϊ����
    public int countSegment(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++))
            count++;
        return count;
    }