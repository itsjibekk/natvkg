package com.example.natvkg.repositories;

import com.example.natvkg.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepo extends JpaRepository<Channel,Long> {

    Channel getById(Long id);
    @Query(value = "select * from tb_channels where active = true order by channel_name",nativeQuery = true)
    List<Channel> getAll();

}
