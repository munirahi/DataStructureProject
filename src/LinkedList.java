public class LinkedList<T> {

    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
    }

    public boolean full() {
        return false;
    }

    public void findfirst() {
        current = head;
    }

    public void findnext() {
        current = current.next;
    }

    public T retrieve() {
        return current.data;
    }

    public void update(T val) {
        current.data = val;
    }

    public boolean insertSorted(T c) {

        Node<T> p = new Node<T>(c);

        if (isUnique(c)) {

            if (head == null) {
                head = current = p;
                return true;
            }

            if ((((Contact) c).getName()).compareTo(((Contact) head.data).getName()) < 0) {
                p.next = head;
                head = p;
                return true;
            }

            Node<T> temp = head;
            Node<T> q = null;

            while (temp != null && (((Contact) temp.data).getName()).compareTo(((Contact) c).getName()) < 0) {
                q = temp;
                temp = temp.next;

            }

            q.next = p;
            p.next = temp;
            return true;
        }
        return false;

    }

    public boolean isUnique(T c) {
        if (head == null)
            return true;

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getName()).equals(((Contact) c).getName())
                    || (((Contact) temp.data).getPhonenumber()).equals(((Contact) c).getPhonenumber()))
                return false;
            temp = temp.next;
        }

        return true;

    }

    public void remove() {

        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current)
                tmp = tmp.next;

            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;

    }

    public LinkedList<T> searchEmail(String e) {

        LinkedList<T> eList = new LinkedList<T>();

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getEmail()).equals(e)) {
                eList.insertSorted(temp.data);
            }
            temp = temp.next;

        }
        return eList;

    }

    public LinkedList<T> searchAddress(String a) {
        LinkedList<T> aList = new LinkedList<T>();

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getAddress()).equals(a)) {
                aList.insertSorted(temp.data);
            }
            temp = temp.next;
        }

        return aList;

    }

    public LinkedList<T> searchBirthday(String b) {
        LinkedList<T> bList = new LinkedList<T>();

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getBirthday()).equals(b)) {
                bList.insertSorted(temp.data);
            }
            temp = temp.next;
        }

        return bList;
    }

    public Contact searchName(String n) {

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getName()).equals(n))
                return (Contact) temp.data;
            temp = temp.next;
        }
        return null;
    }

    public Contact searchPhone(String num) {

        Node<T> temp = head;
        while (temp != null) {
            if ((((Contact) temp.data).getPhonenumber()).equals(num))
                return (Contact) temp.data;

            temp = temp.next;

        }
        return null;
    }


    public String contactsName() {
        Node<T> temp = head;
        String s = "";
        while (temp != null) {
            s += ((Contact) temp.data).getName() + "\n";
            temp = temp.next;
        }
        return s;

    }

    public String toString() {
        Node<T> temp = head;
        String s = "";
        while (temp != null) {
            s += temp.data.toString();
            temp = temp.next;
        }
        return s;

    }

}
