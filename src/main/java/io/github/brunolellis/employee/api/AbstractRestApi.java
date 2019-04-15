package io.github.brunolellis.employee.api;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

public abstract class AbstractRestApi {

	protected URI getUriPathLocation(UriInfo uriInfo, String id) {
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(id);
		return builder.build();
	}

}