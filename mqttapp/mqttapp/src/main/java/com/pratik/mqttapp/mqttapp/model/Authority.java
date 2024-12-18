package com.pratik.mqttapp.mqttapp.model;



import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "authority", nullable = false, length = 50)
    private String authority;

    // Default Constructor
    public Authority() {}
    
   

    // Constructor
    public Authority(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
  
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }



	@Override
	public String toString() {
		return "Authority [id=" + id + ", authority=" + authority + "]";
	}



	



	
    
}
