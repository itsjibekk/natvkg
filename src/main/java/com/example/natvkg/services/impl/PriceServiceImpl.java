package com.example.natvkg.services.impl;

import com.example.natvkg.entities.Price;
import com.example.natvkg.repositories.ChannelRepo;
import com.example.natvkg.repositories.PriceRepo;
import com.example.natvkg.services.PriceService;
import com.example.natvkg.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    private final ChannelRepo channelRepo;

    @Override
    public int save(int pricePerSymbol, Long id) {
        Price price = new Price();
        price.setChannel(channelRepo.getById(id));
        price.setPrice_per_symbol(pricePerSymbol);
        price.setStart_date(new Date());
        price.setEnd_date(DateUtil.getInstance().getEndDate());
        priceRepo.save(price);
        return pricePerSymbol;
    }
}
