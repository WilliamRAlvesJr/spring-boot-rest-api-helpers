package springboot.rest.helpers.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.rest.helpers.entities.Actor;
import springboot.rest.helpers.entities.Movie;
import springboot.rest.repositories.BaseRepository;

public interface ActorRepository extends BaseRepository<Actor,Long> {

    @Query(" from #{#entityName} s")
    Page<Actor> findAllGeneral(PageRequest pageRequest);

}
