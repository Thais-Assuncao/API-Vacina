package vacina.dto.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import vacina.entity.Usuario;

@Data
@NoArgsConstructor
public class UsuarioResponse {

	public UsuarioResponse(Usuario usuario) {
		this.setId(usuario.getId());
		this.setCpf(usuario.getCpf());
		this.setDataNascimento(usuario.getDataNascimento());
		this.setEmail(usuario.getEmail());
		this.setNome(usuario.getNome());
	}

	private Long id;

	private String cpf;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;

	private String email;

	private String nome;

}
