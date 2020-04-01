package com.example.service;

import com.example.entity.BerthPrice;
import com.example.entity.CustomerInfo;
import com.example.entity.YardPrice;
import com.example.mapper.BasicDataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 9:41
 * @description: com.example.service
 */
@Service
public class BasicDataService implements BasicDataMapper {
    @Resource
    private BasicDataMapper basicDataMapper;

    public List<CustomerInfo> queryAllCustomer() {
        return basicDataMapper.queryAllCustomer();
    }

    public List<CustomerInfo> queryCustomerByName(String customerName) {
        return basicDataMapper.queryCustomerByName(customerName);
    }

    public List<YardPrice> yardPrice() {
        return basicDataMapper.yardPrice();
    }

    public List<BerthPrice> berthPrice() {
        return basicDataMapper.berthPrice();
    }


    public void customerRemoveById(String customerId) {
        basicDataMapper.customerRemoveById(customerId);
    }

    public CustomerInfo queryCustomerById(String customerId) {
        return basicDataMapper.queryCustomerById(customerId);
    }

    public void updateCustomer(CustomerInfo customerInfo) {
        basicDataMapper.updateCustomer(customerInfo);
    }


    public void deleteYardPriceById(String priceId) {
        basicDataMapper.deleteYardPriceById(priceId);
    }

    public void deleteBerthPriceById(String priceId) {
        basicDataMapper.deleteBerthPriceById(priceId);
    }

    public YardPrice queryYardPriceById(String priceId) {
        YardPrice yardPrice=basicDataMapper.queryYardPriceById(priceId);
        return yardPrice;
    }

    public void updateYardPrice(YardPrice yardPrice) {
        basicDataMapper.updateYardPrice(yardPrice);
    }

    public BerthPrice queryBerthPriceById(String priceId) {
        return basicDataMapper.queryBerthPriceById(priceId);
    }

    public void updateBerthPrice(BerthPrice berthPrice) {
        basicDataMapper.updateBerthPrice(berthPrice);
    }
}
