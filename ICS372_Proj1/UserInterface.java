public class UserInterface {
    public static void main(String[] args) throws InterruptedException{
        Dealership whiteBearMistubishi = new Dealership(1234);
        SUV mySUV = new SUV(1234, "Honda", "CRV", 11, 12000, 14599999);
        Sedan mySedan = new Sedan(1234, "Honda", "Civic", 12, 14000, 159896869);
        whiteBearMistubishi.addVehicle(mySUV);
        whiteBearMistubishi.addVehicle(mySedan);
        System.out.println(whiteBearMistubishi.vehicleListString() + "\n\n\n");

        Thread.sleep(3000);


        System.out.print("                                Removing Sedan");
        for(int i = 0; i < 3; i++){
            Thread.sleep(300);
            System.out.print(".");
        }
        Thread.sleep(300);
        
        System.out.println("\n\n\nNew Vehicle List:");
        whiteBearMistubishi.removeVehicle(mySedan);
        System.out.println(whiteBearMistubishi.vehicleListString());
    }
}
