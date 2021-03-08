package vacina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vacina.dto.request.AplicacaoVacinacaoRequest;
import vacina.dto.response.AplicacaoVacinaResponse;
import vacina.entity.AplicacaoVacina;
import vacina.entity.Usuario;
import vacina.exception.UsuarioInexistenteException;
import vacina.repository.AplicacaoVacinaRepository;
import vacina.repository.UsuarioRepository;

@Service
public class AplicacaoVacinaService {

	@Autowired
	private AplicacaoVacinaRepository aplicacaoVacinaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public AplicacaoVacinaResponse create(AplicacaoVacinacaoRequest aplicacaoVacinacaoRequest) {
		Usuario usuario = this.usuarioRepository.findById(aplicacaoVacinacaoRequest.getIdUsuario())
				.orElseThrow(() -> new UsuarioInexistenteException());

		AplicacaoVacina aplicacaoVacina = new AplicacaoVacina(aplicacaoVacinacaoRequest, usuario);

		AplicacaoVacina aplicacaoVacinaSalva = this.aplicacaoVacinaRepository.save(aplicacaoVacina);

		return new AplicacaoVacinaResponse(aplicacaoVacinaSalva);

	}

}