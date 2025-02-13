public class Animal{
    public String animal;
    public String name;  
    public int age;
    public String gender;
    
    
    public void main(String[] args) throws Exception {

        //objects & variables declared
        Animal myAnimal = new Animal();
        
        Fish myFish = new Fish();

        Zebra myZebra = new Zebra();
        myZebra.is_wild = true;

        //printed statements start
        System.out.println("===============================================");

        //calls all functions for myAnimal
        System.out.println(myAnimal.PrintBio("animal", "myAnimal", 12, "male"));
        System.out.println(myAnimal.isMammal(false));
        myAnimal.Mate(6);
        System.out.println(" ");
        
        //calls all functions for myZebra
        System.out.println(myZebra.PrintBio("zebra", "myZebra", 6, "female"));
        System.out.println(myZebra.isMammal(true));
        myZebra.Mate(12);
        myZebra.run();

        

    }

    //sets & prints information reguarding the animal
    public String PrintBio(String setAnimal,String setName,int setAge,String setGender ){
        animal = setAnimal;
        name = setName;
        age = setAge;
        gender = setGender;

        return name + " is a " + age + " year old " + gender + " " + animal;

    }

    public String isMammal(boolean mammal){
        //prints out wether or not this object is a mammal, adds 'not' to the sentence if it isn't
        String sentenceChanger = "";

        if(mammal == false){
            sentenceChanger = "not ";
        }

        return name + " is " + sentenceChanger + "a mammal";
    }


    //lets you know that the animal has mated
    public void Mate(int months){
        System.out.println(name + " has mated, expect new " + name + "s in " + months + " months.");
    } 
}

class Fish extends Animal{
    private double sizeInFeet;

    private String canEat(){
        return "this fish is now eating";
    }

}

class Zebra extends Animal{
    public boolean is_wild;
    
    //overrides bio to include weather or not the zebra is wild
    @Override public String PrintBio(String setAnimal,String setName,int setAge,String setGender ){
        String tameness = "wild ";
        animal = setAnimal;
        name = setName;
        age = setAge;
        gender = setGender;

        if(is_wild == false){
            tameness = "tamed";
        }
        return name + " is a " + age + " year old "+ tameness + gender + " " + animal;
    }

    //zebra runs because they saw a lion
    public void run(){
        System.out.println(name + " has spotted a lion, it is now running for its life");
    }
}