package com.easydojo.common.servlet;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.DateUtils;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String path = request.getPathInfo();
		path = path.substring(1);
//		System.out.println("Path:" + path);
		
		URL url = loader.getResource(path);
		InputStream is = url.openStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		bis = new BufferedInputStream(is);
		bos = new BufferedOutputStream(response.getOutputStream());
		int r = 0;
		String contentType = getServletContext().getMimeType(path);
		response.setContentType(contentType);
		response.setContentLength(bis.available());
		response.setDateHeader("Expires", getExpiresMills());
		response.addHeader("Cache-Control", "max-age=600");
		
		while ((r = bis.read()) != -1) {
			bos.write(r);
		}
		bis.close();
		bos.close();
	}
	
	protected long getExpiresMills() {
		Date date = DateUtils.addMinutes(new Date(), 30);
		long t = date.getTime();
		return t;
	}

}
