package br.com.ginx.websocket.servlet;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import br.com.ginx.websocket.socket.PongWebSocket;

public class WebSocketPongServlet extends WebSocketServlet {

	private static final long serialVersionUID = 5610501345675935366L;
	public final Set<PongWebSocket> users = new CopyOnWriteArraySet<PongWebSocket>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getNamedDispatcher("default").forward(request, response);
	}

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest arg0, String arg1) {
		return new PongWebSocket(users);
	}

}
