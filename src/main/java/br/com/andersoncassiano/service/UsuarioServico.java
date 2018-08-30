package br.com.andersoncassiano.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.andersoncassiano.domain.Mailer;
import br.com.andersoncassiano.domain.Usuario;

@Service
public class UsuarioServico {
	private Usuario usuario;
	
	@Autowired //Ao instanciar UsuarioServico, o mailer ser� instanciado junto
	private Mailer mailer;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void lembrarSenhaPorEmail() {
		//O banco de dados poderia ser acessado aqui para recuperar a senha
		mailer.setDestinatario(usuario.getEmail());
		mailer.setMensagem("A senha do usu�rio " + usuario.getLogin() + " � xx");
		mailer.enviarEmail();
	}
}
