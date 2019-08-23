package gt.com.initwebapps.initwebapps_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.com.initwebapps.initwebapps_base.model.TsEstado;

@Repository
public interface TsEstadoRepository extends JpaRepository<TsEstado, Long> {
}