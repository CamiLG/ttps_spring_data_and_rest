package ttps.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.Usuario;
import ttps.spring.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioRepository usrRepo;
	
	public boolean existsByEmail(String email) {
		return usrRepo.existsByEmail(email);
	}
	
	public Usuario crearUsuario(Usuario user) {
		 // validaciones
		 return usrRepo.save(user);
	}
	
	public Optional <Usuario> recuperar(Long id) {
		/** CONSULTA, me da error si le pongo solo Usuario al tipo de retorno, porque el metodo find retorna un Optional**/
		return usrRepo.findById(id);
	}
}
