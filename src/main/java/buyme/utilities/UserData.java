package buyme.utilities;

import java.util.ArrayList;

public class UserData {
 public static Xls_Reader reader;


    public static ArrayList<Object[]> getLoginData(){
        ArrayList<Object[]>data=new ArrayList<>();
        reader= new Xls_Reader("C:\\Users\\coevy\\IdeaProjects\\BuymeAutoV\\src\\main\\java\\buyme\\usersData\\Book1.xlsx");
        for(int i=2;i<=reader.getRowCount("login");i++){
            String email=reader.getCellData("login","email",i);
            String password= reader.getCellData("login","pw",i);
            Object obj[]={email,password};
            data.add(obj);
        }
        return data;
    }

}
