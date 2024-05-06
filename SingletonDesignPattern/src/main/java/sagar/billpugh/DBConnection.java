package sagar.billpugh;

public class DBConnection {


    private DBConnection(){

    }
    private static class DBConnectionHelper{
        private static  final sagar.billpugh.DBConnection instance=new sagar.billpugh.DBConnection();

    }

    public static DBConnection getInstance(){
        return DBConnectionHelper.instance;
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
