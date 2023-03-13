package com.example.natvkg.repositories;

import com.example.natvkg.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    @Query(value = "select price_per_symbol from tb_prices where channel_id = :id",nativeQuery = true)
    Integer findPriceByChannel_id(Long id);

    @Query(value = "select max(discount) from tb_discounts where channel_id = :channelId and discount_days <= :daysCount",nativeQuery = true)
    int findByDaysAndChannelId(int daysCount, Long channelId);
}
