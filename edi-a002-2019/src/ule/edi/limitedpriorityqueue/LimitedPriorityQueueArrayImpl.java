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
	public T enqueue(int p, T element) throws EmptyCollectionException{
		// TODO Auto-generated method stub
		
		
		T e = null;
		if( (p > 0) && (p <= npriorities) ) {
			
			if(element != null) {
				
				if(isFull() == true) {
					
					e = element;
					colas.get(p-1).enqueue(element); //insertamos el elemento segun su prioridad
					count ++;
					for(int i = npriorities -1 ; i >= 0; i--) {
						
						if(colas.get(i).isEmpty() == false){
							
							colas.get(i).dequeueLast();
							count --;
						}
					}
				} //si no esta llena
				colas.get(p-1).enqueue(element);
				count ++;
				
				//si se ha llegado al maximo la primera cola por abajo no vacia y llamar a desencolar el ultimo de esa cola (colas.get(x).dequeuelast() donde x es ese que calculamos );
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
		
		if(isEmpty() == false) {
			
			e = colas.get(0).first();
			
		}else {
			
			
		}
		return e;
      
	}



	@Override
	public T dequeue() throws EmptyCollectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		
		boolean isEmpty = false;
		if(getSize() == 0) {
			
			isEmpty = true;
		}
		return isEmpty; 
	}

	
	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			rx.append("[");
			for (int n = 0; n < this.npriorities; ++n) {
				rx.append("( Priority:"+(n+1)+" (");
				rx.append(colas.get(n).toString());
				rx.append(")), ");
			}
			rx.delete(rx.length() - 2, rx.length());
			rx.append("]");
			return rx.toString();
		} else {
			return "[]";
		}
	}

};
  

