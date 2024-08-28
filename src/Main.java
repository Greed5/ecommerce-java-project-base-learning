import Cls.Authentication;
import Database.DBconnection;
import forms.Login;
import forms.MainForm;
import forms.Registered;
import java.sql.Connection;


public class Main {
    public static void main(String[] args) {

        //Test connecction
        Connection connected = DBconnection.getConnection();
        if(connected!=null){
            System.out.println("Connected successfully!");
        }
    else{

            System.out.println("Failed to connect to database!");
        }

    //Main code run
        MainForm mainForm = new MainForm(null);
        Login login = new Login(mainForm);
        login.setVisible(true);

    //authenticate
        if (Authentication.isauthenticated){
            mainForm.setVisible(true);
        }

    }
}