package ule.edi.limitedpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;


public class LimitedPriorityQueueLinkedImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;

	    private QueueNode<T> first;
	    private int count;
	

	private static class QueueNode<E> {
	
		public QueueNode(int priority, E content) {
			this.priority = priority;
			this.content = content;
			this.next = null;
		}
		
		public int priority;
		
		public E content;
		
		public QueueNode<E> next;
	};
	

	
	public LimitedPriorityQueueLinkedImpl(int capacity) {
		
		this.capacity = capacity;
		this.count = 0;
		this.first = null;
		
	}
	
  
    @Override
    public int getCapacity() {

        return capacity;
    }

    @Override
    public int getSize() {
        return count ;
    }

    @Override
    public boolean isFull() {
    	// TODO Auto-generated method stub
    	
    	boolean isFull = false;
    	
    	if( getSize() == count) {
    		
    		isFull = true;
    	}
    	return isFull;
    	
    }

	@Override
	public T enqueue(int p, T element) {
	   // TODO Auto-generated method stub
		
		T deleted = null;
		QueueNode n = new QueueNode<T>(p, element);
		QueueNode aux = first;
		QueueNode aux2 = first;
		QueueNode aux3 = first;
		QueueNode aux4 = first;
		
		
		
		if(p <= 0) {
			
			throw new IllegalArgumentException();
			
		}else if (element == null){
			
			throw new NullPointerException();
			
		}else {
			
			if(isEmpty() == true) {
			
				first.content = element;
				count ++;
				
			}else if(isFull() == true) {
			
				while(aux != null && aux.priority >= p) {
					
					aux = aux.next;

				}
				
				aux2 = aux;
				aux3 = aux;
				aux4 = aux;
				int moveCounter = 0;
				
				if(aux3.priority = p) { //si hay mas elementos de su misma p lo ponemos al final de esos
					while(aux3.priority = p) { //mientras sean de la misma prioridad seguimos para contar cuantos movimientos debemos hacer
					
						aux3 = aux3.next;
						moveCounter++;
					}
					
					int i = 1;
					while(i< moveCounter) {
						
						aux4 = aux4.next; //estamos en el elemento que queremos que apunte al nuevo
						
					}
					aux4.next.content = element;
						//si hay mas para la derecha
						//si es el ultimo
					
				}else if(aux3.priority >p) {
					
					//hay que quedarse en el penultimo 
				}
				
				
			}
		}
		return deleted;
	}

	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
		
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}


  
}
