package sk.test.structImpl;

import java.util.Iterator;

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
    private Iterator<T> iterator=null;
    
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
	//指向当前查找节点
	Node<T> curr=head; 
	//指向上一个查找节点
	Node<T> prev=null;
	
	while(curr!=null&&!curr.value.equals(value)){
	    prev=curr;
	    curr=curr.next;
	}

	//没找到
	if(curr==null)return false;
	
	//最后一个节点
	if(curr.next==null){
	    tail=prev;
	    //原链表只有一个节点,删除这个节点
	    if(prev==null){
		head=null;
	    //删除链表最后一个节点
	    }else{
		prev.next=null;
		tail=prev;
		curr=null;
	    }
	//中间节点
	}else{
	    //删除头节点
	    if(prev==null){
		head=curr;
		curr.next=null;
	    //删除中间节点
	    }else{
		prev.next=curr.next;
	        curr.next=null;
	    }
	}
	size--;
	return true;
    }
    
    
    public void clear(){
	head=null;
	tail=null;
	size=0;
    }
    
    /**
     * 包含
     */
    public boolean contains(Object value){
	if(head==null)
	    return false;
	Node<T> curr=head;
	while(curr!=null){
	    if(curr.value.equals(value))return true;
	    else curr=curr.next;
	}
	return false;
    }
    
    
    public int getSize(){
	return size;
    }
    
    public Iterator<T> iterator(){
	if(this.iterator==null){
	    this.iterator=new ISingleListIterator(this);
	}
	return this.iterator;
    }
    
    Node<T> getHead(){
	return head;
    }
    
    Node<T> getTail(){
	return tail;
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
    
    private  class ISingleListIterator<T> implements java.util.ListIterator<T>{
         
	private ISingleLinkList<T> iSingleLinkList;
	private Node<T> currNode=null;
	private Node<T> prevNode=null;
	
	public ISingleListIterator(ISingleLinkList<T> iSingleLinkList){
	    this.iSingleLinkList=iSingleLinkList;
	    this.currNode=iSingleLinkList.head;
	}
	
	
	@Override
	public boolean hasNext() {
	    if(head==null)
		return false;
	    else{
		if(head.next==null) return false;
		else return true;
	    }
	}

	@Override
	public T next() {
	    if(this.currNode==null)
		return null;
	    else{
		T obj=this.currNode.value;
		this.prevNode=currNode;
		this.currNode=this.currNode.next;
		return obj;
	    }
	}

	@Override
	public boolean hasPrevious() {
	    // TODO Auto-generated method stub
	    return false;
	}

	@Override
	public T previous() {
	    // TODO Auto-generated method stub
	    return null;
	}

	@Override
	public int nextIndex() {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public int previousIndex() {
	    // TODO Auto-generated method stub
	    return 0;
	}

	@Override
	public void remove() {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void set(T e) {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void add(T e) {
	    // TODO Auto-generated method stub
	    
	}

	
    }
}
