package com.github.hgaol.demo.controller;

import com.github.hgaol.demo.bean.FailedBean;
import com.github.hgaol.demo.model.Customer;
import com.github.hgaol.demo.service.CustomerService;
import com.github.hgaol.uiharu.annotation.Action;
import com.github.hgaol.uiharu.annotation.Body;
import com.github.hgaol.uiharu.annotation.Controller;
import com.github.hgaol.uiharu.annotation.Inject;
import com.github.hgaol.uiharu.bean.Data;
import com.github.hgaol.uiharu.bean.Param;
import com.github.hgaol.uiharu.bean.View;
import com.github.hgaol.uiharu.helper.DatabaseHelper;

import java.util.List;

/**
 * 处理客户管理相关请求
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     */
    @Action(path = "/customers")
    public View index() {
        List<Customer> customerList = customerService.getCustomersBySQL();
        return new View("customer.jsp").addModel("customerList", customerList);
    }

    @Action(path = "/data")
    public Data data() {
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }

    @Action(path = "/datas")
    public Data params(Param param) {
        System.out.println(param);
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }

    @Action(path = "/test")
    public Data paramTest(Param param, Customer customer) {
        System.out.println(param);
        System.out.println(customer);
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }

    @Action(method = "post", path = "/test")
    public Data postTest(Param param, @Body Customer customer) {
        System.out.println(param);
        System.out.println(customer);
        List<Customer> customerList = customerService.getCustomerList();
        return new Data(customerList);
    }

    @Action(path = "/sql")
    public Data sql() {
        List<Customer> customerList = customerService.getCustomersBySQL();
        return new Data(customerList);
    }

    @Action(path = "/sqlone")
    public Data sqlOne() {
        Customer customerList = customerService.getCustomersById();
        return new Data(customerList);
    }

    @Action(path = "/create")
    public Data create() {
        Customer a = new Customer("a", "xiao a", "1234567890", "a@m.com");
        boolean result = DatabaseHelper.insert(a);
        if (result) {
            return new Data(a);
        } else {
            return new Data(new FailedBean());
        }
    }

    @Action(path = "/failure")
    public Data createFailure() {
        boolean result = customerService.createFailure();
        return new Data(result);
    }

}