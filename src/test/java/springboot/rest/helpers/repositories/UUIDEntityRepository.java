package springboot.rest.helpers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import springboot.rest.helpers.entities.Director;
import springboot.rest.helpers.entities.Movie;
import springboot.rest.helpers.entities.UUIDEntity;
import springboot.rest.repositories.BaseRepository;

import java.util.UUID;

public interface UUIDEntityRepository extends BaseRepository<UUIDEntity, UUID> {

    @Query(" from #{#entityName} s")
    Page<UUIDEntity> findAllGeneral(PageRequest pageRequest);
}
