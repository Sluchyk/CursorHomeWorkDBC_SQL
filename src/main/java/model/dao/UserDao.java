package model.dao;

import model.dbconnect.DBConnect;
import model.entity.Product;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements CommonQuery {
    @Override
    public List<?> getAll(String query) {
        List<User> users=new ArrayList<>();
        try {
            Connection con= DBConnect.getCon();
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                User user=new User();
                user.setId(rs.getInt("id_user"));
                user.setLogin(rs.getString("user_login"));
                user.setPassword(rs.getString("user_password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return users;
    }
}
