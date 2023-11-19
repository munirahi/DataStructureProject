public class BSTNode {
  public Contact data ;
  public String key ;
    public BSTNode left , right ;
    public  BSTNode(String k , Contact val){
        key = k;
        data = val;
        left = right = null ;
    }
    public  BSTNode(String k , Contact val ,BSTNode l , BSTNode r ){
        key = k;
        data = val;
        left = l;
        right = r ;
    }
}
