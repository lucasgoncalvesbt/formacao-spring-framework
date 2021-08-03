package br.com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.inteceptor.InteceptadorDeAcessos;
import br.com.alura.mvc.mudi.inteceptor.InteceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("acessos")
public class AcessosRest {
	
	@GetMapping
	public List<Acesso> getAcessos() {
		return InteceptadorDeAcessos.acessos;
	}
}
