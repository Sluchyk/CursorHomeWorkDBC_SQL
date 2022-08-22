package model.dao;

import model.dbconnect.DBConnect;
import model.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements CommonQuery{
    @Override
    public List<?> getAll(String query) {
        List<Product> allProducts=new ArrayList<>();
        try {
            Connection con= DBConnect.getCon();
            PreparedStatement stmt = con.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                Product product=new Product();
                product.setId(rs.getInt("products_id"));
                product.setName(rs.getString("products_name"));
                product.setPrice(rs.getBigDecimal("price"));
                allProducts.add(product);
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

