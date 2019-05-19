package com.curso.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.curso.boot.web.controller.HomeController;

public class HomeTests {
	
	HomeController homeController = null;
	
	@Before
	public void steUp() {
		
		this.homeController = new HomeController();
		
	}
	
	@Test
	public void VerificandoODiretorioFinalDaPagHome() {
		
		assertEquals("quando chamado o metodo home, o mesmo deve retornar o url da pagina /home", "/home", this.homeController.home());
		
	}

}
