HTML5 Pong
===== ====

This is a multiplayer version of the classic game pong, created using only HTML5 and Javascript on the client.
For the server, we use the Jetty WebServer, to provide websocket functionality.

The game is playable, with minor bugs, that I don't fix, but if there are people interested in put this in some server
we can fix 'cause are simple ones.

The features:

	* Board using canvas
	* Playable by 2 players on distinct machines
	* Ball sincronization between machines
	* Ball aceleration on hits
	* In-game score
	* A lot of fun
	
The problems:

	* Server implementation remain the simplest possible, only support two players and server must be restarted to
	  play a new match.
	* Sometimes the ball hit the player's car, but it count as a point to another player
	* Sometimes the ball go crazy, speeding to much
	
To Run:

To run the code you MUST use Netbeans (as it is a POM project use other IDE at your own risk).

Install Netbeans (I installed the version 7.4) and open the project (not import it, open from the cloned dir).

Install the dependencies (right click on dependencies on project tree).

Click in Run.

Access with a WebSocket enabled browser: http://localhost:8080/pong/

The match will automatically start when a second browser hit the same page.
