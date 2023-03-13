package com.example.natvkg.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_channels")
public class Channel {
    @Id
    @GeneratedValue
    @JsonProperty("id")
    Long id;
    String channel_name;
    @JsonFormat(pattern = "dd.MM.yyyy")
    Date created_date;
    String logo_path;
    boolean active;
    @PrePersist
    public void prePersist() {
        active = true;
    }

}
