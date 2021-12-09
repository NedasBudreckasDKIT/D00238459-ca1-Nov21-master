//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class PassengerStore {
//
//    private final ArrayList<Passenger> passengerList;
//
//    public PassengerStore(String fileName) {
//        this.passengerList = new ArrayList<>();
//        loadPassengerDataFromFile(fileName);
//    }
//
//    public List<Passenger> getAllPassengers() {
//        return this.passengerList;
//    }
//
//    public void displayAllPassengers() {
//        for (Passenger p : this.passengerList) {
//            System.out.println(p.toString());
//        }
//    }
//    /**
//     * Read Passenger records from a text file and create and add Passenger
//     * objects to the PassengerStore.
//     */
//    public Object findPassengerByName(String passengerName){
//        //1
////        for (int i=0; i < List.length;i++) {
////            if(passengerName = passengerList(passengerName){
////                System.out.println(passengerName);
////            }
////        }
//        //2
////        for (Passenger p : this.passengerList) {
////            if(List.contains(passengerName)){
////                System.out.println(p);
////            }
////        }
//        return null;
//    }
//    private void loadPassengerDataFromFile(String filename) {
//
//        try {
//            Scanner sc = new Scanner(new File(filename));
////           Delimiter: set the delimiter to be a comma character ","
////                    or a carriage-return '\r', or a newline '\n'
//            sc.useDelimiter("[,\r\n]+");
//
//            while (sc.hasNext()) {
//                int id = sc.nextInt();
//                String name = sc.next();
//                String email = sc.next();
//                String phone = sc.next();
//                double latitude = sc.nextDouble();
//                double longitude = sc.nextDouble();
//
//                // construct a Passenger object and add it to the passenger list
//                passengerList.add(new Passenger(id, name, email, phone, latitude, longitude));
//            }
//            sc.close();
//
//        } catch (IOException e) {
//            System.out.println("Exception thrown. " + e);
//        }
//    }
//
//    // TODO - see functional spec for details of code to add
//
//} // end class
