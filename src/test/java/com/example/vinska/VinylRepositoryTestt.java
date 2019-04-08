package com.example.vinska;

import com.example.vinska.domain.Genre;
import com.example.vinska.domain.Vinyl;
import com.example.vinska.domain.VinylRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VinylRepositoryTestt {

    @Autowired
    private VinylRepository repository;

    @Test
    public void contextLoads() {
        List<Vinyl> vinyls = this.repository.findByArtist("Ozzy");

        assertThat(vinyls).hasSize(1);
        assertThat(vinyls.get(0).getAlbumName()).isEqualTo("Metall");

    }
    @Test
    public void createNewBook() {
        Vinyl vinyl = new Vinyl("Mick", "Specialitet","Metalmania", 1999, 2, 19.90, 200.00, new Genre("Huuhaa"));
        repository.save(vinyl);
        assertThat(vinyl.getId()).isNotNull();
        repository.delete(vinyl);

    }


}
