package com.example.natvkg.repositories;

import com.example.natvkg.entities.TextAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextAdRepo extends JpaRepository<TextAd,Long> {

}
