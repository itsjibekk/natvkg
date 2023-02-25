package com.example.natvkg.entities.repositories;

import com.example.natvkg.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepo extends JpaRepository<Channel,Long> {
}
