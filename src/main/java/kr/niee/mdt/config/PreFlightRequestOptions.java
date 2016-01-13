package kr.niee.mdt.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PreFlightRequestOptions {

	private static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
	private static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
	private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
	private static final Integer DAY_IN_SECONDS = 24 * 60 * 60;

	@RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
	public void preFlightRequestOptions(
			HttpServletRequest req,
			@RequestHeader(value = ACCESS_CONTROL_REQUEST_METHOD, required = false) String requestMethods,
			@RequestHeader(value = ACCESS_CONTROL_REQUEST_HEADERS, required = false) String requestHeaders,
			HttpServletResponse response) {

		Enumeration<String> headers = req.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
			System.out.println(header + " : " + req.getHeader(header));
		}

		// response 헤더를 request 헤더와 동일하게 만든다. 제한이 필요하다면 필요한 값으로 설정한다.
		if (StringUtils.hasLength(requestMethods)) {
			response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, requestMethods);
		}

		// response 헤더를 request 헤더와 동일하게 만든다. 제한이 필요하다면 필요한 값으로 설정한다.
		if (StringUtils.hasLength(requestHeaders)) {
			response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);
		}

		// 브라우저가 preflight 응답을 캐싱하도록 max age를 세팅해준다.
		response.setHeader(ACCESS_CONTROL_MAX_AGE, DAY_IN_SECONDS.toString());
	}
}
