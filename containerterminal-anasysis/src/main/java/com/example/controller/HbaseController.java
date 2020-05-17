package com.example.controller;

import com.example.common.ResponseResult;
import com.example.entity.Ship;
import com.example.entity.ShipTable;
import com.example.service.HbaseService;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 魏秦
 * @Date: 2020-03-27 13:20
 * @description: com.example.controller
 */
@RestController
@RequestMapping("anasysis")
@CrossOrigin
public class HbaseController {
    @RequestMapping("queryById{id}")
    public ResponseResult<List<Ship>> queryById(String id) throws Exception {
        List<Ship> list = new ArrayList<Ship>();
        ResultScanner rs;
        rs = HbaseService.show(id);
        for (Result value : rs) {
            Ship ship = new Ship();
            ship.setId(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.id)));
            ship.setUnit(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.unit)));
            ship.setUnload(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.unload)));
            ship.setLoad(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.load)));
            ship.setVessel(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.vessel)));
            ship.setGeo(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.geo)));
            ship.setTime18(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time18))));
            ship.setTime17(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time17))));
            ship.setTime16(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time16))));
            ship.setTime15(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time15))));
            ship.setTime14(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time14))));
            ship.setTime13(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time13))));
            ship.setTime12(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time12))));
            ship.setTime11(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time11))));
            ship.setTime10(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time10))));
            ship.setTime09(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time09))));
            ship.setTime08(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time08))));
            ship.setTime07(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time07))));
            list.add(ship);
        }
        return ResponseResult.build(200, "", list);
    }

    @RequestMapping("queryAll")
    public ResponseResult<List<Ship>> queryAll() throws Exception {
        List<Ship> list = new ArrayList<>();
        ResultScanner rs;
        rs = HbaseService.showAll();
        for (Result value : rs) {
            Ship ship = new Ship();
            ship.setId(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.id)));
            ship.setUnit(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.unit)));
            ship.setUnload(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.unload)));
            ship.setLoad(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.load)));
            ship.setVessel(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.vessel)));
            ship.setGeo(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.geo)));
            ship.setTime18(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time18))));
            ship.setTime17(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time17))));
            ship.setTime16(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time16))));
            ship.setTime15(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time15))));
            ship.setTime14(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time14))));
            ship.setTime13(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time13))));
            ship.setTime12(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time12))));
            ship.setTime11(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time11))));
            ship.setTime10(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time10))));
            ship.setTime09(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time09))));
            ship.setTime08(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time08))));
            ship.setTime07(Double.valueOf(Bytes.toString(value.getValue(ShipTable.family[0], ShipTable.time07))));
            list.add(ship);

        }
        return ResponseResult.build(200, "", list);
    }
}
