package kr.niee.mdt.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.niee.mdt.config.service.ApiUserCheckService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CorsInterceptor implements HandlerInterceptor {

	@Autowired
	private ApiUserCheckService apiUserCheckService;

	private static final Logger logger = LoggerFactory
			.getLogger(CorsInterceptor.class);

	private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	private static final String REQUEST_HEADER_ORIGIN = "Origin";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("preHandle() start");
		String origin = request.getHeader(REQUEST_HEADER_ORIGIN);
		String userKey = "testmyweb";
		logger.debug("Origin Header: {}", origin);

		if (apiUserCheckService.getApiUser(userKey, origin)) {
			response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
			response.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
			logger.debug("preHandle() end");
			return true;
		} else {
			logger.debug("preHandle() end");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// do nothing
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// do nothing
	}

}