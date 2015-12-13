package model;

import java.util.HashMap;

import algorithms.search.Searchable;

public class SearchableDB<T> {
	private HashMap<String,Searchable<T>> searchableDB;

	public SearchableDB() {
		searchableDB= new HashMap<String,Searchable<T>>();
	}

	public HashMap<String, Searchable<T>> getSearchableDB() {
		return searchableDB;
	}

	public void addSearchable(String name,Searchable<T> searchable) {
		this.searchableDB.put(name, searchable);
	}
	
	public Searchable<T> getSearchable(String name) {
		return this.searchableDB.get(name);
	}
}
