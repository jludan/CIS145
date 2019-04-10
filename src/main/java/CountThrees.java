//package com.codeprovisions;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletCountThrees
 * 
 * Java Servlet that counts the number of occurrences of the integer
 *   '3' in the binary data file threesData.bin
 *   
 * threesData.bin should be in the same folder as this class file
 * 
 * 
 * 
 * @author Felicia Pacifica
 * 
 *
 */

@WebServlet(name = "countthrees", urlPatterns = { "/countthrees" })
public class CountThrees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try (PrintWriter printWriter = response.getWriter()) {
			printWriter.append("Number of threes: " + getThreesCount());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int getThreesCount() {

		int threesCount = 0;

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("threesData.bin");

		try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream))) {
			while (dataInputStream.available() > 0) {
				if (dataInputStream.readInt() == 3) {
					threesCount++;
				}
			}
		} catch (IOException readException) {
			readException.printStackTrace();
		}

		return threesCount;
	}

}
