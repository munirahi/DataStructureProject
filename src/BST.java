public class BST<T> {
    BSTNode root, current;

    public BST() {
        root = current = null;
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
        current = root = null;
    }

    //NEW
    public boolean findKey(String k) {
        BSTNode p = root;
        while (p != null) {
            current = p;
            if (k.compareToIgnoreCase(p.key) == 0) {
                return true;
            } else if (k.compareToIgnoreCase(p.key) < 0) {
                p = p.left;
            } else {
                p = p.right;
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
                q = p;
                p = p.left;
            } else if (k1.compareTo(p.key) > 0) {
                q = p;
                p = p.right;
            } else {
                if (p.left != null && p.right != null) { //case3 if there is 2 children
                    BSTNode min = p.right;
                    q = p;
                    while (min.left != null) {
                        q = min;
                        min = min.left;
                    }
                    p.key = min.key;
                    p.data = min.data;
                    k1 = min.key;
                    p = min;
                }

                if (p.left != null) {
                    p = p.left;
                } else {
                    p = p.right;
                }

                if (q == null) {
                    root = p;
                } else {
                    if (k1.compareTo(q.key) < 0) {
                        q.left = p;
                    } else {
                        q.right = p;
                    }
                }
                current = root;
                return true;

            }
        }
        return false;
    }

      public boolean FindContact(String key){
          return searchName(root, key) ;
      }
    public Contact searchName(String n) {
        if (searchName(root, n))
            return current.data;
        else return null;
    }

    public boolean searchName(BSTNode temp, String n) {
        if (temp == null)
            return false;
        if ((temp.data.getName()).equals(n)) {
            current = temp;
            return true;
        } else if (temp.key.compareTo(n) < 0)//
            return searchName(temp.right, n);
        else
            return searchName(temp.left, n);
    }


    public BST searchAddress(String a) {
        BST address = new BST();
        address = searchAddress(root, a, address);
        return address;
    }

    private BST searchAddress(BSTNode r, String s, BST adList) {
        if (r != null) {
            if (r.data.getAddress().equalsIgnoreCase(s))
                adList.insert(r.key,r.data);
            searchAddress(r.left, s, adList);
            searchAddress(r.right, s, adList);
        }
        return adList;
    }


    public Contact searchPhone(String num) {
        if (searchPhone(root, num))
            return current.data;
        return null;
    }

    private boolean searchPhone(BSTNode r, String num) {
        if (r != null) {
            if (r.data.getPhonenumber().equals(num)) {
                current = r;
                return true;
            }
            searchPhone(r.left, num);
            searchPhone(r.right, num);
        }
        return false;
    }

    public BST searchEmail(String e){
        BST emails = new BST();
        return searchEmail(root , e,emails);
    }
    private BST searchEmail(BSTNode r,String e , BST emails)
    {
        if (r != null) {
            if (r.data.getEmail().equalsIgnoreCase(e))
                emails.insert(r.key,r.data);
            searchEmail(r.left, e, emails);
            searchEmail(r.right, e, emails);
        }
        return emails;
    }
    public BST searchBirthday(String b){
        BST BDs = new BST();
        return searchBirthday(root , b , BDs);
    }
    private BST searchBirthday(BSTNode r ,String b , BST BDs){
        if (r != null) {
            if (r.data.getBirthday().equalsIgnoreCase(b))
                BDs.insert(r.key,r.data);
            searchBirthday(r.left, b, BDs);
            searchBirthday(r.right, b, BDs);
        }return BDs ;
    }


    public String contactsName() {
        String s = "";
        return s;
    }

    private BSTNode findFirst() {
        BSTNode t = root;
        while (t.left != null)
            t = t.left;
        return t;
    }

    //new
      public void print()
    {
         print(root);
    }
    private void print(BSTNode p)
    {
        if (p == null)
            return ;
        print(p.left);
        System.out.print(p.data);
        print(p.right);
       
    }
    

    // new
    public boolean FindKey(String Key) //اقارن الاسم
    { BSTNode a = root;
        while (a != null) {
            current = a;
            if (Key.compareToIgnoreCase(a.key) == 0) // نفسه
                return true;
            else if (Key.compareToIgnoreCase(a.key) < 0) // الاول اقل من الثاني
                a = a.left;
            else if (Key.compareToIgnoreCase(a.key) > 0) {
                a = a.right;
            }
        }
        return false;
    }

   public boolean insert(String Key, Contact data) {
    	if(!unique(data)) {
            if (root == null) {
            current = root = new BSTNode(Key, data);
            return true;
                   }
            BSTNode p=root;
            BSTNode q=root;
            
            while(p!=null){
                q=p;
                if(p.key.equals(Key))
                    return false;
                else if(Key.compareTo(p.key)>0)
                    p=p.right;
                else
                    p=p.left;
                   
            }
            if(Key.compareTo(q.key)>0){
            q.right=new BSTNode(Key,data);
            current=q.right;
            }
            else{
              q.left=new BSTNode(Key,data);
            current=q.left;   
            }
            return true;
        }
        return false;
    }
    //check for phonenum and name
    public boolean unique(Contact c) {
    	if(root==null)
    		return false;
    	return unique(root,c);
    }
    
    private boolean unique(BSTNode p ,Contact c) {
    	if(p==null)
    		return false;
    	
    	boolean found=unique(p.left,c);
    	
    	if(found)
    		return true;
    	if(p.data.getName().equals(c.getName()) || p.data.getPhonenumber().equals(c.getPhonenumber()))
    		return true;
    	
    	return unique(p.right,c);
    	
    }
}



