package com.document.store;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.document.store.controller.DocumentsController;
import com.document.store.model.DocumentStore;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private DocumentsController controller;

	@Test
	public void contexLoads() throws Exception {
		//Spring interprets the @Autowired annotation, and the controller is injected before the test methods are run. 
		assertThat(controller).isNull();
		//testDocumentStore();
	}
	
	void testDocumentStore() {
		
		//act
		String response= controller.testMapping();
		assertEquals(DocumentConstants.RESTAPI_MESSAGE, response);
		DocumentStore  documentStore = new DocumentStore("Oren","Oren","Backend Software enginner");
		controller.addDocumentStore(documentStore);
		Optional<DocumentStore> responseGet = controller.getDocumentStore(documentStore.getId());
		assertEquals(DocumentConstants.RESTAPI_MESSAGE, responseGet.get().getId());
		
		
	}
}