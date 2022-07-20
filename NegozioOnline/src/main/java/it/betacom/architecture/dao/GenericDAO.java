package com.gio.architecture.dao;

import java.sql.Connection;

//Abstract Factory
public interface GenericDAO<T> {

	void create(Connection conn, T entity) throws DAOException;
	
	void update(Connection conn, T entity) throws DAOException;

	void delete(Connection conn, long id) throws DAOException;
	
	T findById(Connection conn, long id) throws DAOException;
	
	T[] getAll(Connection conn) throws DAOException;
	
}
