package com.document.store.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.document.store.data.DocumentStoreRepository;
import com.document.store.model.DocumentStore;


@Service
public class DocumentStoreService {

//	List<DocumentStore> documents = new ArrayList<>(  Arrays.asList(
//			new DocumentStore("Tali","Tali","MNKL"),
//			new DocumentStore("Oren","Oren","Oren Profession")
//			));

	@Autowired
	private DocumentStoreRepository documentStoreRepository;
	
	@Retryable(
		      value = { TimeoutException.class }, 
		      maxAttempts = 5,
		      stateful = true,
		      backoff = @Backoff(delay = 2000))
	public List<DocumentStore> getAllDocuments(){
		List<DocumentStore> documents = new ArrayList<>();
		documentStoreRepository.findAll().forEach(documents::add);
		return documents;
	}
	
	@Retryable(
		      value = { TimeoutException.class }, 
		      stateful = true,
		      maxAttempts = 5,
		      backoff = @Backoff(delay = 2000))
	public Optional<DocumentStore> getDocumentStore(String id) {
		return documentStoreRepository.findById(id);
	}
	
	@Retryable(
		      value = { TimeoutException.class }, 
		      maxAttempts = 5,
		      stateful = true,
		      backoff = @Backoff(delay = 2000))
	public void addDocumentStore(DocumentStore documentStore) {
		documentStoreRepository.save (documentStore);
	}

	@Retryable(
		      value = { TimeoutException.class }, 
		      maxAttempts = 5,
		      stateful = true,
		      backoff = @Backoff(delay = 2000))
	public void updateDocumentStore(String id, DocumentStore documentStore) {
		documentStoreRepository.save (documentStore);
		
	}

	@Retryable(
		      value = { TimeoutException.class }, 
		      maxAttempts = 5,
		      stateful = true,
		      backoff = @Backoff(delay = 2000))
	public void deleteDocumentStore(String id) {
		documentStoreRepository.deleteById(id);
	}

}
