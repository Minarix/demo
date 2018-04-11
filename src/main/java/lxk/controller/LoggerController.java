package lxk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggerController {
	final Logger logger = LogManager.getLogger(getClass());

	@RequestMapping("/logger")
	public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.getWriter().println("test logger");

		logger.info("这是一条日志信息 - {}", "lxk");
	}
}