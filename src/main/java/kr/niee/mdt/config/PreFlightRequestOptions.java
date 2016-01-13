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

		if (StringUtils.hasLength(requestMethods)) {
			response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, requestMethods);
		}

		if (StringUtils.hasLength(requestHeaders)) {
			response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);
		}

		response.setHeader(ACCESS_CONTROL_MAX_AGE, DAY_IN_SECONDS.toString());
	}
}
