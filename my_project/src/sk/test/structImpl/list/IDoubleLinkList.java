package sk.test.structImpl.list;

public class IDoubleLinkList<T> {

    private int size=0;
    private Node<T> head=null;
    private Node<T> tail=null;
    
    public boolean add(T value){
	return add(new Node<T>(value));
    }
    private boolean add(Node<T> node){
//        链表为空
	if(head==null){
	    head=node;
	    tail=node;
	}
	Node<T> prev=tail;
	prev.next=node;
	node.prev=prev;
	tail=node;
	size++;
	return true;
    }
    
    private boolean remove(T value){
//	find node
	Node<T> node=head;
	while(node!=null&&!node.value.equals(value)){
	    node=node.next;
	}
//	没有找到
	if(node==null)
	    return false;

	Node<T> prev=node.prev;
	Node<T> next=node.next;
//	删除唯一节点
	if(prev==null&&next==null){
	   head=null;
	   tail=null;
//	   删除头节点
	}else if(next!=null&&prev==null){
	    head=next;
	    head.prev=null;
	    node.next=null;
//	删除为尾节点
	}else if(prev!=null&&next==null){
	   tail=prev;
	   tail.next=null;
	   node.prev=null;
//	   删除中间节点
	}else{
	    prev.next=next;
	    next.prev=prev;
	    node.next=null;
	    node.prev=null;
	}
	size--;
	return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static class Node<T> {

        private T value = null;
        private Node<T> prev=null;
        private Node<T> next = null;

        private Node() { }

        private Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value + " next=" + ((next != null) ? next.value : "NULL");
        }
    }
}

