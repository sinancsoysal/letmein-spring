package com.ssoysal.letMeIn.entities;

import javax.persistence.*;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name="login")
public class Login {

		@Id
		@Column(name="id")
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		
		@Column(name="url")
		@ColumnTransformer(
		        read = "cast(aes_decrypt(url, UNHEX('F3229A0B369ED2D9441B830D69A390C3')) as char(255))", 
		        write = "aes_encrypt(?, UNHEX('F3229A0B369ED2D9441B830D69A390C3'))")
		private String url;
		
		@Column(name="mail")
		@ColumnTransformer(
		        read = "cast(aes_decrypt(mail, UNHEX('F3229A0B369ED2D6941B830D21A390C3')) as char(255))", 
		        write = "aes_encrypt(?, UNHEX('F3229A0B369ED2D6941B830D21A390C3'))")
		private String mail;
		
		@Column(name="pass")
		@ColumnTransformer(
		        read = "cast(aes_decrypt(pass, UNHEX('F3229A0B369ED2D9441B830D21A390C3')) as char(255))", 
		        write = "aes_encrypt(?, UNHEX('F3229A0B369ED2D9441B830D21A390C3'))")
		private String pass;

		public Login() {}
		
		public Login(int id, String url, String mail, String pass) {
			super();
			this.id = id;
			this.url = url;
			this.mail = mail;
			this.pass = pass;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
		
		
}
