public class BST<T>{
    BSTNode root ,current ;

    public BST(){
        root = current = null ;
    }

    public boolean empty() {

        return root == null;
    }

    public boolean full() {
        return false;
    }
    public Contact retrieve() {
        return current.data;
    }
        //NEW
    public void clear() {
    	current=root=null;
    }
    //NEW
    public boolean findKey(String k) {
    	BSTNode p=root;
    	while(p !=null ) {
    		current=p;
    		if(k.compareToIgnoreCase(p.key)==0){
    			return true;
    		}else if(k.compareToIgnoreCase(p.key)<0) {
    			p=p.left;
    		}else {
    			p=p.right;
    		}
    	}
    	return false;
    }
    
    
    public boolean removeKey(String k) {
  
    
    	String k1 = k;
    	BSTNode p = root;
    	BSTNode q = null; 
    	while (p != null) {
    
    	if (k1.compareTo(p.key) < 0) { //ignorecase ??
    	 q=p;
    	p = p.left;
    	} else if (k1.compareTo(p.key)>0) {
    	q = p;
    	p = p.right;
    	}
    	else {
    		    if(p.left!=null && p.right !=null) { //case3 if there is 2 children
    		    	BSTNode min =p.right ;
    		    	q=p;
    		    	while(min.left !=null) {
    		    		q=min;
    		    		min=min.left;
    		    	}
    		    	p.key=min.key;
    		    	p.data=min.data;
    		    	k1=min.key;
    		    	p=min;
    		    }
    		    
    		    if(p.left !=null) {
    		    	p=p.left;
    		    }else {
    		    	p=p.right;
    		    }
    		    
    		  if(q==null) {
    			  root=p;
    		  }else {
    			  if(k1.compareTo(q.key)<0) {
    				  q.left=p;
    			  }else {
    				  q.right=p;
    			  }
    		  }
    		  current=root;
    		  return true;
    		    	
    	}
    	}
    	return false;
    }
  /*  public boolean FindContact(String key){


        return false ;
    }*/
  public Contact searchName(String n){
     if( searchName(root , n))
      return current.data  ;
      else return null ;
  }


    public boolean searchName(BSTNode temp,String n) {
        if(temp == null)
        return false;
        if (( temp.data.getName()).equals(n)) {
            current = temp;
            return  true;}
        else if (temp.key.compareTo(n) < 0)//
            return searchName(temp.right ,n );
        else
            return searchName(temp.left ,n );
  }




    public BST searchAddress(String a) {
        BST address = new BST();

        return address;
    }
    private BST searchAddress(BSTNode r , String s){

    }


    public Contact searchPhone(String num) {
       if(searchPhone(root ,num))
           return current.data;
        return null ;
    }
    private boolean searchPhone(BSTNode r ,String num){
    if(r != null ){
        if(r.data.getPhonenumber().equals(num)){
            current = r;
            return true;}
        searchPhone(r.left , num );
        searchPhone(r.right , num );}
    return false ;
    }


    public String contactsName(){
        String s ="";


        return s ;
    }
private BSTNode findFirst(){
    BSTNode   t = root;
    while (t.left != null)
        t= t.left ;
        return t;
}

//new
    public String toString()
    {
        return toString (root);
    }
    private String toString(BSTNode p)
    {
        if (p == null)
            return "";
        toString(p.left);
        toString(p.right);
        return p.data.toString();
    }
}


}
