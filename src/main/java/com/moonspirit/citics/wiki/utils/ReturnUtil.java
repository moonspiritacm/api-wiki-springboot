package com.moonspirit.citics.wiki.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.moonspirit.citics.wiki.result.Result;

/**
 * @ClassName      ReturnUtil
 * @Description    响应处理工具类
 * @author         moonspirit
 * @date           2019年6月25日 上午11:01:45
 * @version        1.0.0
 */
public class ReturnUtil {

	public static void returnJson(HttpServletResponse response, Result<?> result) throws IOException {
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");

		PrintWriter pw = response.getWriter();
		pw.write(JSONObject.toJSONString(result));
		pw.flush();
		pw.close();
	}

}
