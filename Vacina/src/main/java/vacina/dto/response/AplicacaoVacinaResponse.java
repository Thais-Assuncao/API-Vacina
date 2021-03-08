package vacina.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import vacina.entity.AplicacaoVacina;

@Data
@NoArgsConstructor
public class AplicacaoVacinaResponse {

	public AplicacaoVacinaResponse(AplicacaoVacina aplicacaoVacina) {
		this.setDataDaVacina(aplicacaoVacina.getDataDaVacina());
		this.setId(aplicacaoVacina.getId());
		this.setNomeVacina(aplicacaoVacina.getNomeDaVacina());

		UsuarioResponse usuarioResponse = new UsuarioResponse(aplicacaoVacina.getUsuario());

		this.setUsuario(usuarioResponse);
	}

	private Long id;

	private String nomeVacina;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataDaVacina;

	private UsuarioResponse usuario;

}
