//������������Ľڵ㣬��������λ�ú�ż��λ�õĽڵ�24
public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next=head;
        ListNode pre = res;
        while(head!=null && head.next!=null){
            //���Ҫ�����������ڵ�
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            //����
            pre.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;
            //�����ƶ�
            pre=firstNode;
            head=pre.next;
        }
        return res.next;
    }
	
//��ת����206
public ListNode reverseList(ListNode head) {
        ListNode res = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur!=null){
            next=cur.next;
            cur.next=res;
            res=cur;
            cur=next;
        } 
        return res;
    }
	
//k��һ�鷭ת����25
 public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next=head;
        ListNode pre =res;
        ListNode end =res;
        while(end.next!=null){
			//�ҵ�Ҫ��ת�ı߽�
            for(int i=0;i<k && end!=null ; i++){
                end=end.next;
            }
            if(end==null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=start;
        }
        return res.next;
    }
    public ListNode reverse(ListNode head){
        ListNode cur =head;
        ListNode res = null;
        ListNode next =null;
        while(cur!=null){
            next=cur.next;
            cur.next=res;
            res=cur;
            cur=next;
        }
        return res;
    }
	
	
//������������λ�ýڵ��ż��λ�ýڵ㶼�ֱ����һ��
public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode odd = head;
        ListNode event = head.next;
        ListNode eventHead =event;
        while(event!=null && event.next!=null){
            odd.next=event.next;
            odd=odd.next;
            event.next=odd.next;
            event=event.next;
        }
        odd.next=eventHead;
        return head;
    }

//��ת�������ת����һ����˼·����������������Ȼ���ٷֶ�����
public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur =head;
        int len =0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        k%=len;
        if(k==0){
            return head;
        }
        ListNode l1 = reverse(head);
        ListNode tmp = l1;
        for(int i=0;i<k-1;i++){
            tmp=tmp.next;
        }
        ListNode next = tmp.next;
        tmp.next=null;
        ListNode l2 =reverse(l1);
        ListNode l3 =reverse(next);
        ListNode end =l2;
        while(end.next!=null){
            end=end.next;
        }
        end.next=l3;
        return l2;
        

    }
    public ListNode reverse(ListNode head){
        ListNode cur =head;
        ListNode next=null;
        ListNode res =null;
        while(cur!=null){
            next=cur.next;
            cur.next=res;
            res=cur;
            cur=next;
        }
        return res;
    }
//��תm-n֮�������
public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null ||head.next==null || (m==n)){
            return head;
        }
        ListNode dump = new ListNode(-1);
        dump.next=head;
        ListNode pre = dump;
        ListNode end = dump;
        for(int i=1;i<m;i++){
            pre=pre.next;
        }
        for(int i=0;i<n;i++){
            end=end.next;
        }
        ListNode start = pre.next;
        ListNode post = end.next;
        pre.next=null;
        end.next=null;
        ListNode l1 = reverse(start);
        pre.next=l1;
        start.next=post;
        return dump.next;
        
    }
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode next=null;
        ListNode res =null;
        while(cur!=null){
            next=cur.next;
            cur.next=res;
            res=cur;
            cur=next;
        }
        return res;
    }