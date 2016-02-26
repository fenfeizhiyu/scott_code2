package sk.test.struct;

public interface IList<T> {

	/**
	 * 添加元素
	 * @param value
	 * @return true 成功添加
	 */
	public boolean add(T value);
	
	/**
	 * 删除元素
	 * @param value
	 * @return true 成功删除
	 */
	public boolean remove(T value);
	
	/**
	 * 清空元素
	 */
	public void clear();
	
	/**
	 * 是否包含元素
	 * @param value
	 * @return true 包含  false  不包含
	 */
	public boolean contains(T value);
	
	
	/**
	 * list 大小
	 * @return list 大小
	 */
	public int size();
	
	/**
	 * 验证list的完整性
	 * @return
	 */
	public boolean validate();
	
}