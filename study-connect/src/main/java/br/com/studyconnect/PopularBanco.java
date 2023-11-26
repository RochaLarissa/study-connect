//package br.com.studyconnect;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import br.com.studyconnect.model.Interesse;
//import br.com.studyconnect.model.InteresseUsuario;
//import br.com.studyconnect.model.Usuario;
//import br.com.studyconnect.repository.InteresseRepository;
//import br.com.studyconnect.repository.InteresseUsuarioRepository;
//import br.com.studyconnect.repository.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class PopularBanco implements CommandLineRunner{
//
//	@Autowired
//	UsuarioRepository usuarioRepository;
//
//	@Autowired
//	InteresseUsuarioRepository interesseUsuarioRepository;
//
//	@Autowired
//	InteresseRepository interesseRepository;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Usuario us1 = new Usuario();
//		us1.setEmail("larissa@edu.unifor.com");
//		us1.setNome("Larissa Rocha");
//		us1.setSenha(passwordEncoder.encode("1234"));
//		us1.setPrivilegio("USER");
//		var savedUs1 = usuarioRepository.save(us1);
//
//		Usuario us2 = new Usuario();
//		us2.setEmail("luana@edu.unifor.com");
//		us2.setNome("Luana Sousa");
//		us2.setSenha(passwordEncoder.encode("1234"));
//		us2.setPrivilegio("USER");
//		var savedUs2 = usuarioRepository.save(us2);
//
//		Interesse int1 = new Interesse();
//		int1.setDisciplina("Matemática para Computação");
//		int1.setTipo("Presencial");
//		int1.setTurno("Noite");
//		var savedInt1 = interesseRepository.save(int1);
//
//		Interesse int2 = new Interesse();
//		int2.setDisciplina("Lógica de Programação");
//		int2.setTipo("Presencial");
//		int2.setTurno("Noite");
//		var savedInt2 = interesseRepository.save(int2);
//
//		InteresseUsuario interesseUsuario1 = new InteresseUsuario();
//		interesseUsuario1.setInteresse(savedInt1);
//		interesseUsuario1.setUsuario(savedUs1);
//		interesseUsuarioRepository.save(interesseUsuario1);
//
//		InteresseUsuario interesseUsuario2 = new InteresseUsuario();
//		interesseUsuario2.setInteresse(savedInt2);
//		interesseUsuario2.setUsuario(savedUs2);
//		interesseUsuarioRepository.save(interesseUsuario2);
//
//	}
//
//}
