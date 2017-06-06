package com.wzd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wzd.dao.FileDao;
import com.wzd.entity.File;
import com.wzd.entity.FileExample;
import com.wzd.entity.FileExample.Criteria;
import com.wzd.entity.Letter;
import com.wzd.service.FileService;

@Service
public class FileServiceImpl implements FileService {
	@Resource
	private FileDao fileDao;

	@Override
	public File upload(Letter l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Letter l) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<File> find(int letterId) {
		FileExample e = new FileExample();
		Criteria c = e.createCriteria();
		c.andLetterIdEqualTo(letterId);
		return fileDao.selectByExample(e);
	}
}
