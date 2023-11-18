import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Event implements Comparable<Event> {
    static Scanner input = new Scanner(System.in);

    private String title;
    private String location;
    private Date Date;
    private LinkedList<Contact> contactsInThisEvent;

    public Event(String title, String location, String dateAndtime) {
        this.title = title;
        this.location = location;
        contactsInThisEvent = new LinkedList<Contact>();

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

    public LinkedList<Contact> getContactsInThisEvent() {
        return contactsInThisEvent;
    }

    public int compareTo(Event e) {
        // TODO Auto-generated method stub
        return title.compareTo(e.title);
    }

    @Override
    public String toString() {
        return "Event title:" + title + "\nlocation:" + location + "\nDate:" + Date + "\nContacts:\n"
                + contactsInThisEvent.contactsName();

    }


    public void removeContactInThisEvent(Contact c) {
        if (contactsInThisEvent.empty())
            return;
        contactsInThisEvent.findfirst();
        while (!contactsInThisEvent.last()) {
            if (contactsInThisEvent.retrieve().equals(c)) {
                contactsInThisEvent.remove();
                return;
            }
            contactsInThisEvent.findnext();
        }
        if (contactsInThisEvent.retrieve().equals(c))
            contactsInThisEvent.remove();
    }//

}

