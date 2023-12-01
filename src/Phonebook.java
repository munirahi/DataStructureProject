import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Phonebook {
    static Scanner input = new Scanner(System.in);
    static Contact_BST allContacts;
    static eventList<Event> allEvents;

    public static void main(String[] args) {
        allContacts = new Contact_BST();
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
                        System.out.println("Enter the contact's phone number (must be 10 digits):");
                        phoneNum = input.nextLine();

                        if (phoneNum.length() == 10 && phoneNum.substring(0, 2).equals("05") && phoneNum.matches("[0-9]+")) {
                            if (allContacts.unique(phoneNum)) {
                                System.out.println("This phone number already exists. Please enter a different number.");
                            } else {
                                flag = false;
                            }
                        } else {
                            System.out.println("Invalid phone number. It must have 10 digits and start with '05'. Please try again.");
                        }
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

                    if (allContacts.insert(c.getName(), c))
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
                     System.out.println("Enter type:");
                     System.out.println("1. event");
                     System.out.println("2. appointment");
                     int type = input.nextInt();
                     input.nextLine();
                     Contact con;
                 if(type==1) {
                     
                   System.out.println("Enter event title:");
                    String title = input.nextLine();
                    System.out.println("Enter contacts names and separate them with , :");
                    String contactName = input.nextLine();
                    System.out.println("Enter event date and time (DD/MM/YYYY HH:MM):");
                    String date = input.nextLine();
                    System.out.println("Enter event location:");
                    String location = input.nextLine();
                    
                    Event event = new Event(title, location, date,1); 
                    
                        String[] names = contactName.split(",");
                       BST ContactsInEvent = new BST();
                         for (int i = 0; i < names.length; i++) {
                            con = allContacts.searchName(names[i]);
                            if( con != null){
                                ContactsInEvent.insert(con.getName(),con);}else {
                                System.out.println("contact " + names[i] + " is not found ");
                             }
                        }
                         scheduleEvent(ContactsInEvent,event);    
                  
                 }
                 else if(type==2){
                     System.out.println("Enter event title:");
                    String title = input.nextLine();
                    System.out.println("Enter contact name:");
                    String contactName = input.nextLine();
                    System.out.println("Enter event date and time (DD/MM/YYYY HH:MM):");
                    String date = input.nextLine();
                    System.out.println("Enter event location:");
                    String location = input.nextLine();
                    
                    Event appointment = new Event(title, location, date, 2);
                    
                       con = allContacts.searchName(contactName);
                        if (con != null) {
                            scheduleAppointment(con, appointment);
                        } else
                        System.out.println("contact not found");
                    
                 }
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
                        }catch(InputMismatchException exception) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            input.nextLine();

                        }}
                    switch (ch1) {
                        case 1:
                            System.out.println("Enter the contact name:");
                            String name1 = input.nextLine();
                            Contact contact = allContacts.searchName(name1) ;
                            if( contact != null){
                                contact.printAllEvents();
                            }else{
                                System.out.println("contact is not found");
                            }
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

    public static void printSharedFirstName(String name) { //newwwwwwww
        if (allContacts.empty()) {
            System.out.println("No contacts.");
        } else {
            Contact_BST sharedFirstNameContacts = new Contact_BST(); //ذي بنخزن فيها الكونتاكتس اللي لهم نفس الاسم الاول
            sharedFirstNameContacts = searchSharedFirstName(allContacts.root, name, sharedFirstNameContacts);
            if (!sharedFirstNameContacts.empty())
            {
                System.out.println("Contacts with the first name '" + name + "':");
                sharedFirstNameContacts.print();
            } else {
                System.out.println("No contacts found with the first name '" + name + "'.");
            }
        }
    }

    private static Contact_BST searchSharedFirstName(BSTNode r, String name, Contact_BST sharedContacts)
    {
        if (r != null) {
            String contactName = r.data.getName();
            String[] firstName = contactName.split(",");
            if (firstName.length > 0) {
                contactName = firstName[0];
            }
            if (contactName.equals(name)) {
                sharedContacts.insert(r.key, r.data);
            }
            searchSharedFirstName(r.left, name, sharedContacts);
            searchSharedFirstName(r.right, name, sharedContacts);
        } return sharedContacts;
    }
    public static void printSharedEvent(String evenTitle) {
        if (allEvents.empty())
            System.out.println("No events.");
        else {
            allEvents.findfirst();
            while (!allEvents.last()) {
                if (allEvents.retrieve().getTitle().equals(evenTitle)) {
                    System.out.println(allEvents.retrieve());
                }
                allEvents.findnext();
            }
            if (allEvents.retrieve().getTitle().equals(evenTitle)) {
                System.out.println(allEvents.retrieve());
            }
        }
    }

    public static void search() {
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
                Contact_BST emailList = allContacts.searchEmail(em);
                if (!emailList.empty()) {
                    System.out.println("Contact found!");
                    emailList.print();
                } else
                    System.out.println("Contact not found");

                break;

            case 4:
                System.out.println("Enter the contact's Address:");
                String address = input.nextLine();
                Contact_BST addressList = allContacts.searchAddress(address);
                if (!addressList.empty()) {
                    System.out.println("Contact found!");
                    addressList.print();
                } else
                    System.out.println("Contact not found");
                break;

            case 5:
                System.out.println("Enter the contact's Birthday:");
                String birth = input.nextLine();
                Contact_BST birthdayList = allContacts.searchBirthday(birth);
                if (!birthdayList.empty()) {
                    System.out.println("Contact found!");
                    birthdayList.print();
                } else
                    System.out.println("Contact not found");
                break;

        }

    }

    public static void scheduleAppointment(Contact c, Event e) {

        if (!checkConflict(allEvents, e.getDate())) {
            allEvents.addEventSorted(e);
            c.listOfevent.addEventSorted(e);
            e.getContactsInThisEvent().insert(c.getName() ,c);
            System.out.println("Event scheduled.");
        } else
            System.out.println("Event can't be scheduled there is a conflict.");

    }
    public static void scheduleEvent(Contact_BST contacts , Event event){
        if (!checkConflict(allEvents, event.getDate())) {
            allEvents.addEventSorted(event);
            //adds all contacts to the event and adds the event to each contact
            event.getContactsInThisEvent().insertAll(contacts,event);
            System.out.println("Event scheduled.");
        }else
            System.out.println("Event can't be scheduled there is a conflict.");
    }

    public static boolean checkConflict(eventList<Event> eList, Date date) {
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

    public static void removeContact(Contact c) {

        if (allContacts.empty())  {
            System.out.println("no contacts in the phonebook");
            return;
        }
    
          allContacts.removeKey(c.getName());
         

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





