package ttps.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Usuario;
import ttps.spring.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usrServ;
	
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usr) {
		//validar si el email existe, etc 
		/** CONSULTA, LA VALIDACION DEL MAIL SE HACE ACÁ o se pide al UsuarioService???**/
		return this.usrServ.crearUsuario(usr);
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<String> getUser(@PathVariable("id")long id, @RequestHeader(name = "token") String token){
	/**En el header enviar token: {idUsuario}+’123456’
		Retorna #200 con los datos del usuario
		especificado, #404 si no se encuentra el usuario y
		#401 en caso de token inválido.**/	
		
		String tokenEsperado = id + "123456";
        if (tokenEsperado != token) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
        }
		
       System.out.println("Obteniendo un usuario con id" + id);
		Optional<Usuario> usuario = usrServ.recuperar(id);
		if(usuario == null) {
			System.out.println("Usuario no encontrado");
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		
		}
		
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	

	
	
	
}
