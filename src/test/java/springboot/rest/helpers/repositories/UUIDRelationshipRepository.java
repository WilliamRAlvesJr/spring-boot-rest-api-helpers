package springboot.rest.helpers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import springboot.rest.helpers.entities.UUIDEntity;
import springboot.rest.helpers.entities.UUIDRelationship;
import springboot.rest.repositories.BaseRepository;

import java.util.UUID;

public interface UUIDRelationshipRepository extends BaseRepository<UUIDRelationship, UUID> {

    @Query(" from #{#entityName} s")
    Page<UUIDRelationship> findAllGeneral(PageRequest pageRequest);
}
