package com.example.demo.entites;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "username", nullable = false, unique = true, length = 255)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	@Column(updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();;

	@Column
	private LocalDateTime updatedAt = LocalDateTime.now();;
//
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//	List<CartItems> cartitems = new ArrayList<>();
//
//	public User(int userId, String username, String email, String password, Role role, LocalDateTime createdAt,
//			LocalDateTime updatedAt, List<CartItems> cartitems) {
//		super();
//		this.userId = userId;
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.cartitems = cartitems;
//	}
//
//	public User(String username, String email, String password, Role role, List<CartItems> cartitems) {
//		super();
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//		this.cartitems = cartitems;
//	}
//
//	public User(String username, String email, String password, Role role, LocalDateTime createdAt,
//			LocalDateTime updatedAt, List<CartItems> cartitems) {
//		super();
//		this.username = username;
//		this.email = email;
//		this.password = password;
//		this.role = role;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
//		this.cartitems = cartitems;
//	}

	// Default constructor
	public User() {
	}

	// Constructor with all fields
	public User(int userId, String username, String email, String password, Role role, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	// Constructor without timestamps
	public User(String username, String email, String password, Role role) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	// Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

//	public List<CartItems> getCartitems() {
//		return cartitems;
//	}
//
//	public void setCartitems(List<CartItems> cartitems) {
//		this.cartitems = cartitems;
//	}

}
