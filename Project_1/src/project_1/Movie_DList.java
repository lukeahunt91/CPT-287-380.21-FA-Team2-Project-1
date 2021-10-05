package project_1;

import java.sql.Date;

/**
 * TODO: displayAfter method, numComing method, editMovie method, complete iterator method overrides and remove T type reference code
 * DONE - Luke: add method, orderByRelDate(part of add), remove method, startShowing method
 */

/** A doubly-linked list */
public class Movie_DList implements Movie_Iterable {
	
	// Data fields
	private Movie head, tail;
	private int numOfNodes;
	
	//Constructors
	public Movie_DList() {} // Default Constructor
	
	/**
	 * Returns the number of nodes in the list.
	 * @return: number of nodes in the list.
	 */
	public int size() {
		return numOfNodes;
	}
	
	/**
	 * Test whether the list is empty.
	 * @return: true if size = 0
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Adds a movie to list ordered by release date
	 * @param newMovie: Movie object to be added to the list.
	 */
	public void add(Movie newMovie) {
		if(isEmpty()) {head = tail = newMovie;}
		else {
			Movie q = head;
			while (q != null) {
				if(newMovie.getReleaseDate().compareTo(q.getReleaseDate())>0) {
					newMovie.next = q;
					newMovie.prev = q.prev;
					q.prev = newMovie;
					newMovie.prev.next = newMovie;
					numOfNodes++;
					break;
				}
			}
			tail.next = newMovie;
			newMovie.prev = tail;
			tail = newMovie;
			numOfNodes++;
		}
	}
	
	/**
	 * Removes and returns movie with a specific name in the list
	 * @param name: name of movie to be removed and returned
	 * @return: the value removed
	 * @throws IllegalArgumentException
	 */
	public Movie remove(String name) {
		if (isEmpty()) {
			throw new IllegalArgumentException("Accessing empty list");
		} else {
			Movie q = head;
			while ( q != null) {
				if (q.getTitle().equals(name)) {
					Movie toBeRemoved = q;
					q.prev.next = q.next;
					q.next.prev = q.prev;
					numOfNodes--;
					return q;
				}
			}
		}
		throw new IllegalArgumentException("No movie with this name " + name + " exists in list.");
	}
	
	public void startShowing(String name, Movie_DList other) {
		Movie q = new Movie();
		q = this.remove(name);
		q.setStatus("released");
		other.add(q);
	}

	public void displayAfter(String dateString) {
		Date date = Date.valueOf(dateString);
		//TODO: finish method
	}
	
	public int numComing(String dateString) {
		int count = 0;
		Date date = Date.valueOf(dateString);
		//TODO: FINISH METHOD
		
		return count;
	}
	
	public void editMovie(String name) {
		//TODO: FINISH METHOD
	}
	
	@Override
	public Movie_Iterator iterator(){
		return new Movie_Iterator() {

			//data fields
			private Movie prevNode = null, nextNode = head;
			
			@Override
			public boolean hasNext() {
				return nextNode != null;
			}
			
			@Override
			public Movie next() {
				if (!hasNext()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				Movie passBy = nextNode;
				prevNode = nextNode;
				nextNode = nextNode.next;
				return passBy;
			}

			@Override
			public Movie removeNext() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Movie previous() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Movie removePrevious() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void add(Movie item) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setNext(Movie value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setPrevious(Movie value) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public T removeNext() {
				if (!hasNext()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				T toBeRemoved = nextNode.data;
				if (nextNode == head) {
					removeFirst();
					nextNode = head;
				} else if (nextNode == tail) {
					removeLast();
					nextNode = null;
				} else {
					prevNode.next = prevNode.next.next;
					nextNode = prevNode.next;
					numOfNodes--;
				}
				return toBeRemoved;
			}

			@Override
			public boolean hasPrevious() {
				return prevNode != null;
			}

			@Override
			public T previous() {
				if (!hasPrevious()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				T passBy = prevNode.data;
				nextNode = prevNode;
				prevNode = prevNode.prev;
				return passBy;
			}

			@Override
			public T removePrevious() {
				if (!hasPrevious()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				T toBeRemoved = prevNode.data;
				if (prevNode == head) {
					removeFirst();
					prevNode = null;
					nextNode = head;
				} else if (nextNode == tail) {
					removeLast();
					prevNode = tail;
				} else {
					prevNode = nextNode.prev.prev;
					prevNode = nextNode.prev;
					numOfNodes--;
				}
				return toBeRemoved;
			}

			@Override
			public void add(T item) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setNext(T value) {
				if (!hasNext()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				nextNode.data = value;
				next();
				
			}

			@Override
			public void setPrevious(T value) {
				if (!hasPrevious()) {
					throw new IllegalArgumentException("Accessing Null Reference");
				}
				prevNode.data = value;
				next();
				
			}

			
		};
	}
}
