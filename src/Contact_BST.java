public class Contact_BST {
    BSTNode root, current;

    public Contact_BST() {
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


       public boolean remove_key(String tkey) {
        BooleanWrapper removed = new BooleanWrapper(false);
        BSTNode p;
        p = remove_Key(tkey, root, removed);
        current = root = p;
        return removed.get();
    }

    private BSTNode remove_Key(String key, BSTNode p, BooleanWrapper flag) {
        BSTNode q, child = null;
        if (p == null) {
            return null;
        }
        if (key.compareTo(p.key) < 0) {
            p.left = remove_Key(key, p.left, flag);
        } else if (key.compareTo(p.key) > 0) {
            p.right = remove_Key(key, p.right, flag);
        } else {
            flag.set(true);
            if (p.left != null && p.right != null) {

                q = find_min(p.right);
                p.key = q.key;
                p.data = q.data;
                p.right = remove_Key(q.key, p.right, flag);
            } else {
                if (p.right == null) {
                    child = p.left;
                } else if (p.left == null) {
                    child = p.right;
                }
                return child;
            }
        }
        return p;
    }

    private BSTNode find_min(BSTNode p) {
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

      public boolean FindContact(String key){
          return searchName(root, key) ;
      }
    public Contact searchName(String n) {
        if (searchName(root, n))
            return current.data;
        else return null;
    }
    private boolean searchName(BSTNode temp, String n) {
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
    public Contact_BST searchAddress(String a) {
        Contact_BST address = new Contact_BST();
        address = searchAddress(root, a, address);
        return address;
    }
    private Contact_BST searchAddress(BSTNode r, String s, Contact_BST adList) {
        if (r != null) {
            if (r.data.getAddress().equalsIgnoreCase(s))
                adList.insert(r.key,r.data);
            searchAddress(r.left, s, adList);
            searchAddress(r.right, s, adList);
        }
        return adList;
    }
    public Contact searchPhone(String num) {
        BooleanWrapper found = new BooleanWrapper(false);
        BSTNode contact = searchPhone(root, num , found);
        if (found.get())
            return contact.data;
        return null;
    }

    private BSTNode searchPhone(BSTNode r, String num, BooleanWrapper find) {
        if (r != null) {
            searchPhone(r.left, num,find);
            if (r.data.getPhonenumber().equals(num)) {
                current = r;
                find.set(true);
                return current ;
            }
            searchPhone(r.right, num,find);
        }
        return current ;
    }
    public Contact_BST searchEmail(String e){
        Contact_BST emails = new Contact_BST();
        return searchEmail(root , e,emails);
    }
    private Contact_BST searchEmail(BSTNode r,String e , Contact_BST emails)
    {
        if (r != null) {
            if (r.data.getEmail().equalsIgnoreCase(e))
                emails.insert(r.key,r.data);
            searchEmail(r.left, e, emails);
            searchEmail(r.right, e, emails);
        }
        return emails;
    }
    public Contact_BST searchBirthday(String b){
        Contact_BST BDs = new Contact_BST();
        return searchBirthday(root , b , BDs);
    }
    private Contact_BST searchBirthday(BSTNode r ,String b , Contact_BST BDs){
        if (r != null) {
            if (r.data.getBirthday().equalsIgnoreCase(b))
                BDs.insert(r.key,r.data);
            searchBirthday(r.left, b, BDs);
            searchBirthday(r.right, b, BDs);
        }return BDs ;
    }


    public String contactsNames() {
        String s="";
         s = contactsNames(root, s);
        return s;
    }

    private String contactsNames(BSTNode ro, String s){
        if(ro != null) {
            s =  contactsNames(ro.left, s);
            s = s + ro.key + "\n";
            s = contactsNames(ro.right, s);
        } return s;
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

    // A method that adds a whole tree to another one
    public void insertAll(Contact_BST contacts,Event event){
        if(contacts.root != null){
            insertAll(contacts.root,event);
        }
    }
    private void insertAll(BSTNode root,Event event){
        if(root != null){
            insertAll(root.left,event);
            insert(root.key, root.data);
            root.data.listOfevent.addEventSorted(event);
            insertAll(root.right,event);
        }
    }


    
private BSTNode insert(BSTNode current, String key, Contact data) {
    if (current == null) {
        return new BSTNode(key, data);
    }

    if (key.compareTo(current.key) < 0) {
        current.left = insert(current.left, key, data);
    } else if (key.compareTo(current.key) > 0) {
        current.right = insert(current.right, key, data);
    }

   
    return current;
}


public boolean insert(String key, Contact data) {
    if (FindContact(key) || searchPhone(data.getPhonenumber()) != null) {
        return false;
    }

    root = insert(root, key, data);
    return true;
}


    //check for phonenum and
   /* public boolean unique(String phoneNumber) {
        return unique(root, phoneNumber);
    }

    private boolean unique(BSTNode node, String phoneNumber) {
        if (node == null) {
            return false;
        }
        if (unique(node.left, phoneNumber)) {
            return true;
        }
        if (node.data.getPhonenumber().equals(phoneNumber)) {
            return true;
        }
        return unique(node.right, phoneNumber);
    }*/
}



