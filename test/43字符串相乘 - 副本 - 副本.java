//未优化相加
public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        
        for(int j=num2.length()-1;j>=0;j--){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<num2.length()-1-j;i++){
                sb.append(0);
            }
            int carry=0;
            int n2 = num2.charAt(j)-'0';
            for(int i=num1.length()-1;i>=0;i--){
                int n1 =i>=0? num1.charAt(i)-'0' : 0;
                int tmp=n1*n2+carry;
                carry=tmp/10;
                sb.append(tmp%10);
            }
            if(carry!=0){
                sb.append(carry);
            }
            res = help(res,sb.reverse().toString());
        }
        return res;
    }
    public String help(String str1,String str2){
        System.out.println(str1);
        System.out.println(str2);
        StringBuilder sb = new StringBuilder();
        int i = str1.length()-1;
        int j = str2.length()-1;
        int carry=0;
        while(i>=0 || j>=0){
            int n1 = i>=0? str1.charAt(i)-'0' : 0;
            int n2 = j>=0? str2.charAt(j)-'0' : 0;
            int tmp = n1+n2+carry;
            carry=tmp/10;
            sb.append(tmp%10);
            i--;
            j--;
        }
        if(carry==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

//优化后相加
public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            int n1 = num1.charAt(i)-'0';
            for(int j=num2.length()-1;j>=0;j--){
                int n2 = num2.charAt(j)-'0';
                int sum =res[i+j+1]+n1*n2;
                res[i+j+1]=sum%10;
                res[i+j]+=sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(res[i]==0 && i==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
