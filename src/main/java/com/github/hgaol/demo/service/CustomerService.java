package com.github.hgaol.demo.service;


import com.github.hgaol.demo.model.Customer;
import com.github.hgaol.uiharu.annotation.Service;
import com.github.hgaol.uiharu.annotation.Transaction;
import com.github.hgaol.uiharu.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供客户数据服务
 */
@Service
public class CustomerService {

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        List<Customer> customers = new ArrayList<Customer>() {{
            add(new Customer("a", "contact", "123", "w@w.com"));
        }};
        return customers;
    }

    public List<Customer> getCustomersBySQL() {
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomersById() {
        String sql = "SELECT * FROM customer where id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, "1");
    }

    @Transaction
    public boolean createFailure() {
        Customer a = new Customer("b", "xiao b", "1234567890", "b@m.com");
        boolean result = DatabaseHelper.insert(a);
        throw new Error("lalala");
    }

}
