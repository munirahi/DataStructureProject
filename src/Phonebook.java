import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Phonebook {
    static Scanner input = new Scanner(System.in);
    static LinkedList<Contact> allContacts;
    static eventList<Event> allEvents;

    public static void main(String[] args) {
        allContacts = new LinkedList<Contact>();
        allEvents = new eventList<>();
        int ch = 0;
        boolean valid  ;
        do {
            valid =true ;
            System.out.println("\nWelcome to the Linked Tree Phonebook!");
            System.out.println("Please choose an option:");
            System.out.println("1.Add a contact");
            System.out.println("2.Search for a contact");
            System.out.println("3.Delete a contact");
            System.out.println("4.Schedule an event");
            System.out.println("5.Print event details");
            System.out.println("6.Print contacts by first name");
            System.out.println("7.Print all events alphabetically");
            System.out.println("8.Print all contacts in one event");
            System.out.println("9.Exit");
            while(valid) {
                try {
                    System.out.print("Enter your choice:");


                    ch = input.nextInt();
                    input.nextLine();
                    if(ch>=1 && ch<= 9)
                        valid = false ;
                }catch(InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input.nextLine();

                }}
            switch (ch) {

                case 1:
                    System.out.println("Enter the contact's name:");
                    String name = input.nextLine();

                    String phoneNum = "";
                    boolean flag = true;
                    while (flag) {
                        System.out.println("Enter the contact's phone number(must be 10 digits):");
                        phoneNum = input.nextLine();

                        if (phoneNum.length() == 10 && phoneNum.substring(0, 2).equals("05") && phoneNum.matches("[0-9]+"))

                            flag = false;

                        else
                            System.out.println("Invalid phone number. It must have 10 digits and start with '05'. Please try again.");

                    }


                    String email = "";
                    boolean isValid = true;

                    while (isValid) {
                        System.out.println("Enter the contact's email address:");
                        email = input.nextLine();

                        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))

                            isValid = false;

                        else {
                            System.out.println("Invalid email address. Please try again.");

                        }
                    }
                    System.out.println("Enter the contact's address:");
                    String address = input.nextLine();
                    System.out.println("Enter the contact's birthday:");
                    String birth = input.nextLine();
                    System.out.println("Enter any notes for the contact:");
                    String notes = input.nextLine();

                    Contact c = new Contact(name, phoneNum, email, address, birth, notes);

                    if (allContacts.insertSorted(c))
                        System.out.println("Contact added successfully!");
                    else
                        System.out.println("already exist");
                    break;

                case 2:
                    search();
                    break;
                case 3:
                    System.out.println("Enter the contact's name:");
                    Contact contactToDelet = allContacts.searchName(input.nextLine());
                    if (contactToDelet != null)
                        removeContact(contactToDelet);
                    else
                        System.out.println("contact not found in your phonebook ");

                    break;

                case 4:
                    System.out.println("Enter event title:");
                    String title = input.nextLine();
                    System.out.println("Enter contact name:");
                    String contactName = input.nextLine();

                    Contact con = allContacts.searchName(contactName);
                    if (con != null) {
                        Event e = allEvents.searchByTitle(title);
                        if (e == null) {
                            System.out.println("Enter event date and time (DD/MM/YYYY HH:MM):");
                            String date = input.nextLine();
                            System.out.println("Enter event location:");
                            String location = input.nextLine();
                            Event e1 = new Event(title, location, date);
                            scheduleEvent(con, e1);

                        } else
                            addContactToEvent(con, e);
                    } else
                        System.out.println("contact not found");

                    break;

                case 5:
                    int ch1= 0 ;
                    boolean choice = true ;
                    while(choice){
                        try {
                            System.out.println("Enter search criteria:");
                            System.out.println("1.contact name");
                            System.out.println("2.Event title");
                            ch1 = input.nextInt();
                            input.nextLine();


                            ch1 = input.nextInt();
                            input.nextLine();
                            if(ch1 == 1 || ch1 ==2)
                                choice = false ;
                        }catch(InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            input.nextLine();

                        }}
                    switch (ch1) {
                        case 1:
                            System.out.println("Enter the contact name:");
                            String name1 = input.nextLine();
                            Event e1 = allEvents.searchByContact(name1);
                            if (e1 != null) {
                                System.out.println("Event found!");
                                System.out.println(e1);
                            } else
                                System.out.println("Event not found");
                            break;
                        case 2:
                            System.out.println("Enter the event title:");
                            String title1 = input.nextLine();
                            Event e11 = allEvents.searchByTitle(title1);
                            if (e11 != null) {
                                System.out.println("Event found!");
                                System.out.println(e11);
                            } else
                                System.out.println("Event not found");
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Enter the first name:");
                    String name1 = input.next();
                    printSharedFirstName(name1);
                    break;

                case 7:
                    System.out.println(allEvents);
                    break;
                case 8:
                    System.out.println("Enter the event title:");
                    String title1 = input.next();
                    printSharedEvent(title1);
                    break;

            }}while (ch != 9);


    }



    public static <T> void printSharedFirstName(String name) {
        if (allContacts.empty())
            System.out.println("No contacts.");
        else {
            allContacts.findfirst();
            while (!allContacts.last()) {
                String Cname = allContacts.retrieve().getName();
                String[] fName = Cname.split(" ");
                if (fName.length > 0)
                    Cname = fName[0];
                if (Cname.equals(name)) {
                    System.out.println("Contact found!");
                    System.out.println(allContacts.retrieve());
                }
                allContacts.findnext();
            }
            String Cname = allContacts.retrieve().getName();
            String[] fName = Cname.split(" ");
            if (fName.length > 0)
                Cname = fName[0];
            if (Cname.equals(name)) {
                System.out.println("Contact found!");
                System.out.println(allContacts.retrieve());
            }
        }
    }


    public static <T> void printSharedEvent(String evenTitle) {
        if (allEvents.empty())
            System.out.println("No events.");
        else {
            allEvents.findfirst();
            while (!allEvents.last()) {
                if (allEvents.retrieve().getTitle().equals(evenTitle)) {
                    System.out.println(allEvents.retrieve());
                    return;
                }

                allEvents.findnext();
            }

            if (allEvents.retrieve().getTitle().equals(evenTitle)) {
                System.out.println(allEvents.retrieve());

            }
        }
    }

    public static <T> void search() {
        int ch =0 ;
        boolean notvalid = true ;
        while(notvalid) {
            try {

                System.out.println("Enter search criteria:");
                System.out.println("1.Name");
                System.out.println("2.Phone Number");
                System.out.println("3.Email");
                System.out.println("4.Address");
                System.out.println("5.Birthday");
                ch = input.nextInt();
                input.nextLine();
                if(ch>=1 && ch <=5)
                    notvalid = false ;
            }catch(InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine();

            }}
        switch (ch) {
            case 1:
                System.out.println("Enter the contact's name:");
                String name = input.nextLine();
                Contact c = allContacts.searchName(name);
                if (c != null) {
                    System.out.println("Contact found!");
                    System.out.println(c);
                } else
                    System.out.println("Contact not found!");
                break;

            case 2:
                System.out.println("Enter the contact's phoneNumber:");
                String phoneNum = input.nextLine();
                Contact c1 = allContacts.searchPhone(phoneNum);
                if (c1 != null) {
                    System.out.println("Contact found!");
                    System.out.println(c1);
                } else
                    System.out.println("Contact not found!");
                break;

            case 3:
                System.out.println("Enter the contact's Email:");
                String em = input.nextLine();
                LinkedList<Contact> emailList = allContacts.searchEmail(em);
                if (!emailList.empty()) {
                    System.out.println("Contact found!");
                    System.out.println(emailList);
                } else
                    System.out.println("Contact not found");

                break;

            case 4:
                System.out.println("Enter the contact's Address:");
                String address = input.nextLine();
                LinkedList<Contact> addressList = allContacts.searchAddress(address);
                if (!addressList.empty()) {
                    System.out.println("Contact found!");
                    System.out.println(addressList);
                } else
                    System.out.println("Contact not found");
                break;

            case 5:
                System.out.println("Enter the contact's Birthday:");
                String birth = input.nextLine();
                LinkedList<Contact> birthdayList = allContacts.searchBirthday(birth);
                if (!birthdayList.empty()) {
                    System.out.println("Contact found!");
                    System.out.println(birthdayList);
                } else
                    System.out.println("Contact not found");
                break;

        }

    }

    public static <T> void scheduleEvent(Contact c, Event e) {

        if (!checkConflict(allEvents, e.getDate())) {
            allEvents.addEventSorted(e);
            c.listOfevent.addEventSorted(e);
            e.getContactsInThisEvent().insertSorted(c);
            System.out.println("Event scheduled.");
        } else
            System.out.println("Event caan't be scheduled there is a conflict.");

    }

    public static <T> void addContactToEvent(Contact c, Event e) {

        if (!checkConflict(c.listOfevent, e.getDate())) {
            c.listOfevent.addEventSorted(e);
            allEvents.searchByTitle(e.getTitle()).getContactsInThisEvent().insertSorted(c);
            System.out.println(c.getName() + " is added to the Event "+e.getTitle()+" successfully ");
        } else

            System.out.println("There is a conflict in your schedule.");

    }

    public static <T> boolean checkConflict(eventList<Event> eList, Date date) {
        if (eList.empty())
            return false;

        eList.findfirst();
        while (!eList.last()) {
            if (eList.retrieve().getDate().equals(date))
                return true;
            eList.findnext();

        }
        if (eList.retrieve().getDate().equals(date))
            return true;

        return false;
    }

    public static <T> void removeContact(Contact c) {

        if (allContacts.empty())  {
            System.out.println("no contacts in the phonebook");
            return;
        }
        allContacts.findfirst();
        while (!allContacts.last()) {
            if (allContacts.retrieve().equals(c)) {
                allContacts.remove();
                break;
            }
            allContacts.findnext();
        }
        if (allContacts.retrieve().equals(c))
            allContacts.remove();

        if(!allEvents.empty()) {


            allEvents.findfirst();
            while (!allEvents.last()) {
                if (allEvents.retrieve().getContactsInThisEvent().searchName(c.getName()) != null) {
                    allEvents.retrieve().removeContactInThisEvent(c);
                    if (allEvents.retrieve().getContactsInThisEvent().empty())
                        allEvents.remove();
                } else
                    allEvents.findnext();
            }
            if (allEvents.retrieve().getContactsInThisEvent().searchName(c.getName()) != null)
                allEvents.retrieve().removeContactInThisEvent(c);
            if (allEvents.retrieve().getContactsInThisEvent().empty())
                allEvents.remove();
        }// end of if
        System.out.println("Contact is deleted.");

    }

}





