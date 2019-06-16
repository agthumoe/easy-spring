package com.achromex.core.repositores;

import com.achromex.core.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface for generic operations on a repository for a specific entity.
 *
 * @param <T> The entity.
 * @author Aung Thu Moe
 * @see com.achromex.core.models.Model
 * @since 1.1.0
 */
@NoRepositoryBean
public interface CoreRepository<T extends Model> extends JpaRepository<T, Long> {
}
