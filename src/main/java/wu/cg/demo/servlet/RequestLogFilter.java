package wu.cg.demo.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class RequestLogFilter
 */
public class RequestLogFilter implements Filter {

	static final Logger log = LoggerFactory.getLogger(RequestLogFilter.class);

	/**
	 * Default constructor.
	 */
	public RequestLogFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		/*
		 * request.getServletPath() - /a.jsp request.getContextPath() - /工程名
		 * request.getRequestURI() - /工程名/a.jsp request.getRequestURL() -
		 * http://127.0.0.1:8080/工程名/a.jsp
		 */
		String uri = req.getRequestURI();
		log.info("begin request URI:{}", uri);
		// pass the request along the filter chain
		chain.doFilter(request, response);
		log.info("end request URL:{}", req.getRequestURL());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
