package vacina.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import vacina.dto.request.UsuarioRequest;
import vacina.dto.response.UsuarioResponse;
import vacina.service.UsuarioService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponse post(@Valid @RequestBody UsuarioRequest usuarioRequest) {
		return this.usuarioService.create(usuarioRequest);
	}

}
