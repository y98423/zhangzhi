package com.zhangzhi.util;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class CosUpload {

	/**
	 * 上传文件到指定目录
	 * 
	 * @param request
	 * @param saveDirectory
	 * @param maxPostSize
	 * @return 返回上传后的文件名
	 * @throws IOException 
	 */
	public static String save(HttpServletRequest request, String saveDirectory,
			int maxPostSize) throws IOException {
		File file = new File(saveDirectory);
		if (!file.isDirectory() || !file.exists()) {
			file.mkdir();
		}
		String lastFileName = null;
		// 文件上传后，保存在c:/upload
		// 每个文件最大5m,最多3个文件,所以...
		// response的编码为"gb2312",同时采用相应的命名策略（我用了自己的实现方法）冲突解决策略,实现上传考虑到自己的项目需要，我使用了自己的命名策略，
		RandomFileRenamePolicy policy = new RandomFileRenamePolicy();
		// 只要实现了FileRenamePolicy接口中的rename(File file)方法即可，
		// 实现非常方便，COS有个默认的命名策略DefaultFileRenamePolicy，只要存在重名，就会在文件名后面加上1.2.3....等数字，不想麻烦的就可以直接以下代码：
		MultipartRequest multi = new MultipartRequest(request, saveDirectory,
				maxPostSize, "utf-8", policy);
		// 输出反馈信息
		Enumeration files = multi.getFileNames();
		while (files.hasMoreElements()) {
			String name = (String) files.nextElement();
			File f = multi.getFile(name);
			if (f != null) {
				String fileName = multi.getFilesystemName(name);
				lastFileName = saveDirectory + "/" + fileName;
			}
		}
		return lastFileName;
	}
}
