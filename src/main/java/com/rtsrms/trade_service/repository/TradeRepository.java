package com.rtsrms.trade_service.repository;

import com.rtsrms.trade_service.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TradeRepository extends JpaRepository<Trade,Long> {
    Trade findByUserId(int userId);
}
