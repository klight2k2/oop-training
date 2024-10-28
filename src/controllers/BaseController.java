package controllers;

import model.Book;

public abstract class BaseController<T> {
	public abstract T search(String searchKey);
	public abstract boolean remove(int id);
	public abstract void add(T obj);
}
