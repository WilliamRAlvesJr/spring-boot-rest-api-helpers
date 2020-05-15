package springboot.rest.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @author carlos-silva
 * @version : $<br/>
 * : $
 * @since 5/14/20 7:52 PM
 */
public interface BaseCustomRepository<T> {

    Page<T> findAllGeneral(PageRequest pageRequest);

}
