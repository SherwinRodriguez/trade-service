package com.rtsrms.trade_service.service;

import com.rtsrms.trade_service.model.Trade;
import com.rtsrms.trade_service.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeService {
    @Autowired

    private final TradeRepository tradeRepository;

    public Trade findById(Long id) {
        return tradeRepository.findById(id).orElse(null);
    }

    public Trade getAllTrade(){
        return tradeRepository.findAll().stream().findFirst().orElse(null);
    }


    public Trade createNewTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public Trade findByUserId(int userId) {
        return tradeRepository.findByUserId(userId);
    }
}
