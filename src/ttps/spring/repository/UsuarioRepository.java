package ttps.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ttps.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	//find by distintos criterios
	Optional<Usuario> findById(Long id);
	Usuario findByUserName(String usuario);
	Usuario findByEmail(String email);
	Usuario findByUsernameAndPassword(String usuario, String password);
	List <Usuario> findByNombre(String nombre);
	boolean existsByEmail(String email);
	
	//Guardar/actualizar y borrar usuarios
	Usuario save(Usuario usr);
	void delete(Usuario usr);
	
	//Especifico del usuario
	
	
	
	
	
	
	
	
}
