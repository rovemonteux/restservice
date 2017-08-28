package cf.monteux.service.api;

import java.io.IOException;
import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.logging.Logger;

    @Secured
    @Provider
    @Priority(Priorities.AUTHENTICATION)
    public class AuthenticationFilter implements ContainerRequestFilter {

    	private static final Logger log = Logger.getLogger(AuthenticationFilter.class.getName());
    	
        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {

        	log.info("Inside the filter");

            String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

            if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
                throw new NotAuthorizedException("Authorization header must be provided");
            }

            String token = authorizationHeader.substring("Bearer".length()).trim();

            try {

                validateToken(token);

            } catch (Exception e) {
                requestContext.abortWith(
                        Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }

        private void validateToken(String token) throws Exception {
            // TODO: Check token validity
        }

    }