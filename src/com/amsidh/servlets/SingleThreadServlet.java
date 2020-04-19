package com.amsidh.servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/singlethread"},name="singleThread")
public class SingleThreadServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		int counter = 0;
		try {
			BufferedReader br = new BufferedReader(
					new FileReader("counter.txt"));
			counter = Integer.parseInt(br.readLine());
			

			br.close();
		} catch (Exception e) {
			System.out.println("exception in Reader!!!!!");
			e.printStackTrace();
		}

		counter++;
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("counter.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter(
					"counter.txt"));
			writer.write(Integer.toString(counter));
			writer.close();
		} catch (Exception e) {
			System.out.println("exception in Writer!!!!!");
			e.printStackTrace();
			
		}

		try
		{
			PrintWriter writer = response.getWriter();
			writer.print("Your Visitor number is: "+counter);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception in Output!!!!!");
			e.printStackTrace();
		}
	}

}
