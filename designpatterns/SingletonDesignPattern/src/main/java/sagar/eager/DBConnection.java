package sagar.eager;


//eager initlaization is thread safe
public class DBConnection {

    private static DBConnection conObject=new DBConnection();
    private DBConnection(){

    }

    public static DBConnection getInstance(){
        return conObject;
    }

}

class Main{
    public static void main(String[] args) {
        DBConnection singletonObject=DBConnection.getInstance();
        DBConnection singletonObject1=DBConnection.getInstance();
        System.out.println(singletonObject.hashCode());
        System.out.println(singletonObject1.hashCode());
    }
}
