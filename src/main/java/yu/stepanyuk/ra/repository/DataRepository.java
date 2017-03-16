package yu.stepanyuk.ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yu.stepanyuk.ra.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Long>{

}
