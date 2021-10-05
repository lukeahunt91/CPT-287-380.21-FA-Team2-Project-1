package project_1;

public interface Movie_Iterator{
	
	/**
	 * Tests whether there exist a next item at current iterator position.
	 * @return: {true} if there exists a next item; {false} otherwise;
	 */
	boolean hasNext();

	/**
	 * Moves the iterator forward and returns the item passed by.
	 * @return: the item passed by during the iterator movement
	 * @throws IllegalArgumentException: hasNext() is false.
	 */
	Movie next();
	
	/**
	 * Removes and returns the next item at the current iterator position.
	 * @return: the next item at current iterator position
	 * @throws IllegalArgumentException: hasNext() is false.
	 */
	Movie removeNext();
	
	/**
	 * Tests whether there exists a previous item at current iterator position.
	 * @return: true if there exists a previous item; false otherwise;
	 */
	boolean hasPrevious();
	
	/**
	 * Moves the iterator backward and returns the item passed by.
	 * @return: the item passed by during the iterator movement
	 * @throws IllegalArgumentException: hasPrevious() is false.
	 */
	Movie previous();
	
	/**
	 * Removes and returns the previous item at the current iterator position.
	 * @return: the next item at current iterator position
	 * @throws IllegalArgumentException: hasPrevious() is false.
	 */
	Movie removePrevious();
	
	/**
	 * Inserts item at current iterator position
	 * @param item: item to be inserted 
	 */
	void add(Movie item);
	
	/**
	 * Updates the next item at current iterator position
	 * @param value: updated value
	 * @throws IllegalArgumentException: hasNext() is false.
	 */
	void setNext(Movie value);
	
	/**
	 * Updates the previous item at current iterator position
	 * @param value: updated value
	 * @throws IllegalArgumentException: hasPrevious() is false.
	 */
	void setPrevious(Movie value);
}
