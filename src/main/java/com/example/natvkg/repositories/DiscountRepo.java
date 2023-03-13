package com.example.natvkg.repositories;

import com.example.natvkg.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {
    List<Discount> findAllByChannel_Id(Long id);

    @Query(value = "select max(discount) from tb_discounts where channel_id = :id and discount_days <= :daysCount",nativeQuery = true)
    Integer findDiscountByChannelId(int daysCount,Long id);
}
