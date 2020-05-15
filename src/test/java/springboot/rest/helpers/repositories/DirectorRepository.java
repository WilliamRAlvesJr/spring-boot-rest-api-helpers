package springboot.rest.helpers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import springboot.rest.helpers.entities.Category;
import springboot.rest.helpers.entities.Director;
import springboot.rest.repositories.BaseRepository;

public interface DirectorRepository extends BaseRepository<Director,Long> {

    @Query(" from #{#entityName} s")
    Page<Director> findAllGeneral(PageRequest pageRequest);
}
