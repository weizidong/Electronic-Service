package com.wzd.service;

import java.util.List;

import com.wzd.dto.WebException;
import com.wzd.entity.Letter;

public interface LetterService {
	// 签收电子函
	public Letter get(Integer id, String idCard, String code) throws WebException;

	// 根据id获取
	public Letter getById(int id);

	// 获取电子函列表
	public List<Letter> find(Integer page, Integer pageSize, String filed, String word);

	// 删除电子函
	public void delete(int id);

	// 发送电子函
	public Letter send(Letter l);

}
