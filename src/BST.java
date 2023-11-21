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
    public Contact searchName(String n) {

        BSTNode temp = root ;
        while (temp != null) {
            if (( temp.data.getName()).equals(n))  // we can also use the key
                return  temp.data;
            else if (temp.key.compareTo(n) < 0)//
                temp = temp.right;
            else if (temp.key.compareTo(n) > 0)//
                temp = temp.left;

        }
        return null;
    }
    public String contactsName(){
        String s ="";


        return s ;
    }



}
