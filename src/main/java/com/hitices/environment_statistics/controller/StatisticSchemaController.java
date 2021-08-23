package com.hitices.environment_statistics.controller;

import com.hitices.environment_statistics.bean.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistic/schema")
public class StatisticSchemaController extends ControllerBase
{
    @PostMapping(value = "/get")
    public ActionResult<SchemaBean> get(@RequestBody IdBean id)
    {
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }

    @PostMapping(value = "/remove")
    public ActionResult<SchemaBean> remove(@RequestBody IdBean id)
    {
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }

    @PostMapping(value = "/add")
    public ActionResult<String> add(@RequestBody SchemaBean schema)
    {
//        Optional<Wallet> wallet = walletService.addWallet(registerBean);
//        if(wallet.isPresent()){
//            return MResponse.successMResponse().data(wallet.get().getWalletid());
//        }
        return Failed();
    }
}
