import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Event implements Comparable<Event> {
    static Scanner input = new Scanner(System.in);

    private String title;
    private String location;
    private Date Date;
    private enumEvent type ;
    private BST<Contact> contactsInThisEvent;

    public Event(String title, String location, String dateAndtime , int t) {
        this.title = title;
        this.location = location;
        contactsInThisEvent = new BST<Contact>();
         if(t == 1)
             type = enumEvent.APPOINTMENT ;
         else if (t == 2) {
             type = enumEvent.EVENT;
         }


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        this.title = title;
        this.location = location;
        boolean check = true;

        while (check) {
            try {
                dateFormat.setLenient(false);
                Date = dateFormat.parse(dateAndtime);
                check = false;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("please Enter the right format dd/MM/yyyy HH:mm");
                dateAndtime = input.nextLine();
            }

        }
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return Date;
    }

    public BST<Contact> getContactsInThisEvent() {
        return contactsInThisEvent;
    }

    public int compareTo(Event e) {
        // TODO Auto-generated method stub
        return title.compareTo(e.title);
    }

    @Override
    public String toString() {
        return type +" title:" + title + "\nlocation:" + location + "\nDate:" + Date + "\nContacts:\n"
                + contactsInThisEvent.contactsName();

    }


//update
    public void removeContactInThisEvent(Contact c) {
    	if(contactsInThisEvent.findKey(c.getName()))
    		contactsInThisEvent.removeKey(c.getName());
    }
   

}

