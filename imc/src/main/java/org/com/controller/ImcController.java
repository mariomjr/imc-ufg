package org.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.entity.Imc;
import org.com.enums.EnumSexo;
import org.com.model.ImcModel;

@WebServlet("/imc")
public class ImcController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623177400758433046L;

	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		result = result.replace(",", ".");
		return result;
	}

	private Double toDouble(HttpServletRequest req, String param, String padrao) {
		return Double.parseDouble(valor(req, param, padrao));
	}

	private EnumSexo toEnumSexo(HttpServletRequest req, String param) {
		String result = req.getParameter(param);
		if (result != null) {
			return EnumSexo.valueOf(result.toUpperCase());
		}
		return null;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Double peso = toDouble(req, "peso", "0");
		Double altura = toDouble(req, "altura", "0");
		EnumSexo sexo = toEnumSexo(req, "sexo");

		Imc imc = ImcModel.calcularImc(peso, altura, sexo);

		req.setAttribute("resultadoImc", imc.getValor());
		req.setAttribute("situacaoImc", imc.getSituacao());

		req.getRequestDispatcher("ImcView.jsp").forward(req, resp);
	}
}
