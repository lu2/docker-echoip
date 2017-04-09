package net.haltuf.playground.docker.echoip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class EchoIpController {
	
	@RequestMapping
	public String get() throws UnknownHostException {
		return String.format("Served from IP: %s, at %s.", 
				InetAddress.getLocalHost().getHostAddress(),
				LocalDateTime.now());
	}

}
