package com.rtsrms.trade_service.controller;

import com.rtsrms.trade_service.enums.AssetType;
import com.rtsrms.trade_service.enums.TradeStatus;
import com.rtsrms.trade_service.model.Trade;
import com.rtsrms.trade_service.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Trade> getAllTrade(){
        return tradeService.getAllTrade();
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id){
        return tradeService.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Trade> getTradeByUserId(@PathVariable int userId){
        return tradeService.findByUserId(userId);
    }

    @GetMapping("/status")
    public List<Trade> findByStatus(@RequestParam TradeStatus status){
        return tradeService.findByStatus(status);
    }

    @GetMapping("/assets")
        public List<Trade> findByAssetType(@RequestParam AssetType assetType){
            return tradeService.findByAssetType(assetType);
        }

    @GetMapping("/{id}/status")
    public List<Trade> findByUserIdAndStatus(@PathVariable @RequestParam int userId, TradeStatus status){
        return tradeService.findByUserIdAndStatus(userId,status);
    }

    @GetMapping("/{id}/recent")
    public Optional<Trade> findTopByUserIdOrderByCreatedAtDesc(@PathVariable int id){
        return tradeService.findTopByUserIdOrderByCreatedAtDesc(id);
    }
}
