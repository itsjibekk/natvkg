package com.example.natvkg.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_banner_ads")
public class BannerAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String file_path;
}
