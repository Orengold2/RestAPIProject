package com.document.store;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.document.store.model.DocumentStore;
import com.document.store.service.DocumentStoreService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentStoreApplicationTests {

	@MockBean
	private DocumentStoreService service;
	
	@Test
	public void contextLoads() {
	//1. Init Test 
	//Act
	List<DocumentStore> documents= service.getAllDocuments();
	assertEquals(0L,documents.size());
	
	//2. test adding documents
	//Act
	DocumentStore documentStore1 = new DocumentStore("Or","Or","Java Team Leader");
	service.addDocumentStore(documentStore1);
	DocumentStore documentStore= new DocumentStore("Tal","Tal","Java Team Leader");
	service.addDocumentStore(documentStore);
	documents= service.getAllDocuments();
	assertThat(documents.size()>0);
	//3.test update
	documentStore.setName("Tal Updated");
	documentStore.setProfession("Updated Java Team Leader");
	service.updateDocumentStore("Tal", documentStore);
	DocumentStore updatedDoc =  service.getDocumentStore("Tal").get();
//	assertThat(updatedDoc.getProfession().contains("updated"));

	   
	}
	

}
