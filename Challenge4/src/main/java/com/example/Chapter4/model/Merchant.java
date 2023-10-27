package com.example.Chapter4.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Entity
@Accessors(chain = true)
@NoArgsConstructor
@Table(name = "merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    //===Column=====
    private String name;
    private String address;
    private int isOpen;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    //===Column=====

    public void print(){
        System.out.print("Nama: "+name+" | Alamat: "+address);
        if(isOpen == 1){
            System.out.print(" | Status: Buka\n");
        }else System.out.print(" | Status: Tutup\n");
    }
}
