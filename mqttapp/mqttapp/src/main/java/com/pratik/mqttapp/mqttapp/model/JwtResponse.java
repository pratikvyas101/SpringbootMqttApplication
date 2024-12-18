package com.pratik.mqttapp.mqttapp.model;

public class JwtResponse {
    private String jwtToken;
    private String username;

    // Private constructor to enforce the use of the builder
    private JwtResponse(Builder builder) {
        this.jwtToken = builder.jwtToken;
        this.username = builder.username;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String jwtToken;
        private String username;

        public Builder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(this);
        }
    }

    // Getters
    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }

	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + "]";
	}
    
}

