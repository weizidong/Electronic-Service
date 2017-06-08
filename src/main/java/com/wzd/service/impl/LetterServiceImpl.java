package com.wzd.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzd.dao.LetterDao;
import com.wzd.entity.Letter;
import com.wzd.entity.LetterExample;
import com.wzd.entity.LetterExample.Criteria;
import com.wzd.service.FileService;
import com.wzd.service.LetterService;
import com.wzd.utils.CodeUtil;

@Service
public class LetterServiceImpl implements LetterService {
	@Resource
	private LetterDao letterDao;
	@Resource
	private FileService fileService;

	@Override
	public Letter get(Integer id, String idCard, String code) {
		LetterExample e = new LetterExample();
		Criteria c = e.createCriteria();
		c.andIdEqualTo(id);
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
	public List<Letter> find(Integer page, Integer pageSize, String filed, String word) {
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

	@Override
	public Letter send(Letter l) {
		String code = CodeUtil.get(8);
		l.setCode(code);
		l.setSendTime(new Date());
		letterDao.insertSelective(l);
		return l;
	}
}
