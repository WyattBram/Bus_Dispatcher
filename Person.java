public class Person {

    private String name;
    private int ticketNumber;
    static private int nextTicketNumber;

    Person(){
        name = "NO NAME";
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;



    }

    Person(String str){
        name = str;
        ticketNumber = nextTicketNumber;
        nextTicketNumber++;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return ticketNumber + "\t" + name;
    }


}
