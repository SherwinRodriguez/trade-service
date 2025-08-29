package com.rtsrms.trade_service.repository;

import com.rtsrms.trade_service.enums.AssetType;
import com.rtsrms.trade_service.enums.TradeStatus;
import com.rtsrms.trade_service.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TradeRepository extends JpaRepository<Trade,Long> {
    List<Trade> findByUserId(int userId);

    List<Trade> findByStatus(TradeStatus status);

    Optional<Trade> findTopByUserIdOrderByCreatedAtDesc(int userId);

    List<Trade> findByAssetType(AssetType assetType);

    List<Trade> findByUserIdAndStatus(int userId, TradeStatus status);

}