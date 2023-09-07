import java.util.ArrayList;

public class Dispatcher {

    public ArrayList<Bus> busQueue = new ArrayList<Bus>();

    public int addBus(Bus bus){
        busQueue.add(bus);
        return busQueue.indexOf(bus);
    }


    public int addBus(Bus bus, int position){
        busQueue.remove(findBus(bus.getId()));
        if(busQueue.size() - 1 > position){
            busQueue.add(bus);
            return busQueue.indexOf(bus);
        }
        else{
            System.out.println(busQueue.size() - 1);
            System.out.println(position);
            busQueue.add(bus);
            return busQueue.indexOf(bus);
        }

    }


    public Bus findBus(int id){
        for(int i = 0; i<busQueue.size(); i++){
            if(busQueue.get(i).getId() == id){
                return busQueue.get(i);
            }
        }
        return null;
    }


    public Bus removeBus(int id){
        for(int i = 0; i<busQueue.size(); i++){
            if(busQueue.get(i).getId() == id){
                Bus ids = busQueue.get(i);
                busQueue.remove(i);
                return ids;
            }
        }
        return null;
    }


    public Bus dispatchBus(){
        if(busQueue.isEmpty()){
            return null;
        }
        Bus temp = busQueue.get(0);
        busQueue.remove(0);
        return temp;
    }

    //fix dis too
    @Override
    public String toString(){
        String a = "";
        for(int i = 0; i<busQueue.size(); i++) {
            a = a + busQueue.get(i).toString() + "\n";
        }
        return a;
    }


}
