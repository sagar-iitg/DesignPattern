package sagar.doublechecking;


public class DBConnection {

    private static DBConnection conObject;
    private DBConnection(){

    }

     public static DBConnection getInstance(){

        if(conObject==null){//check 1
            synchronized (DBConnection.class){
                if(conObject==null) { //check 2
                    conObject=new DBConnection();
                }

            }

        }


        return conObject;
    }

}

class Main{
    public static void main(String[] args) {
        DBConnection singletonObject=DBConnection.getInstance();
        DBConnection singletonObject1=DBConnection.getInstance();
        DBConnection singletonObject2=DBConnection.getInstance();
        System.out.println(singletonObject.hashCode());
        System.out.println(singletonObject1.hashCode());
        System.out.println(singletonObject2.hashCode());
    }
}
