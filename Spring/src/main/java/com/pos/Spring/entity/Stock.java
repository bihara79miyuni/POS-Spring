package com.pos.Spring.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        if(this.updatedAt == null) {
            this.updatedAt = LocalDateTime.now();
        }
    }

    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;
}
