package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerDao {
    public void add(Customer customer) throws SQLException;

    public Customer selectCustomer(int id);

    public List<Customer> findAll();

    public  List<Customer> sortByName();

    public boolean delete(int id) throws SQLException;

    public boolean updateUser(Customer customer) throws SQLException;

    public List<Customer> findByName(String name);
}
