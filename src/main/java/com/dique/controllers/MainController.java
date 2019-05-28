package com.dique.controllers;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dique.dao.PagesDataDaoImpl;
import com.dique.entities.PagesData;
import com.dique.repositories.PagesDataRepository;
import com.dique.utilities.DateFormatter;


@Controller
public class MainController {

	@Autowired
	PagesDataRepository pagesDataRepository;

	@PersistenceContext
	EntityManager entityManager;

	PagesDataDaoImpl dao;

	@Autowired
	DateFormatter dateFormatter;

	@PostConstruct
	public void dev_init() {
		dao = new PagesDataDaoImpl(entityManager);

		PagesData record01 = new PagesData();
		record01.setTitle("Web開設しました");
		record01.setDate(201812211935L);
		record01.setTag("その他");
		record01.setLink("/pages/category/other/201812/201812172100");
		pagesDataRepository.saveAndFlush(record01);

		PagesData record02 = new PagesData();
		record02.setTitle("SpringBootを使用したWeb開発");
		record02.setDate(201812222000L);
		record02.setTag("Web開発");
		record02.setLink("/pages/category/web/201812/201812222000");
		pagesDataRepository.saveAndFlush(record02);

		PagesData record03= new PagesData();
		record03.setTitle("PCゲームのゲームエンジン");
		record03.setDate(201812222100L);
		record03.setTag("PCゲーム開発");
		record03.setLink("/pages/category/pcgame/201812/201812222100");
		pagesDataRepository.saveAndFlush(record03);
	}

	@RequestMapping(value="/main", method=RequestMethod.GET)
	public ModelAndView main(ModelAndView mav) {
		mav.setViewName("main");
		Iterable<PagesData> pages_data_list = dao.getAll();
		mav.addObject("pages_data_list", pages_data_list);
		return mav;
	}

	@RequestMapping(value="/pages/category/*/*/*", method=RequestMethod.GET)
	public ModelAndView other(ModelAndView mav, HttpServletRequest request) {
		String url = request.getRequestURI();
		mav.setViewName(url);
		return mav;
	}

}
