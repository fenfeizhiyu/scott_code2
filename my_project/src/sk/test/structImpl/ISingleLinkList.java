package sk.test.structImpl;

/**
 * 单向链表
 * @author yu.yang
 *
 * @param <T>
 */
public class ISingleLinkList<T> extends IArrayList<T>{
    
    private int size=0;
    private Node<T> head=null;
    private Node<T> tail=null;
   
    
    public boolean add(T value)
    {
	addToList(new Node<T>(value){});
	return true;
    }
    
    
    public boolean addToList(Node<T> node){
	if(head==null){
	    head=node;
	    tail=node;
	}else{
	    tail.next=node;
	    tail=node;
	}
	size++;
	return true;
    }
    
    
    public boolean remove(T value){
	//查找
	Node<T> prev=null;
	Node<T> node=head;
	while(node.next!=null&&(!node.value.equals(value)))
	{
	    prev=node;
	    node=node.next;
	}
	//没找到
	if(node==null)
	    return false;
	return false;
    }
    /**
     * 节点类
     * @author yu.yang
     *
     * @param <T>
     */
    private static class Node<T>{
	private T value=null;
	private Node<T> prev=null;
	private Node<T> next=null;
	
	private Node(){};
	
	private Node(T value){
	    this.value=value;
	}

	@Override
	public String toString() {
	    return "value is"+value.toString()+" prev is "+prev!=null?prev.toString():"null"+" next is "+
	    next!=null?next.toString():"null";
	}
	
	
    };
}
