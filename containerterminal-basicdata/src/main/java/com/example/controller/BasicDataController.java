package com.example.controller;

import com.example.common.ResponseResult;
import com.example.entity.BerthPrice;
import com.example.entity.CustomerInfo;
import com.example.entity.YardPrice;
import com.example.service.BasicDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-24 9:40
 * @description: com.example.controller
 */
@RestController
@RequestMapping("/data")
public class BasicDataController {
    @Resource
    private BasicDataService basicDataService;

    @RequestMapping("queryAllCustomer")
    public ResponseResult<List<CustomerInfo>> queryAllCustomer(){
        try {
            List<CustomerInfo> list=basicDataService.queryAllCustomer();
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryCustomerByName{customerName}")
    public ResponseResult<List<CustomerInfo>> queryCustomerByName(String customerName){
        try {
            List<CustomerInfo> list=basicDataService.queryCustomerByName(customerName);
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("yardPrice")
    public ResponseResult<List<YardPrice>> yardPrice(){
        try {
            List<YardPrice> list=basicDataService.yardPrice();
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("berthPrice")
    public ResponseResult<List<BerthPrice>> berthPrice(){
        try {
            List<BerthPrice> list=basicDataService.berthPrice();
            return ResponseResult.build(200,"",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("customerRemoveById{customerId}")
    public ResponseResult customerRemoveById(String customerId){
        try {
            basicDataService.customerRemoveById(customerId);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    /***
     * 根据ID批量删除客户信息
     * @param str
     * @return
     */
    @RequestMapping("removeList")
    public ResponseResult removeList(String str){
        try {
            String[] strings=str.split(",");
            for(String strs:strings) {
                basicDataService.customerRemoveById(strs);
            }
            return ResponseResult.build(200,"",null);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryCustomerById{customerId}")
    public ResponseResult queryCustomerById(String customerId){
        try {
            CustomerInfo customerInfo=basicDataService.queryCustomerById(customerId);
            return ResponseResult.build(200,"",customerInfo);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("updateCustomer")
    public ResponseResult updateCustomer(CustomerInfo customerInfo){
        try {
            basicDataService.updateCustomer(customerInfo);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("deleteYardPriceById{priceId}")
    public ResponseResult deleteYardPriceById(String priceId){
        try {
            basicDataService.deleteYardPriceById(priceId);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("deleteBerthPriceById{priceId}")
    public ResponseResult deleteBerthPriceById(String priceId){
        try {
            basicDataService.deleteBerthPriceById(priceId);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryYardPriceById{priceId}")
    public ResponseResult queryYardPriceById(String priceId){
        try {
           YardPrice yardPrice= basicDataService.queryYardPriceById(priceId);
            return ResponseResult.build(200,"",yardPrice);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("updateYardPrice")
    public ResponseResult updateYardPrice(YardPrice yardPrice){
        System.out.println(yardPrice.toString());
        try {
            basicDataService.updateYardPrice(yardPrice);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("queryBerthPriceById{priceId}")
    public ResponseResult queryBerthPriceById(String priceId){
        try {
            BerthPrice berthPrice=basicDataService.queryBerthPriceById(priceId);
            return ResponseResult.build(200,"",berthPrice);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }

    @RequestMapping("updateBerthPrice")
    public ResponseResult updateBerthPrice(BerthPrice berthPrice){
        try {
            basicDataService.updateBerthPrice(berthPrice);
            return ResponseResult.build(200,"",null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseResult.build(201,"",null);
        }
    }
}
