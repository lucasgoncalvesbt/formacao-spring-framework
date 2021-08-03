package br.com.alura.forum.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		Curso html = new Curso();
		html.setNome(nomeCurso);
		html.setCategoria("Programacao");
		em.persist(html);
		 
		
		Curso curso = repository.findByNome(nomeCurso);
		assertNotNull(curso);
		assertEquals(nomeCurso, curso.getNome());
	}

}
