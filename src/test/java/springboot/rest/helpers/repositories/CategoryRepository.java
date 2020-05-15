package springboot.rest.helpers.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import springboot.rest.helpers.entities.Actor;
import springboot.rest.helpers.entities.Category;
import springboot.rest.repositories.BaseRepository;

public interface CategoryRepository extends BaseRepository<Category, Long> {

    @Query(" from #{#entityName} s")
    Page<Category> findAllGeneral(PageRequest pageRequest);
}
