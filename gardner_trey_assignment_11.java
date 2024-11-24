    /* Trey Gardner
     * CS1150 (M/W)
     * Assignment #11
     * Due: December 2nd 2024
     * Description: Using classes, objects, arrays, and inheritance to manipulate cars properties and owners.
     */
    
    
    import java.io.PrintWriter;
    import java.io.File;
    import java.io.IOException;
    
    public class gardner_trey_assignment_11 {
        public static void main(String[] args) throws IOException {
            Car[] cars = new Car[5]; 
            createCars(cars);
            writeCarDetailsToFile(cars);
            System.out.println("Cars at start of the simulation");
            printCars(cars);
           simulation(cars);
            
        
            
            
        }
    
    //manually create and insert each car "from table" into cars array	
    public static void createCars(Car[] cars) { 
    
        String owner = "Empty";
        String model = "Empty";
        double mpg = 0;
        double mileage = 0;
        double gallons = 0;
        
        for(int i = 0; i < cars.length; i++) {
            if(i == 0) {
                owner = "Donkey";
                model = "Toyota Tundra";
                mpg = 15;
                mileage = 34000;
                gallons = 8;
            }
        
    
            if(i == 1) {
                owner = "Fiona";
                model = "Audi Q7";
                mpg = 21;
                mileage = 7110;
                gallons = 10;
            }
        
    
    
            if(i == 2) {
                owner = "Shrek";
                model = "Jeep CJ5";
                mpg = 14;
                mileage = 1180;
                gallons = 5;
            }
        
    
    
            if(i == 3) {
                owner = "Farquaad";
                model = "Smart Car";
                mpg = 42;
                mileage = 82700;
                gallons = 4;
            }
        
    
    
            if(i == 4) {
                owner = "Dragon";
                model = "Chevy Suburban";
                mpg = 12;
                mileage = 150245;
                gallons = 30;
            }
            
            cars[i] = new Car(owner, model, mpg, mileage, gallons);
            
        }
    
    
    }
    
    //print each cars details (owner, model, fuel economy, current mileage, fuel level)
    public static void printCars(Car[] cars) {
        String lineBreak = "\n---------------------------------------------------------------";
        
        System.out.println(lineBreak + "\nOwner\tVehicle\tMPG\tGallons\tMileage" + lineBreak);
        for(int i = 0; i < cars.length; i++) { 
            System.out.println(cars[i].getOwner() + "\t" + cars[i].getModel() +  "\t" + cars[i].getMpg() + "\t" +  cars[i].getFuelGauge().getGallons() + "\t" +  cars[i].getOdometer().getMileage());
        }
    }
    
    //Simulate the cars driving and call updateMiles and decrementGallons
    public static void simulation(Car[] cars) {
        
       Car[] carsOutOfGas = new Car[cars.length];
       int indexCounter = 0;
       boolean allCarsAreEmpty = false;
      final int INTERATION_MILES = 25;
      System.out.println("Cars ran out of gas in this order" + "\n-------------------------------------------------");

       while(allCarsAreEmpty == false){

        for(int i = 0; i < cars.length; i++){
           
        	if(cars[i].getFuelLevel().equals("Has Gas")){
                double gallonsNeededForInteration = INTERATION_MILES / cars[i].getMpg();
                FuelGauge currentFuelGauge = cars[i].getFuelGauge();
                double currentGallons = currentFuelGauge.getGallons();

                if(currentGallons >= gallonsNeededForInteration){
                    currentFuelGauge.decrementGallons(gallonsNeededForInteration);
                    Odometer currentOdometer = cars[i].getOdometer();
                    currentOdometer.updateMiles(INTERATION_MILES);
               
                }
                else{
                    cars[i].getFuelLevel("Empty");
                    carsOutOfGas[indexCounter] = cars[i];
                    System.out.println("Ran out of gas: " + cars[i].getOwner());
                    indexCounter++;
                }
            }
        }

       allCarsAreEmpty = checkFuelLevels(cars);
       }
       printCars(carsOutOfGas);
    }
    
    //checking until ALL cars are out of fuel (true = all cars are out of fuel, false = not all cars are out of fuel)
    public static boolean checkFuelLevels(Car[] cars) {

        int counter = 0;
      for(int i = 0; i < cars.length; i++){
        if(cars[i].getFuelLevel() == "Empty"){
            counter++;
        }
      } 
      
      if(counter == cars.length){
        return true;
      }
      return false;
    }
    
    //Code given, writing car information to a .txt file
    public static void writeCarDetailsToFile(Car[] cars) throws IOException {//write car details to file
    
            File carDetailsFile = new File("Assignment11.txt");
            PrintWriter resultFile = new PrintWriter(carDetailsFile);
            
            resultFile.println("Car Details:");
            
            for(int i = 0; i < cars.length; i++) {
                resultFile.println(cars[i].getOwner());
                resultFile.println(cars[i].getModel());
                resultFile.println(cars[i].getMpg());
                resultFile.println(cars[i].getFuelGauge().getGallons());
                resultFile.println();
    
            }
            resultFile.close();

            System.out.println("Find the file here" + carDetailsFile.getAbsolutePath());
            System.out.println();
    }//Write car details to file
   
    }
    
    
    //Defining Car class attributes and methods	
    class Car {
    
        private String owner;
        private String model;
        private double mpg;
        private String fuelLevel = "Has Gas";
        private Odometer odometer;
        private FuelGauge fuelGauge;
    
        public String getOwner() {
            return this.owner;
        }
        public String getModel() {
            return this.model;
        }
        public double getMpg() {
            return this.mpg;
        }
        public String getFuelLevel() {
            return this.fuelLevel;
        }
        public FuelGauge getFuelGauge() {
            return this.fuelGauge;
        }
        public Odometer getOdometer() {
            return this.odometer;
        }
        public void getFuelLevel(String fuelLevel) {
            this.fuelLevel = fuelLevel;
        }
        public Car(String owner, String model, double mpg, double mileage, double gallons) {
            this.owner = owner;
            this.model = model;
            this.mpg = mpg;
            odometer = new Odometer(mileage);
            fuelGauge = new FuelGauge(gallons);
        }
    
    }
    
    //Defining Odometer class attributes and methods
    class Odometer {
        
        private double mileage;
    
        public Odometer(double mileage) {
            this.mileage = mileage;
        }
        
        public double getMileage() {
            return this.mileage;
        }
    
        public void updateMiles(double milesTraveled) {
            this.mileage = this.mileage + milesTraveled;
        }
    }
    
    //Defining FuelGauge class attributes and methods
    class FuelGauge {
        
        private double gallons;
        
        public FuelGauge(double gallons) {
            this.gallons = gallons;
        }
    
        public double getGallons() {
            return this.gallons;
        }
    
        public void decrementGallons(double gallonsUsed) {
            if(this.gallons >= gallonsUsed) {
                this.gallons = this.gallons - gallonsUsed;
            }
            else {
                this.gallons = 0;
            }
        }
    }