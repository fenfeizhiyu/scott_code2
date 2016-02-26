package sk.test.structImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import sk.test.struct.IList;

public class IArrayList<T> implements IList<T> {

    // 默认初始大小
    private static final int default_size = 100;
    // 实际大小
    private int size = 0;
    /*
     * 默认初始数组
     */
    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[default_size];

    @Override
    public boolean add(T value) {
	add(size,value);
	return false;
    }

    /**
     * 在指定位置插入
     * 
     * @param index
     * @param value
     * @return
     */
    public boolean add(int index, T value) {
	// 超出默认容量 则扩大数组
	if (index >= array.length)
	    grow();
	// 在末尾插值
	if (index == size) {
	    array[size++] = value;
	 //在中间插值
	} else if (index < size) {
	    System.arraycopy(array, index, array, index+1, size-index);
	    array[index]=value;
	 //位置溢出
	} else {
	     return false;
	}
	return false;
    }

    /**
     * 增长默认数组容量 扩大一倍
     */
    private void grow() {
	int growSize = size << 1;
	array = Arrays.copyOf(array, growSize);
    }

    /**
     * 压缩默认数组 压缩一倍
     */
    private void shrink() {
	int shrinkSize = size >> 1;
	array = Arrays.copyOf(array, shrinkSize);
    }

    @Override
    public boolean remove(T value) {
	for(int i=0;i<array.length;i++){
	    T obj=array[i];
	    if(obj.equals(value)){
		if(remove(i)!=null)return true;
		else return false;
	    }
	}
	return false;
    }
    
    /**
     * 移除指定位置的元素
     * @return
     */
    public T remove(int index){
	if(index<0||index>size) return null;
	T t=array[index];
	//删除位置在数组中间
	if(index!=--size){
	    System.arraycopy(array,index+1, array,index, size-index);
	}
	//置空末尾的值
	array[index]=null;
	
	int shrinkSize=array.length>>1;
	if(shrinkSize>=this.default_size&&size<shrinkSize){
	    shrink();
	}
	return t;
    }

    public T set(int index, T value) {
        if (index<0 || index>=size) return null;
        T t = array[index];
        array[index] = value;
        return t;
    }

    /**
     * Get value at index.
     * 
     * @param index of value to get.
     * @return value at index.
     */
    public T get(int index) {
        if (index<0 || index>=size) return null;
        return array[index];
    }
    
    @Override
    public void clear() {
	size=0;
    }

    @Override
    public boolean contains(Object value) {
	for(int i=0;i<size;i++){
	    T t=array[i];
	    if(t.equals(value))return true;
	    else return false;
	}
	return false;
    }

    @Override
    public int size() {
	// TODO Auto-generated method stub
	return size;
    }

    @Override
    public boolean validate() {
	int localSize=0;
	for(int i=0;i<array.length;i++){
	    T t=array[i];
	    if(i<size){
        	if(t==null) return false;
        	else localSize++;
	    }else{
		if(t!=null)return false;
	    }	
	}
	 
	return (localSize==size);
    }

  
}
