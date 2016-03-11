package sk.test.structImpl.list;

import java.util.ArrayList;
import java.util.List;

public class IHashMap<K,V> {
    
    private float loadFactor=10f;
    private int minimunumber=1024;
    private int initialListSize = 10;
    private List<Pair<K, V>>[] array = null;
    private int size=0;
    
    public IHashMap(int size){
	initializeMap(size);
    }
    
    public IHashMap(){
	initializeMap(minimunumber);
    }
    
    
    
    private void initializeMap(int length){
	this.array=new ArrayList[length];
	for(int i=0;i<array.length;i++){
	    this.array[i]=new ArrayList<Pair<K, V>>(initialListSize);
	}
	this.size=0;
    }
    
    
    
    
    
    /**
     * 键值对类
     * @author yu.yang
     *
     * @param <K>
     * @param <V>
     */
    private final static class Pair<K,V>{
	private K key=null;
	private V value=null;
	
	public Pair(K key, V value) {
	    super();
	    this.key = key;
	    this.value = value;
	}

	@Override
	public int hashCode() {
	    // TODO Auto-generated method stub
	    return 31*this.key.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	   if(obj==null)
	       return false;
	   if(!(obj instanceof Pair))
	       return false;
	   Pair<K,V> p=(Pair<K,V> )obj;
	    return key.equals(p.key);
	}
	
	
    }
    
    
}
