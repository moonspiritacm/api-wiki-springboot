package com.moonspirit.citics.wiki.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	  * @MethodName       uploadFile
	  * @Description      上传文件到指定目录
	  * @param            multipartFile 待上传文件
	  * @param            filePath 目标路径
	  * @param            fileName 目标文件名
	  * @throws           IOException
	  */
	public static void uploadFile(MultipartFile multipartFile, String filePath, String fileName) throws IOException {
		// 载入文件存储目录
		File dir = new File(filePath);
		if (!dir.exists() && !dir.isDirectory()) {
			dir.mkdirs();
		}

		// 上传文件
		Path path = Paths.get(filePath + fileName);
		byte[] bytes = multipartFile.getBytes();
		Files.write(path, bytes);
	}

}
