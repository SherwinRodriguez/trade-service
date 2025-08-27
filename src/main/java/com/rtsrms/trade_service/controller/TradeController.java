package com.rtsrms.trade_service.controller;

import com.rtsrms.trade_service.model.Trade;
import com.rtsrms.trade_service.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trades")
@RequiredArgsConstructor
public class TradeController {
    @Autowired
    private final TradeService tradeService;

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade){
        return tradeService.createNewTrade(trade);
    }

    @GetMapping
    public Trade getAllTrade(){
        return tradeService.getAllTrade();
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id){
        return tradeService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public Trade getTradeByUserId(@PathVariable int userId){
        return tradeService.findByUserId(userId);
    }
}
