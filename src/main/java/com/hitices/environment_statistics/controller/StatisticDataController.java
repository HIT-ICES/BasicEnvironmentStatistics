package com.hitices.environment_statistics.controller;

import com.hitices.environment_statistics.bean.*;
import com.hitices.environment_statistics.entity.Schema;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic/data")
public class StatisticDataController extends ControllerBase
{

    @PostMapping(value = "/get")
    public ActionResult<DatumBean> get(@RequestBody IdBean id){
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }
    @PostMapping(value = "/remove")
    public ActionResult<Integer> remove(@RequestBody BatchRemoveBean ids){
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }
    @PostMapping(value = "/insert")
    public ActionResult<Integer> insert(@RequestBody BatchInsertBean data){
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }
    @PostMapping(value = "/select")
    public ActionResult<String[]> select(@RequestBody SelectBean filter){
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }
}
