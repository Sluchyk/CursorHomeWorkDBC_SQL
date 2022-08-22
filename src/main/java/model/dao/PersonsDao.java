package model.dao;

import model.dbconnect.DBConnect;
import model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonsDao  implements CommonQuery  {
    @Override
    public   List<?> getAll(String query) {
        List<Person> allProducts=new ArrayList<>();
        try {
            Connection con= DBConnect.getCon();
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Person person=new Person();
                person.setId(rs.getInt("person_id"));
                person.setName(rs.getString("first_name"));
                person.setLastName(rs.getString("last_name"));
                person.setAge(rs.getInt("age"));
                allProducts.add(person);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allProducts;

    }
}
