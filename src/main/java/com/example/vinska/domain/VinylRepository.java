package com.example.vinska.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VinylRepository extends CrudRepository<Vinyl,Long> {
    List<Vinyl> findByArtist(@Param("artist")String artist);


    @Query("SELECT SUM (v.amount) from Vinyl v where  v.amount IS NOT NULL")
    Integer getTotalAmount();
    @Query("SELECT SUM (v.price)from Vinyl v")
    Double getTotalSpent();
    @Query("SELECT SUM (v.lastSoldPrice) from Vinyl v")
    Double getTotalValue();


}
