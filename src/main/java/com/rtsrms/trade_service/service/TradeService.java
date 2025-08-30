package com.rtsrms.trade_service.service;

import com.rtsrms.trade_service.enums.AssetType;
import com.rtsrms.trade_service.enums.TradeStatus;
import com.rtsrms.trade_service.model.Trade;
import com.rtsrms.trade_service.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TradeService {

    private final TradeRepository tradeRepository;

    public Trade findById(Long id) {
        return tradeRepository.findById(id).orElse(null);
    }

    public List<Trade> getAllTrade(){
        return tradeRepository.findAll();
    }


    public Trade createNewTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    public List<Trade> findByUserId(int userId) {
        return tradeRepository.findByUserId(userId);
    }


    public List<Trade> findByStatus(TradeStatus status) {
        return tradeRepository.findByStatus(status);
    }

    public Optional<Trade> findTopByUserIdOrderByCreatedAtDesc(int id) {
        return tradeRepository.findTopByUserIdOrderByCreatedAtDesc(id);
    }

    public List<Trade> findByAssetType(AssetType assetType) {
        return tradeRepository.findByAssetType(assetType);
    }


    public List<Trade> findByUserIdAndStatus(int userId, TradeStatus status) {
        return tradeRepository.findByUserIdAndStatus(userId,status);
    }

    public Trade updateStaus(Long id, Trade tradeDetails) {
        Trade trade = tradeRepository.findById(id).orElseThrow(()-> new RuntimeException("Trade not found with id"+id));
        if(tradeDetails.getAssetType()!=null){ trade.setAssetType(tradeDetails.getAssetType());}
        if(tradeDetails.getStatus()!=null){ trade.setStatus(tradeDetails.getStatus());}
        if(trade.getAssetName()!=null){ trade.setAssetName(trade.getAssetName());}
        if(trade.getAmount()!=0){ trade.setAmount(trade.getAmount());}
        return tradeRepository.save(trade);
    }

    public void deleteTrade(Long id) {
    Trade trade = tradeRepository.findById(id).orElseThrow(()-> new RuntimeException("Trade not found with id"+id));
        tradeRepository.delete(trade);
    }
}
