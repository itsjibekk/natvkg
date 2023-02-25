package com.example.natvkg.entities.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_text_ads")
public class TextAd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int symbol_count;

}
