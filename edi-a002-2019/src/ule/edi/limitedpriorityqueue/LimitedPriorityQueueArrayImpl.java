package ule.edi.limitedpriorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class LimitedPriorityQueueArrayImpl<T> implements LimitedPriorityQueue<T> {
	    private int capacity;
	    private int npriorities;
	    private int count;

	    private ArrayList<LinkedQueue<T>> colas;
	

	public LimitedPriorityQueueArrayImpl(int capacity, int npriorities) {
		
      
		 // Si capacidad <=0 disparar la excepción: IllegalArgumentException
		if(capacity <= 0) {
			
			throw new IllegalArgumentException();
			
		}else {
			// Crear el arrayList, 
			colas = new ArrayList<LinkedQueue<T>>();
			
			//TODO  asignar los valores de los atributos
			count = 0;
			this.capacity = capacity;
			this.npriorities = npriorities;
			
			//y añadir una cola por cada una de las prioridades (1..npriorities)
			for(int i = 0; i < npriorities; i++) {
				
				colas.add(new LinkedQueue<T>());
			}
		}
		
		
	}
	
    @Override
    public int getCapacity() {
		return capacity;
    	
    }

    @Override
    public int getSize() {
    	return count;
    }

    @Override
    public boolean isFull() {
    	// TODO Auto-generated method stub
    	boolean isFull = false;
    	
    	if(getSize() == getCapacity()){
    		
    		isFull = true;
    	}
        return isFull;
    }

	@Override
	public T enqueue(int p, T element){
		// TODO Auto-generated method stub
		
		
		T e = null;
		if( (p > 0) && (p <= npriorities) ) {
			
			if(element != null) {
				
				if(isFull() == true) {
					
					colas.get(p-1).enqueue(element); //insertamos el elemento segun su prioridad
					count ++;
					for(int i = npriorities -1 ; i >= 0; i--) {
						
						if(colas.get(i).isEmpty() == false){
							
							try {
							e = colas.get(i).dequeueLast();
							count --;
							return e;
							}catch(Exception EmptyCollectionException) {
								
							}
						}
					}
				} //si no esta llena
				colas.get(p-1).enqueue(element);
				count ++;
			}else {
				
				throw new NullPointerException();
			}
				
		}else {
			
			throw new IllegalArgumentException();
		}
		return e;
	}


	@Override
	public T first() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		T e = null;
		
		boolean done = false;
				
		if(isEmpty() == false) {
			
			for(int i = 0; i < npriorities ; i++) {
				if(done != true) {
					if(colas.get(i).isEmpty() == false){
						e = colas.get(i).first();
						done = true;
					}
				}
			}
			
		}else {
			
			throw new EmptyCollectionException("LimitedPriorityQueueArray");
		}
		return e;
      
	}



	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		
		T e = null;
		if(isEmpty() == true) {
			
			throw new EmptyCollectionException("LimitedPriorityQueueArray");
			
		}else {
		
			for(int i = 0; i < npriorities-1 ; i++) {
			
				if(colas.get(i).isEmpty() == false) {
				
					e = colas.get(i).dequeue();
				}
			}
		}
		return e;
	}

	@Override
	public boolean isEmpty() {
		
		return count == 0;
	}

	
	@Override

	public String toString() {

		boolean separator=false;

	            if (! this.isEmpty()) {

	                              StringBuffer rx = new StringBuffer();

	                              rx.append("[");

	                              for (int n = 0; n < this.npriorities; ++n) {

	                              if (!colas.get(n).isEmpty()){

	                                           rx.append("( Priority:"+(n+1)+" ("); 

	                                           rx.append(colas.get(n).toString());

	                                           rx.append(")), ");

	                                           separator=true;

	                                        }       

	                                 }

	                              if (separator) 

	                                    rx.delete(rx.length() - 2,rx.length());

	                                   rx.append("]");

	                                   return rx.toString();

	                              } else {

	                                    return "[]";

	                                }

	                           }

};
  

