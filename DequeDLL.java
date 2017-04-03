public class DequeDLL<T> implements Deque<T>{
    private DLLNode<T> _first;
    private DLLNode<T> _last;
    private int _size;

    //constructor
    public DequeDLL(){
	_first= new DLLNode<T>(null,null,null);
	_last=_first;
	_size=0;
    }

    public void addFirst( T enQVal ) {
	DLLNode<T> adding=new DLLNode<T>(enQVal,null,null);
	if(isEmpty()){
	    _last= adding;
	    _first=_last;
	}
	else{
	    adding.setNext(_first);
	    _first.setPrev(adding);
	    _first=adding;
	}
	_size++;
    }//ending enqueueFirst()
    //O(1)
    
    
    public void addLast( T enQVal ){
	DLLNode<T> adding=new DLLNode<T>(enQVal,null,null);
	if(isEmpty()){
	    _last= adding;
	    _first=_last;
	}
	else{
	    adding.setPrev(_last);
	    _last.setNext(adding);
	    _last=_last.getNext();
	}
	_size++;
    }//ending enqueueLast()
    //O(1)

    public T removeFirst(){
	DLLNode<T> ret=_first;
	_first= _first.getNext();
	_first.setPrev(null);
	_size--;
	return ret.getCargo();
    }//ending removeFirst()
    //O(1)

    public T removeLast() {
	DLLNode<T> ret=_last;
	_last=_last.getPrev();
	_last.setNext(null);
	_size--;
	return ret.getCargo();
    }//ending removeLast()
    //O(1)

    public T peekFirst(){
	return _first.getCargo();
    }//ending peekFirst()
    //O(1)

    public T peekLast() {
	return _last.getCargo();
    }//ending peekLast()
    //O(1)

    public boolean isEmpty(){
	return _size==0;
    }//ending isEmpty()
    //O(1)

    public String toString(){
	String ans="";
	DLLNode<T> p=_first;
	while(p!=null){
	    ans+= p.getCargo()+" ";
	    p=p.getNext();
	}
	return ans;
    }//ending toString()
    //O(n)

    public static void main(String[] args){
	DequeDLL<String> tester= new DequeDLL<String>();
	tester.addFirst("a");
	tester.addFirst("b");
	tester.addFirst("c");
	tester.addLast("l1");
	tester.addLast("l2");
	tester.addLast("l3");

	System.out.println("testing toString() now");
	System.out.println(tester);
	System.out.println("testing removeLast() now");
	System.out.println(tester.removeLast());
	System.out.println("testing toString() now");
	System.out.println(tester);
	System.out.println("testing removeFirst() now");
	System.out.println(tester.removeFirst());

	System.out.println("testing peekFirst() now");

	System.out.println(tester.peekFirst());
	System.out.println("testing peekLast() now");
	System.out.println(tester.peekLast());
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
    }//ending main
}