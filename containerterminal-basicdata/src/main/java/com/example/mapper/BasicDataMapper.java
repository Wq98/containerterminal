package com.example.mapper;

import com.example.entity.BerthPrice;
import com.example.entity.CustomerInfo;
import com.example.entity.YardPrice;

import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 9:40
 * @description: com.example.mapper
 */
public interface BasicDataMapper {
    /***
     * 查询所有客户基础数据
     * @return
     */
    List<CustomerInfo> queryAllCustomer();

    /***
     * 根据客户名称模糊查询客户信息
     * @param customerName
     * @return
     */
    List<CustomerInfo> queryCustomerByName(String customerName);

    /***
     * 查询堆场收费标准
     * @return
     */
    List<YardPrice> yardPrice();

    /***
     * 查询泊船收费标准
     * @return
     */
    List<BerthPrice> berthPrice();

    /***
     * 根据客户ID删除客户信息
     * @param customerId
     */
    void customerRemoveById(String customerId);

    /***
     * 根据客户ID查询客户信息
     * @param customerId
     * @return
     */
    CustomerInfo queryCustomerById(String customerId);

    /***
     * 修改客户信息
     * @param customerInfo
     */
    void updateCustomer(CustomerInfo customerInfo);


    /***
     * 根据价格ID删除堆场价格标准信息
     * @param priceId
     */
    void deleteYardPriceById(String priceId);

    /***
     * 根据价格ID删除泊船价格标准信息
     * @param priceId
     */
    void deleteBerthPriceById(String priceId);

    /***
     * 根据堆场价格ID查询信息
     * @param priceId
     */
    YardPrice queryYardPriceById(String priceId);

    /***
     * 根据价格ID修改堆场价格信息
     * @param yardPrice
     */
    void updateYardPrice(YardPrice yardPrice);

    /***
     * 根据泊船价格ID查询信息
     * @param priceId
     */
    BerthPrice queryBerthPriceById(String priceId);

    /***
     * 根据价格ID修改泊船价格信息
     * @param berthPrice
     */
    void updateBerthPrice(BerthPrice berthPrice);
}
