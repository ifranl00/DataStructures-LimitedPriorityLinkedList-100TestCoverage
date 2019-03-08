package ule.edi.limitedpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import ule.edi.limitedpriorityqueue.LinkedQueue.Node;


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
    	
    	if( getCapacity() == count) {
    		
    		isFull = true;
    	}
    	return isFull;
    	
    }

    private  T dequeueLast() throws EmptyCollectionException {
    	
    	if(isEmpty() == false) {
			
			T e = null;
			
			QueueNode <T> aux = first;
			
			if(getSize() == 1) {
				
				aux = first;
				e = aux.content;
				first = null;
				
			}else {
			
				while(aux.next.next != null) { //mientras que el auxiliar no quede apuntando al penultimo elemento
				
					aux = aux.next; //sigue avanzando
				
				}
				e = aux.next.content;
				aux.next = null; //hacemos que sea el ultimo
			}
			count --;
			return e;
			
		}else {
			
			throw new EmptyCollectionException("LinkedPriorityQueueLinked");
		}	
    }
    
    
    private void enqueueFirst(int p, T element) {
    	
    	QueueNode <T> n = new QueueNode<T>(p,element);
    	
    	if(first.priority < p) { 
    		//anyadimos despues del primero
    		first.next = n;
    		n = null;
    		
    		
    	}else {
    		//anyandimos antes del primero
    		
    		n.next = first;
    		first = n;
    		
    	}
    	count ++;
    }
    
    private void enqueueNotFirst(int p, T element) {
    	
    	QueueNode <T> n = new QueueNode<T>(p,element);
		QueueNode <T> aux = first;
		
		while(aux.next != null && aux.next.priority <= p) { //mientras la prioridad sea menor
			
			aux = aux.next;
		}
		
		//anyandimos el nodo
		n.next = aux.next;
		aux.next = n;
		count ++;
    	
    }
    
	@Override
	public T enqueue(int p, T element) throws EmptyCollectionException {
	   // TODO Auto-generated method stub
		
		T deleted = null;
		QueueNode <T> n;
		QueueNode <T >aux = first;
		
		if(p <= 0) {
			
			throw new IllegalArgumentException();
			
		}else if (element == null){
			
			throw new NullPointerException();
			
		}else {
			
			if(isEmpty() == true) {
			
				first= new QueueNode <T>(p,element);
				count ++;
				
			}else if(isFull() == true) {
			
				if(getSize() == 1) {
					
					//anyadimos el nodo
					enqueueFirst(p,element);
					//borramos el ultimo
					deleted = dequeueLast();
					count --;
					
					
				}else {
				
					//anyadimos el nodo
					enqueueNotFirst(p, element);
					//borramos el ultimo
					deleted = dequeueLast();
					count --;
				}
				
			}else { // si no esta llena
				
				if(getSize() == 1) {
					
					//anyadimos el nodo
					enqueueFirst(p,element);
					
				}else {
					
					//anyadimos el nodo
					enqueueNotFirst(p, element);
				}
					
			}
		}
		return deleted;
	}

	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		
		T e = null;
		
		if(isEmpty() == true) {
			
			throw new EmptyCollectionException("LinkedPriorityQueueLinked");
			
		}else {
			
			e = first.content;
			
		}
		
		return e;
		
	}

	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		
		T e = null;
		
		if(isEmpty()) {
			
			throw new EmptyCollectionException("LinkedPriorityQueueLinked"); 

		}else {
			e = first.content;
			
			if(getSize() == 1) {
				first = null;
				
			}else {
				first = first.next;
			}
			count --;
		}
		
		return e;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	@Override
	public String toString() {
		
		boolean separator=false;
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			QueueNode <T >aux = first;
			QueueNode <T >auxFinal = first;
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
			aux = first;
			int i = 0;
			
			//para buscar el elemento final
			while(auxFinal.next != null) {
				
				auxFinal = auxFinal.next;
			}
			
			while(aux.next != null) {
						
				i = aux.priority;
				
				rx.append("( Priority:"+(i)+" ("); 

                rx.append(aux.content.toString());

                if(aux.next == auxFinal) {
                	
                	rx.append(", ");
                	rx.append(aux.next.content.toString());
                }
                rx.append(")), ");
                aux = aux.next;
            
			}
		    separator=true;
			
			if (separator) 

            rx.delete(rx.length() - 2,rx.length());

            rx.append("]");

            return rx.toString();
			
			
		} else {
			return "[]";
		}
	}


  
}
