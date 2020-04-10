package com.cartoes.api.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cartoes.api.entities.Cliente;
import com.cartoes.api.repositories.ClienteRepository;
import com.cartoes.api.utils.ConsistenciaException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceTest {

	@MockBean
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void testBuscarPorIdExistente() throws ConsistenciaException {	
		
		BDDMockito.given(clienteRepository.findById(Mockito.anyInt()))
			.willReturn(Optional.of(new Cliente()));
		
		Optional<Cliente> resultado = clienteService.buscarPorId(1);
		
		assertTrue(resultado.isPresent());
		
	}
	
	@Test(expected = ConsistenciaException.class)
	public void testBuscarPorIdNaoExistente() throws ConsistenciaException {	
		
		BDDMockito.given(clienteRepository.findById(Mockito.anyInt()))
			.willReturn(Optional.empty());
		
		clienteService.buscarPorId(1);
		
	}
	
	@Test
	public void testBuscarPorCpfExistente() throws ConsistenciaException {	
		
		BDDMockito.given(clienteRepository.findByCpf(Mockito.anyString()))
			.willReturn(new Cliente());
		
		Optional<Cliente> resultado = clienteService.buscarPorCpf("12312312312");
		
		assertTrue(resultado.isPresent());
		
	}
	
	@Test(expected = ConsistenciaException.class)
	public void testBuscarPorCpfNaoExistente() throws ConsistenciaException {	
		
		BDDMockito.given(clienteRepository.findByCpf(Mockito.anyString()))
		.willReturn(null);
		
		clienteService.buscarPorCpf("12312312312");
		
	}
	
	@Test
	public void testSalvarComSucesso() throws ConsistenciaException {	
		
		BDDMockito.given(clienteRepository.save(Mockito.any(Cliente.class)))
			.willReturn(new Cliente());
		
		Cliente resultado = clienteService.salvar(new Cliente());
		
		assertNotNull(resultado);
		
	}
	
	@Test
	public void testSalvarIdNaoEncontrado() {	
		
		BDDMockito.given(clienteRepository.findById(Mockito.anyInt()))
		.willReturn(Optional.empty());
		
		Cliente c = new Cliente();
		c.setId(1);
		
		try {
			clienteService.salvar(c);
			fail(); // Se não voltar exception, é pq o teste falhou
		} catch (ConsistenciaException e) { }

	}
	
	@Test
	public void testSalvarCpfDuplicado() {	
		
		BDDMockito.given(clienteRepository.save(Mockito.any(Cliente.class)))
		.willThrow(new DataIntegrityViolationException(""));
		
		try {
			clienteService.salvar(new Cliente());
			fail(); // Se não voltar exception, é pq o teste falhou
		} catch (Exception e) { }

	}
	
}
