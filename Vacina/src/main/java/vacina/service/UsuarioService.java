package vacina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import vacina.dto.request.UsuarioRequest;
import vacina.dto.response.UsuarioResponse;
import vacina.entity.Usuario;
import vacina.exception.CPFInvalidoException;
import vacina.exception.CPFJaExistenteException;
import vacina.exception.EmailJaExistenteException;
import vacina.repository.UsuarioRepository;

@Service
public class UsuarioService {


	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioResponse create(UsuarioRequest usuarioRequest) {
		this.validaCPF(usuarioRequest.getCpf());
		Usuario usuario = new Usuario(usuarioRequest);
		try {
			Usuario usuarioCriado = this.usuarioRepository.save(usuario);
			return new UsuarioResponse(usuarioCriado);
		} catch (DataIntegrityViolationException e) {

			if (this.usuarioRepository.findByEmail(usuarioRequest.getEmail()).isPresent()) {
				throw new EmailJaExistenteException();
			} else if (this.usuarioRepository.findByCpf(usuarioRequest.getCpf()).isPresent()) {
				throw new CPFJaExistenteException();
			} else {
				throw e;
			}
		}
	}
	public void validaCPF(String cpf) {
		CPFValidator cpfValidator = new CPFValidator(); 
		try {
			cpfValidator.assertValid(cpf);
		} catch (InvalidStateException e) {
			throw new CPFInvalidoException();	
		}
		
		
	}



}



