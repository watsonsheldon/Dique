package com.dique.dao;

import java.io.Serializable;
import java.util.List;

public interface PagesDataDao <T> extends Serializable {
	public List<T> getAll();
}
