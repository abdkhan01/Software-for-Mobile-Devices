import java.util.Scanner;
import java.io.Console;
abstract class Animal{
    private String name;
    private static int legs;
    private String color;
    private static String type;
    
    Animal(String n,int l,String c, String t){
        this.name = n;
        legs = l;
        this.color = c;
        type = t;
        System.out.println("Animal is created");
    }
    
    public void eat(){
        System.out.println(this.name+" is eating");
    }
    
    public abstract void  sound(); 
    
    public static void  run(){
        
        System.out.println("Animal is running");
        
    
        
    };
    
    
    
    public final void setname(String n){
        this.name = n;
    }
    
    public void setcolor(String c){
        this.color = c;
    }
    
    public static void setlegs(int l){
        legs = l;
    }
    
    public static void settype(String t){
        type = t;
    }
    
    public String getcolor(){
        return this.color;
    } 
      
    public String getname(){
        return this.name;
    } 
      
    public static int getlegs(){
        return legs;
    } 
    
    public static String gettype(){
        return type;
    }

     
}

interface gorilla{
    public void sound();
    public void dance();
}

interface dog{
    public void sound();
    public void sniff();
    
}

class Gorilla extends Animal implements gorilla{
    
    
    Gorilla(String n,int l,String c, String t){
        super(n,l,c,t);
        System.out.println("...Which is a Gorilla");

    }
    
    public static void run(){
        System.out.println("Gorilla is running with " + getlegs() + " legs. ");
        

    }
    
    public void sound(){
        System.out.println("Gorilla is making sound.");

    }
    
    public void dance(){
        System.out.println("Gorilla is dancing");

    }
    
    
    
    
}

class Dog extends Animal implements dog{
    
    
    Dog(String n,int l,String c, String t){
        super(n,l,c,t);
        System.out.println("...Which is a Dog");

    }
    
    public static void run(){
        System.out.println("Dog is running with " + getlegs() + " legs. ");
        

    }
    
    public void sound(){
        System.out.println("Dog is making sound.");

    }
    
    public void sniff(){
        System.out.println("Dog is sniffing");

    }
    
    class PoliceDog{
        PoliceDog(){
            System.out.println("...Which is a PoliceDog");

        }
        
        public void guard(){
            System.out.println(getname() + " is guarding");

        }
    }
    
    static class PetDog{
        PetDog(){
            System.out.println("...Which is a PetDog");

        }
        
        public static void fetch(){
            
            if(gettype()=="carnivour")
            {
                System.out.println("Carnivour dogs cannot fetch");
                
            }
            else
                System.out.println("PetDog is fetching");

            
        }
    }
    
    
    
    
}





public class Test{
    public static void main(String []args){
        Gorilla obj = new Gorilla("homba",2,"black","herbivour");
        obj.eat();
        obj.run();
        obj.sound();
        System.out.println(Gorilla.gettype());
        
        System.out.println("------------------------");
        
        Dog d = new Dog("Tyson",4,"black","carnivour");
        Dog.PoliceDog pd = d.new PoliceDog();
        d.sniff();
        pd.guard();
        System.out.println(d.gettype());
        
        System.out.println("------------------------");
        
        Dog x = new Dog("Saad",4,"brown","carnivour");
        Dog.PetDog fd = new Dog.PetDog();
        x.sniff();
        fd.fetch();
        
        System.out.println("------------------------");
        
        Scanner sc = new Scanner(System.in);
        try{
           System.out.println("Enter details for a new animal....");
            System.out.println("press G for gorilla OR press D for Dog....");
            
            String t = sc.nextLine();
            
            
        }
        catch (java.util.NoSuchElementException e){
           System.out.println("Input Exception");
        }
        
        

      

     }
}