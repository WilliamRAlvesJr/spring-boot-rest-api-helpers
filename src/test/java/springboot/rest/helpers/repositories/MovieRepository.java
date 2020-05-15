package springboot.rest.helpers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import springboot.rest.helpers.entities.Actor;
import springboot.rest.helpers.entities.Movie;
import springboot.rest.repositories.BaseRepository;

public interface MovieRepository extends BaseRepository<Movie,Long> {

    @Query(" from #{#entityName} s")
    Page<Movie> findAllGeneral(PageRequest pageRequest);
}
