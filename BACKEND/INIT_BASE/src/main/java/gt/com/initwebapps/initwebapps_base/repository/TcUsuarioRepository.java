package gt.com.initwebapps.initwebapps_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.com.initwebapps.initwebapps_base.model.TcUsuario;
import gt.com.initwebapps.initwebapps_base.model.TsEstado;

/**
 * TcUsuarioRepository
 */

 @Repository
public interface TcUsuarioRepository extends JpaRepository<TcUsuario, Long> {
    TsEstado findByTsEstadoId(Long id);
}