package ule.edi.limitedpriorityqueue;

public class LinkedQueue<T> implements QueueADT<T> {
	
	//clase anidada
	protected static class Node<D> {
		D element;
		Node<D> next;
		
		Node() {
		this.element = null;
		this.next = null;
		}
		Node(D element) {
		this.element = element;
		this.next = null;
		}
		
		}

	private int count;
	private Node<T> front, rear; 
	
	public LinkedQueue()
	 {
		// TODO Auto-generated method stub
		count = 0;
		front = null;
		rear = null;
	 } 
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
	
		if(element != null) {
			Node<T> node = new Node<T>(element);
			
			if(isEmpty() == true) {
				
				front = node;
				rear = node;
				count ++;
			}else {
				
				rear.next = node;
				rear = node;
				count ++;
				
				
			}
		}else {
			
			throw new NullPointerException();
		}
	
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	   {
		// TODO Auto-generated method stub
		if(isEmpty() == false) {
			
			T aux = null;
			aux = rear.element;
			if(size() == 1) {
			
				front = null;
				rear = null;
				
			}else {
				front = front.next;
				
			}
			count --;
			return aux;
		}else {
		throw new EmptyCollectionException("Linked queue");
		}
	   }

	@Override
	public T first()  throws EmptyCollectionException{
		// TODO Auto-generated method stub
		
		if(isEmpty() == false) {
			T e = null;
			e = front.element;
			return e;
		}else {
			
			throw new EmptyCollectionException("Linked queue");
		}

	}

	@Override
	public boolean isEmpty() {
		 // TODO Auto-generated method stub
		boolean isEmpty = false;
		
		if(size() == 0) {
			
			isEmpty = true;
		}
		return isEmpty;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public T dequeueLast() throws EmptyCollectionException {
	  // TODO Auto-generated method stub
		if(isEmpty() == false) {
			
			T e = null;
			Node <T> aux = new Node<T>();
			aux = front;
			
			while(aux.next != rear) { //mientras que el auxiliar no quede apuntando al penultimo elemento
				
				aux = aux.next; //sigue avanzando
				
			}
			e = aux.element;
			aux.next = null; //hacemos que sea el ultimo
			rear = aux; //guardamos en rear
			count --;
			return e;
		}else {
			
			throw new EmptyCollectionException("Linked queue");
		}
		
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			Node<T> actual=front;
			while (actual!=null) {
				rx.append(actual.element.toString());
				rx.append(", ");
				actual=actual.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			return rx.toString();
		}
		return ""; 


};

}
