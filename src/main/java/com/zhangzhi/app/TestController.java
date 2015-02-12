package com.zhangzhi.app;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhangzhi.util.CosUpload;

@Controller
public class TestController {

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public ModelAndView main() {
		System.out.println("掉到了");
		return new ModelAndView("index");
	}  

	@ResponseBody
	@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
	public String testUpload(HttpServletRequest request) {
		String saveDirectory = request.getRealPath("/") + "upload";
		try {
			String savedFileName = CosUpload.save(request, saveDirectory,
					1024 * 1024 * 2);
			JSONObject obj = new JSONObject();
			obj.put("statusCode", 200);
			obj.put("message", "导入数据成功");
			obj.put("filename", savedFileName);
			System.out.println(savedFileName);
			return obj.toString();
		} catch (IOException e) {
			JSONObject obj = new JSONObject();
			obj.put("statusCode", 300);
			obj.put("message", "网络异常或者文件超出2M！");
			obj.put("filename", "");
			return obj.toString();
		}
	}
}
