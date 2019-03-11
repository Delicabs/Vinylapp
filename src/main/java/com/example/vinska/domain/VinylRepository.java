package com.example.vinska.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VinylRepository extends CrudRepository<Vinyl,Long> {
    List<Vinyl> findByArtist(@Param("artist")String artist);
}
