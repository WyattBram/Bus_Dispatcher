import java.sql.SQLOutput;
import java.util.Scanner;

public class Driver {
    Dispatcher dispatcher;
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        int choice;


        do{

            System.out.println(
                    "1. Add bus\n" +
                    "2. Add Person to bus\n"+
                    "3. Remove bus\n"+
                    "4. Remove person\n"+
                    "5. List passengers\n"+
                    "6. List busses\n"+
                    "7. Requeue bus\n"+
                    "8. Transfer person\n"+
                    "9. Dispatch bus\n"+
                    "0. Exit");
            Scanner x = new Scanner (System.in);
            choice = x.nextInt();
            x.nextLine();


            if (choice == 1){
                Bus bus = new Bus();
                System.out.println("Bus " + bus.getId() + " added to position " + dispatcher.addBus(bus));
            }



            else if (choice == 2){



                int askId;
                String askName;
                System.out.println("Bus Id: ");
                askId = x.nextInt();
                x.nextLine();

                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                }
                else{
                    System.out.println("Persons name: ");
                    askName = x.nextLine();
                    dispatcher.findBus(askId).addPerson(new Person(askName));
                    //dispatcher.busQueue.get(dispatcher.busQueue.).addPerson(new Person(askName));
                    System.out.println(askName + " has been added to bus " + askId);
                }
            }



            else if (choice == 3){
                int askId;
                System.out.println("Bus Id: ");
                askId = x.nextInt();
                x.nextLine();
                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                }
                else {
                    dispatcher.removeBus(askId);
                    System.out.println("Bus " + askId + " removed");
                }
            }

//Person a = dispatcher.findBus(askId).findPerson(askName);

            else if (choice == 4){
                int askId;
                String askName;
                System.out.println("Bus Id: ");
                askId = x.nextInt();
                x.nextLine();
                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                }
                else{
                    System.out.println("Persons name: ");
                    askName = x.nextLine();
                    Person a = dispatcher.findBus(askId).findPerson(askName);
                    if (dispatcher.busQueue.get(askId).removePerson(a)){
                        System.out.println(askName + " has been removed from bus " + askId);
                    }
                    else {
                        System.out.println("No such person found in bus" + askId);
                    }

                }
            }



            else if (choice == 5){
                int askId;
                System.out.println("Bus Id: ");
                askId = x.nextInt();
                x.nextLine();
                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                }
                else {
                    System.out.println("Bus " + askId);
                    System.out.println(dispatcher.findBus(askId).getPassengers());


                }


            }



            else if (choice == 6){
                System.out.println("BUS QUEUE");
                System.out.println(dispatcher.toString());
            }



            else if (choice == 7){
                int askId;
                System.out.println("Bus Id: ");
                askId = x.nextInt();
                x.nextLine();
                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                }
                else{
                    int askIdI;
                    System.out.println("New position: ");
                    askIdI = x.nextInt();
                    x.nextLine();

                    dispatcher.addBus(dispatcher.findBus(askId), askIdI);
                    System.out.println("Bus " + askId + " added to position " + dispatcher.busQueue.indexOf(dispatcher.findBus(askId)));
                }
            }



            else if (choice == 8){
                int askId;
                int askIdI;
                String askName;
                System.out.println("Enter bus Id 1: ");
                askId = x.nextInt();
                x.nextLine();
                System.out.println("Enter bus Id 2: ");
                askIdI = x.nextInt();
                x.nextLine();
                System.out.println("Persons name: ");
                askName = x.nextLine();

                int a = 0;
                if(dispatcher.findBus(askId) == null){
                    System.out.println("No bus with id " + askId);
                    a++;
                }
                if(dispatcher.findBus(askIdI) == null){
                    System.out.println("No bus with id " + askIdI);
                    a++;
                }
                if(dispatcher.findBus(askId).findPerson(askName) == null){
                    System.out.println("No person named " + askName);
                    a++;
                }
                if(a == 0){
                    Bus.transferPerson(dispatcher.findBus(askId), dispatcher.findBus(askIdI),dispatcher.findBus(askId).findPerson(askName));
                    System.out.println("Person transferred successfully");
                }



            }



            else if (choice == 9){
                Bus a = dispatcher.dispatchBus();
                if (a == null){
                    System.out.println("Bus queue is empty");
                }
                else{
                    System.out.println("Bus " +  a.getId() + " has been disbatched");

                }

            }



        }while (choice != 0);

    }
}