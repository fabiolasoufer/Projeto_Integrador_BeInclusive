package org.beinclusive.beinclusive.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.beinclusive.beinclusive.model.Usuario;
import org.beinclusive.beinclusive.model.UsuarioLogin;
import org.beinclusive.beinclusive.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService 
{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario usuario) {
		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

		usuario.setSenha(criptografarSenha(usuario.getSenha()));

		return Optional.of(usuarioRepository.save(usuario));
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
        if (usuarioRepository.findById(usuario.getId()).isPresent()) {
            Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());
            if (buscaUsuario.isPresent()) {
                if (buscaUsuario.get().getId() != usuario.getId())
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
            }
            usuario.setSenha(criptografarSenha(usuario.getSenha()));
            return Optional.of(usuarioRepository.save(usuario));
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
    }
	
	public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> userLogin) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(userLogin.get().getEmail());
        if (usuario.isPresent()) {
            if (compararSenhas(userLogin.get().getSenha(), usuario.get().getSenha())) {
                userLogin.get().setId(usuario.get().getId());
                userLogin.get().setNome(usuario.get().getNome());
                userLogin.get().setFoto(usuario.get().getFoto());
                userLogin.get().setToken(generatorBasicToken(userLogin.get().getEmail(), userLogin.get().getSenha()));
                userLogin.get().setSenha(usuario.get().getSenha());
                userLogin.get().setCategoria(usuario.get().getCategoria());
                return userLogin;
            }
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos", null);
    }

	private String criptografarSenha(String senha) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(senha);

		return senhaEncoder;
	}

	private boolean compararSenhas(String senha, String senha2) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(senha, senha2);
	}

	private String generatorBasicToken(String email, String password) {
        String structure = email + ":" + password;
        byte[] structureBase64 = Base64.encodeBase64(structure.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(structureBase64);
    }
}
