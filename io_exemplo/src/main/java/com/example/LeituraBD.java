package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LeituraBD {


    public void teste() {
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
             "postgres", "postgres");
             //tradutor de sql
             Statement stmt = con.createStatement();
             //armazena os resultados
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuarios");
while (rs.next()) {
    //printar resultado
    System.out.println("ID:"+rs.getInt("id")
    +" Nome:"+ rs.getString("nome")
    +" Idade:"+ rs.getString("idade")
    );

    con.close();
}



        
    } catch (Exception e) {
        e.printStackTrace();
    }



}

}