import java.util.ArrayList;
import java.util.Objects;

public class Bus {
    public ArrayList<Person> passengers;
    private static int nextId;
    private int busId;

    Bus(){
        passengers = new ArrayList<Person>();
        busId = nextId;
        nextId++;


    }

    public int getId(){
        return busId;
    }



    public void addPerson(Person person){
        passengers.add(person);
    }

    public Boolean removePerson(Person person){

        if (passengers.contains(person)){
            passengers.remove(person);
            return Boolean.TRUE;

        }
        else{
            return Boolean.FALSE;
        }
    }

    public Person findPerson(String name){
        for(int i = 0; i<passengers.size(); i++){
            if(Objects.equals(passengers.get(i).getName(), name)){
                return passengers.get(i);
            }
        }
        return null;
    }

    public static Boolean transferPerson(Bus bus1, Bus bus2, Person person){
        if (bus1.passengers.contains(person)){
            bus2.passengers.add(person);
            bus1.passengers.remove(person);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    //THis too i think
    public String getPassengers(){
        String temp = "";
        for(int i = 0; i<passengers.size(); i++) {
            temp = temp + passengers.get(i).toString() + "\n";
        }
        return temp;
    }

    /// Fix this shit boy
    @Override
    public String toString(){
        return String.valueOf(busId);
    }

}
