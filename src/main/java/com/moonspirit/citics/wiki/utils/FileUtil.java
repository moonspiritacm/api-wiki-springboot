package com.moonspirit.citics.wiki.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName      FileUtil
 * @Description    文件操作工具类
 * @author         moonspirit
 * @date           2019年6月25日 上午11:00:36
 * @version        1.0.0
 */
public class FileUtil {

	/**
	  * @MethodName       upload
	  * @Description      上传文件到指定目录
	  * @param            multipartFile 待上传文件
	  * @param            filePath 目标路径
	  * @param            fileName 目标文件名
	  * @throws           IOException
	  */
	public static void upload(MultipartFile multipartFile, String filePath, String fileName) throws IOException {
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
