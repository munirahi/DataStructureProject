
public class eventList<T> {

    private Node<T> head;
    private Node<T> current;

    public eventList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
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

    public void addEventSorted(T e) {

        Node<T> p = new Node<T>(e);

        if (head == null) {
            head = current = p;
            return;
        }

        if ((((Event) e).getTitle()).compareTo(((Event) head.data).getTitle()) < 0) {
            p.next = head;
            head = p;
            return;
        }

        Node<T> temp = head;
        Node<T> q = null;

        while (temp != null && (((Event) temp.data).getTitle()).compareTo(((Event) e).getTitle()) < 0) {

            q = temp;
            temp = temp.next;

        }if(temp != null){
        if((((Event) temp.data).getTitle()).compareToIgnoreCase(((Event) e).getTitle()) == 0){
            temp.next = p;
            p.next =q;
            return;
        }}

        q.next = p;
        p.next = temp;
        return;

    }



    public Event searchByTitle(String t) {

        Node<T> temp = head;
        while (temp != null) {
            if ((((Event) temp.data).getTitle()).equalsIgnoreCase(t))
                return (Event) temp.data;
            temp = temp.next;

        }

        return null;
    }



    public String toString() {
        Node<T> temp = head;

        String s = "";

        while (temp != null) {
            s += temp.data.toString() + "\n";
            temp = temp.next;
        }
        return s;

    }

}
