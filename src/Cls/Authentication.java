package Cls;

public class Authentication {
    public static boolean isauthenticated;
    private static boolean authenticated = false;
    public static boolean isauthenticated(){
        return authenticated;
    }
    public static void setauthenticated(boolean status){
        authenticated = status;
    }
}
