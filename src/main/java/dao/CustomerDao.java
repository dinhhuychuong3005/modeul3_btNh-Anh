package dao;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    private final String FIND_ALL_QUERY = "select*from cus;";
    private final String INSERT_CUSTOMER = "INSERT INTO cus" + "  (name,age) VALUES " +
            " (?, ?);";
    private final String UPDATE_CUSTOMER = "update cus set name = ?, age =? where id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from cus where id =?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from cus where id = ?;";
    private static final String SORT_BY_NAME = "SELECT * from cus order by name ;";
    private static final String FIND_BY_NAME = "SELECT * from cus where cus.name like ? ;";
    SQLConnection sqlConnection = new SQLConnection();

    @Override
    public void add(Customer customer) throws SQLException {
        Connection connection = sqlConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER);
        statement.setString(1, customer.getName());
        statement.setInt(2, customer.getAge());
        statement.executeUpdate();
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try {
            Connection connection = sqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                customer = new Customer(id, name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = sqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_QUERY);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                list.add(new Customer(id, name, age));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi!!!!!");
        }
        return list;
    }

    @Override
    public List<Customer> sortByName() {
        List<Customer> customers = new ArrayList<>();
        try {

            Connection connection = sqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                customers.add(new Customer(name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean row;
        Connection connection = sqlConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
        statement.setInt(1, id);
        row = statement.executeUpdate() > 0;
        return row;
    }

    @Override
    public boolean updateUser(Customer customer) throws SQLException {
        boolean row;
        Connection connection = sqlConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);
        statement.setString(1, customer.getName());
        statement.setInt(2, customer.getAge());
        statement.setInt(3, customer.getId());
        row = statement.executeUpdate() > 0;
        return row;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = sqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name1 = rs.getString("name");
                int age = rs.getInt("age");
                list.add(new Customer(name1, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
