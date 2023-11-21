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




}
