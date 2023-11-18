public class BSTNode<T> {
  public T data ;
  public String key ;
    public BSTNode<T> left , right ;
    public  BSTNode(String k , T val){
        key = k;
        data = val;
        left = right = null ;
    }
    public  BSTNode(String k , T val ,BSTNode<T> l , BSTNode<T> r ){
        key = k;
        data = val;
        left = l;
        right = r ;
    }
}
