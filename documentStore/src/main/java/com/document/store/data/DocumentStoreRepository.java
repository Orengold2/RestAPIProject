package com.document.store.data;

import org.springframework.data.repository.CrudRepository;

import com.document.store.model.DocumentStore;

public interface DocumentStoreRepository extends CrudRepository<DocumentStore, String> {

}
