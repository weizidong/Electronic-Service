package com.wzd.service;

import java.util.List;

import com.wzd.entity.File;
import com.wzd.entity.Letter;

public interface FileService {
	// 上传文件
	public File upload(Letter l);

	// 删除文件
	public void delete(Letter l);

	// 获取文件
	public List<File> find(int fk);
}
