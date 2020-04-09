package com.cartoes.api.repositories;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.cartoes.api.entities.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository clienteRepository;
	
	Cliente clienteTeste;
	
	private ClienteRepositoryTest() throws ParseException {
		
		clienteTeste = new Cliente();
		
		clienteTeste.setNome("Nome Teste");
		clienteTeste.setCpf("05887098082");
		clienteTeste.setUf("CE");
		clienteTeste.setDataAtualizacao(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2020"));
		
	}
	
	@Before
	public void setUp() throws Exception {
		clienteRepository.save(clienteTeste);
	}
	
	@After
	public void tearDown() throws Exception {
		clienteRepository.deleteAll();
	}
	
	@Test
	public void testFindById() {
		
		Cliente cliente = clienteRepository.findById(clienteTeste.getId()).get();
		assertEquals(cliente.getId(), clienteTeste.getId());
		
	}
	
	@Test
	public void testFindByCpf() {
		
		Cliente cliente = clienteRepository.findByCpf(clienteTeste.getCpf());
		assertEquals(cliente.getCpf(), clienteTeste.getCpf());
		
	}
	
	@Test
	public void testFindByUfAndDataAtualizacao() {
		
		List<Cliente> lstCliente = clienteRepository.findByUfAndDataAtualizacao(
				clienteTeste.getUf(),
				clienteTeste.getDataAtualizacao());
		
		if (lstCliente.size() != 1) {
			Assert.fail();
		}
		
		Cliente cliente = lstCliente.get(0);
		
		Assert.assertTrue(
				cliente.getUf().equals(clienteTeste.getUf()) &&
				cliente.getDataAtualizacao().equals(cliente.getDataAtualizacao()));
				
	}

}
