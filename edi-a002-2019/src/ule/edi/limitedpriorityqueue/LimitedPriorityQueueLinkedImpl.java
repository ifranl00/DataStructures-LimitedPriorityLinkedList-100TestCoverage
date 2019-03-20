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
			
			
				while(aux.next.next != null) { //mientras que el auxiliar no quede apuntando al penultimo elemento
				
					aux = aux.next; //sigue avanzando
				
				}
				e = aux.next.content;
				aux.next = null; //hacemos que sea el ultimo
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
    		n.next = null;
    		
    		
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
	public T enqueue(int p, T element) {
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
					try {
					deleted = dequeueLast();
					count --;
					}catch(Exception EmptyCollectionException) {
						
					}
					
					
				}else {
				
					//anyadimos el nodo
					enqueueNotFirst(p, element);
					//borramos el ultimo
					try {
					deleted = dequeueLast();
					count --;
					}catch(Exception EmptyCollectionException) {
						
					}
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
			QueueNode <T >aux0 = first; // para guardar el primero
			QueueNode <T >aux1 = first; // para guardar el anterior
			QueueNode <T >aux2 = first.next; //para pasar por todos excepto el primero
			int firstPrinted = 0;
			rx.append("[");
		      // TODO : MOSTRAR LOS ELEMENTOS DE LA COLA DE PRIORIDAD CON EL MISMO FORMATO QUE LA OTRA IMPLEMENTACIÓN
			
			while(aux1 != null && aux2 != null) {
				
				if(aux0 != null && firstPrinted == 0){  //tratamos el primero a parte
					
					rx.append("( Priority:"+(aux0.priority)+" (");
					rx.append(aux0.content.toString());
					firstPrinted = 1; //indicamos que ya se ha impreso el primero
					
				}
				if(firstPrinted == 1) { //si ya se ha impreso el primer elemento
					
					
					if(aux1.priority != aux2.priority) { //si las prioridades son distintas
						
						rx.append(")), ");
						rx.append("( Priority:"+(aux2.priority)+" (");
						rx.append(aux2.content.toString());
						
					}else { //si es de la misma prioridad
					
						rx.append(", ");
						rx.append(aux2.content.toString());
						
						}	
					
					}
				
				if(aux2.next == null) {
					rx.append(")), ");
				}
				//avanzamos
					aux1 = aux1.next;
					aux2 = aux2.next;
				}
				
            
				separator=true;
			
				if (separator) {

					rx.delete(rx.length() - 2,rx.length());

					rx.append("]");
		
					return rx.toString();
				}
			
			
			}
		
	
		return "[]";
	}
}

