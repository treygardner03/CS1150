  /* Trey Gardner
     * CS1150 (M/W)
     * Assignment #12
     * Due: December 4th 2024
	 * Description: Writing a program that creates an array that holds objects that are 
	 * subclasses of a super class, the information for each object is read off of a 
	 * .txt file provided by the prof.
     */


import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class gardner_trey_assignment_12 {
	public static void main(String[] args) throws IOException {
	
	//creating instance of the file in program
	File animalInfo = new File("Animals.txt");
	//creating scanner that pulls from instance of file
	Scanner input = new Scanner(animalInfo);
	//arrayLenght determined by first line in text ALWAYS
	int arrayLength = input.nextInt();
	//declaring String animalType
	String animalType;

	//length of array is pulled from "Animals.txt" file	
	//polymorphic animal array
	Animal[] animals = new Animal[arrayLength];
	
	int indexCounter = 0;
	
	for(int i = 0; i < arrayLength; i++) {

		animalType = input.next().trim();

		if(animalType.equals("Bear")) {

			Bear bear = new Bear(input.next(), input.next(), input.nextDouble(),
			 input.nextDouble(), input.nextLine());
			animals[indexCounter] = bear;	
			indexCounter++;
		}

		if(animalType.equals("Elephant")) { 

			Elephant elephant = new Elephant(input.next(), input.next(),
			 input.nextDouble(), input.nextDouble(), input.nextLine());
			animals[indexCounter] = elephant;	
			indexCounter++;
		}

		if(animalType.equals("Monkey")) {

			Monkey monkey = new Monkey(input.next(), input.next(), input.nextDouble(),
			 input.nextDouble(), input.nextLine());
			animals[indexCounter] = monkey;	
			indexCounter++;
		}

		if(animalType.equals("Sloth")) {

			Sloth sloth = new Sloth(input.next(), input.next(), input.nextDouble(),
			 input.nextDouble(), input.nextLine());
			animals[indexCounter] = sloth;	
			indexCounter++;
		}
	}
	input.close();

	for(int i = 0; i < arrayLength; i++) {
		if(animals[i] instanceof Bear) {
			animalType = "Bear";
			System.out.println("\nanimals[" + i + "] is a " + animalType
			 + "\n" + animals[i].toString());
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();
		}
		if(animals[i] instanceof Elephant) {
			animalType = "Elephant";
			System.out.println("\nanimals[" + i + "] is a " + animalType
			 + "\n" +  animals[i].toString());
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();
		}
		if(animals[i] instanceof Monkey) {
			animalType = "Monkey";
			System.out.println("\nanimals[" + i + "] is a " + animalType
			 + "\n" +  animals[i].toString());
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();
		}
		if(animals[i] instanceof Sloth) {
			animalType = "Sloth";
			System.out.println("\nanimals[" + i + "] is a " + animalType
			 + "\n" +  animals[i].toString());
			animals[i].eat();
			animals[i].sleep();
			animals[i].swim();
		}
	}
	}

//method that reads file and creates animal objects?

//method that places animal objects into polymorphic arrray
}

//super class
class Animal{

	private String name;
	private String food;
	private double weight; 
	private double timeSleep;
	private String location;

	public Animal(String name, String food, double weight, double timeSleep,
	 String location){

		this.name = name;
		this.food = food;
		this.weight = weight;
		this.timeSleep = timeSleep;
		this.location = location;
	}
	
	public String getName() {
		return this.name;
	}
	public String getFood() {
		return this.food;
	}
	public double getWeight() {
		return this.weight;
	}
	public double getTimeSleep() {
		return this.timeSleep;
	}
	public String getLocation() {
		return this.location;
	}
	public void eat() {
		System.out.println("animal is eating");
	}
	public void sleep() {
		System.out.println("animal is sleeping - do not disturb");
	}
	public void swim() {
		System.out.println("animal is swimming");
	}
}

//sub class (bear)
class Bear extends Animal {

	public Bear(String name, String food, double weight, double getTimeSleep,
	 String location) {

		super(name, food, weight, getTimeSleep, location);
	}

@Override
	public String toString() {
		String temp = "Bear Name: " + this.getName() + " - Weighs: " + this.getWeight()
		 + "lbs - Sleeps: " + this.getTimeSleep() + " hours - Location:" +this.getLocation();
		return temp;
	}
	@Override
	public void eat() {
		System.out.println("Bear is eating " + getFood());
	}
	@Override
	public void sleep() {
		System.out.println("Bear is sleeping " + getTimeSleep() + " hours");
	}
	@Override
	public void swim() {
		System.out.println("Bear is swimming");
	}
}

//sub class (elephant)
class Elephant extends Animal {

	public Elephant(String name, String food, double weight, double getTimeSleep,
	 String location) {

		super(name, food, weight, getTimeSleep, location);
	}
@Override
	public String toString() {
		String temp = "Elephant Name: " + this.getName() + " - Weighs: " + this.getWeight()
		 + "lbs - Sleeps: " + this.getTimeSleep() + " hours - Location:" + this.getLocation();
		return temp;
	}
	@Override
	public void sleep() {
		System.out.println("Elephant is sleeping " + getTimeSleep() + " hours");
	}
}


//sub class (monkey)
class Monkey extends Animal {

	public Monkey(String name, String food, double weight, double getTimeSleep, 
	String location) {

		super(name, food, weight, getTimeSleep, location);
	}

@Override
	public String toString() {
		String temp = "Monkey Name: " + this.getName() + " - Weighs: " + this.getWeight()
		 + " lbs - Sleeps: " + this.getTimeSleep() + " hours - Location:" + this.getLocation();
		return temp;
	}
	@Override
	public void eat() {
		System.out.println("Monkey is eating " + getFood());
	}
}


//sub class (sloth)
class Sloth extends Animal {
	
	public Sloth(String name, String food, double weight, double getTimeSleep,
	 String location) {

		super(name, food, weight, getTimeSleep, location);
	}

@Override
	public String toString() {
		String temp = "Sloth Name: " + this.getName() + " - Weighs: " + this.getWeight()
		 + " lbs - Sleeps: " + this.getTimeSleep() + " hours - Location:" + this.getLocation();
		return temp;
	}
}
