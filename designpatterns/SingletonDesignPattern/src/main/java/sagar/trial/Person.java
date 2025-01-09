package sagar.trial;


//singleton class
//eager initialization
class Person {
    static Person obj;
    private Person(){
    }

    public static Person instance(){

        if(obj==null) {
             obj=new Person();
        }
        return obj;
    }
}

class Main{

    public static void main(String[] args) {
//        Thread t1=new Thread(()->{
//            Person instance = Person.instance();
//            System.out.println(instance.hashCode());
//        });
//
//        Thread t2=new Thread(()->{
//            Person instance = Person.instance();
//            System.out.println(instance.hashCode());
//        });
//
//        t1.start();
//        t2.start();

        Person p1=Person.instance();
        Person p2=Person.instance();

        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }


}
