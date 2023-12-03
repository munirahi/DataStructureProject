
public class Contact implements Comparable<Contact> {

    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private String birthday;
    private String notes;

    public eventList<Event> listOfevent ;

    public Contact() {

    }

    public Contact(String name, String phonenumber, String email, String address, String birthday, String notes) {

        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        listOfevent  =new eventList<Event>();
    }





    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


    public String getBirthday() {
        return birthday;
    }


    public eventList<Event> getListOfevent() {
        return listOfevent;
    }

    @Override
    public String toString() {
        String s = printAllEvents();

        return "\nName:" + name + "\nPhone Number:" + phonenumber + "\nEmail Address:" + email + "\nAddress:" + address
                + "\nBirthday:" + birthday + "\nNotes:" + notes + "\nevents with this contact:\n"+ s;
    }

    public int compareTo(Contact c) {
        // TODO Auto-generated method stub
        return name.compareTo(c.name);
    }

    public String printAllEvents() {
        String s ="";
        if(listOfevent.empty())
            s= "there are no events with this contact";
        else {listOfevent.findfirst();
            while (!listOfevent.last()) {
                s += listOfevent.retrieve().getTitle()+ listOfevent.retrieve().getDate()+"\n";
                listOfevent.findnext();
            }s += listOfevent.retrieve().getTitle() + listOfevent.retrieve().getDate()+ "\n";
        }

        return s ;
    }


}

