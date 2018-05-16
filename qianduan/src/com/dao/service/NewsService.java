package com.dao.service;

import java.io.Serializable;
import java.util.List;

import com.dao.bean.News;
import com.dao.bean.User;

public interface NewsService {
	
	boolean addNews(News news);

	List<News> findAll();

	News findNewsById(Serializable id);

	boolean updateNews(News news);

	boolean deleteNews(Serializable id);
	
}
