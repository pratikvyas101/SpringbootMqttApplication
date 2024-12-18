//package com.pratik.mqttapp.mqttapp.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class AuthorityId implements Serializable {
//
//    @Column(name = "username", nullable = false, length = 50)
//    private String username;
//
//    @Column(name = "authority", nullable = false, length = 50)
//    private String authority;
//
//    // Default constructor
//    public AuthorityId() {}
//
//    // Parameterized constructor
//    public AuthorityId(String username, String authority) {
//        this.username = username;
//        this.authority = authority;
//    }
//
//    // Getters and Setters
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    // Override equals() and hashCode()
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        AuthorityId that = (AuthorityId) o;
//        return Objects.equals(username, that.username) && Objects.equals(authority, that.authority);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, authority);
//    }
//    
//    
//}