package com.example.vinska.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VinylRepository extends CrudRepository<Vinyl,Long> {
    List<Vinyl> findByArtist(@Param("artist")String artist);

    @Query("SELECT SUM (v.amount) from Vinyl v")
    int getTotalAmount();
    @Query("SELECT SUM (v.price)from Vinyl v")
    int getTotalSpent();
    @Query("SELECT SUM (v.lastSoldPrice) from Vinyl v")
    int getTotalValue();


}
