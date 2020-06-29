//两两交换链表的节点，交换奇数位置和偶数位置的节点24
public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next=head;
        ListNode pre = res;
        while(head!=null && head.next!=null){
            //标出要交换的两个节点
            ListNode firstNode = head;
            ListNode secondNode = head.next;
            //交换
            pre.next=secondNode;
            firstNode.next=secondNode.next;
            secondNode.next=firstNode;
            //重新移动
            pre=firstNode;
            head=pre.next;
        }
        return res.next;
    }
	
//翻转链表，206
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
	
//k个一组翻转链表25
 public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ListNode res = new ListNode(-1);
        res.next=head;
        ListNode pre =res;
        ListNode end =res;
        while(end.next!=null){
			//找到要翻转的边界
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
	
	
//把链表中奇数位置节点和偶数位置节点都分别放在一起
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

//旋转链表和旋转数组一样的思路，都是先整体逆序，然后再分段逆序
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
//翻转m-n之间的链表
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