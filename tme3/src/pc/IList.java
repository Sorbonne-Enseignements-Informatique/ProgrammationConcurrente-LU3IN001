package pc;

public interface IList<T> {
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
	int size();

	/**
	 * Adds the specified element to this list.
	 * 
	 * @param element element to be added to this list
	 */
	void add(T element);

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param element element whose presence in this list is to be tested
	 * @return true if this list contains an element o such that element.equals(o)
	 */
	boolean contains(T element);

	/**
	 * Removes all of the elements from this list.
	 */
	void clear();

}