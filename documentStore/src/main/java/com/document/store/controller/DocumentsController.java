package com.document.store.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.document.store.DocumentConstants;
import com.document.store.model.DocumentStore;
import com.document.store.service.DocumentStoreService;

@RestController
public class DocumentsController {

	@Autowired
	private DocumentStoreService documentStoreService;
	
	@RequestMapping(value = "/checkdocumentStore")
	public String testMapping() {
		return DocumentConstants.RESTAPI_MESSAGE;
	}
	
	@RequestMapping("/documentStore")
	public List<DocumentStore> getAllDocuments() {
		return documentStoreService.getAllDocuments();
	}

	@RequestMapping("/documentStore/{id}")
	public Optional<DocumentStore> getDocumentStore(@PathVariable String id) {
		return documentStoreService.getDocumentStore(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/documentStore")
	public void addDocumentStore(@RequestBody DocumentStore documentStore) {
		documentStoreService.addDocumentStore(documentStore);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/documentStore/{id}")
	public void updateDocumentStore(@RequestBody DocumentStore documentStore, @PathVariable String id) {
		documentStoreService.updateDocumentStore(id, documentStore);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/documentStore/{id}")
	public void deleteDocumentStore(@PathVariable String id) {
		documentStoreService.deleteDocumentStore(id);
	}

	
}
