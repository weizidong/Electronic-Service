package com.wzd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzd.dao.LetterDao;
import com.wzd.entity.Letter;
import com.wzd.entity.LetterExample;
import com.wzd.entity.LetterExample.Criteria;
import com.wzd.service.FileService;
import com.wzd.service.LetterService;

@Service
public class LetterServiceImpl implements LetterService {
	@Resource
	private LetterDao letterDao;
	@Resource
	private FileService fileService;

	@Override
	public Letter get(String idCard, String code) {
		LetterExample e = new LetterExample();
		Criteria c = e.createCriteria();
		c.andIdCardEqualTo(idCard);
		c.andCodeEqualTo(code);
		List<Letter> letters = letterDao.selectByExample(e);
		if (letters != null && letters.size() > 0) {
			Letter l = letters.get(0);
			l.setFiles(fileService.find(l.getId()));
			return l;
		}
		return null;
	}

	@Override
	public void create(Letter l) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Letter> find(int page, int pageSize, String filed, String word) {
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Letter getById(int id) {
		Letter l = letterDao.selectByPrimaryKey(id);
		l.setFiles(fileService.find(l.getId()));
		return l;
	}
}
