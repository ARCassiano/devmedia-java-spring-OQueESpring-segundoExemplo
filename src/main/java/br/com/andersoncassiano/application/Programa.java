package br.com.andersoncassiano.application;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.andersoncassiano.domain.Usuario;
import br.com.andersoncassiano.service.UsuarioServico;

@Configuration
@ComponentScan("br.com.andersoncassiano")
public class Programa {
	public static void main(String[] args) {
		Scanner lerDados = new Scanner(System.in);
		Usuario usuario = new Usuario("Eduardo", "anderson@exemplo.com", "andersonRC");
	
		System.out.println("Deseja recuperar a senha (S/N)?");
		String resposta = lerDados.nextLine();
		
		if(resposta.equalsIgnoreCase("S")) {
			ApplicationContext context = new AnnotationConfigApplicationContext(Programa.class);
			UsuarioServico servico = context.getBean(UsuarioServico.class);
			
			servico.setUsuario(usuario);
			servico.lembrarSenhaPorEmail();
		}
	}
}
