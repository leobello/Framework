/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import bd.Publications;
import bd._Users;
import contenu.Commentaire;
import contenu.Contenu;
import contenu.Photo;
import serveur.Serveur;
import services.Dislike;
import services.Like;
import services._Reactions;

public abstract class Utilisateurs implements _Utilisateurs, Serializable {

	private static final long serialVersionUID = 1L;
	protected String pseudo;
	protected String password;
	protected Photo photoDeProfile;
	protected ArrayList<_Reactions> reactions;
	protected ArrayList<Contenu> partages;
	protected ArrayList<_Utilisateurs> friends;
	protected ArrayList<_Utilisateurs> followed;
	protected ArrayList<_Utilisateurs> follow;
	protected boolean admin;

	public Utilisateurs() {
		this.reactions = new ArrayList<_Reactions>();
		this.partages = new ArrayList<Contenu>();
		this.friends = new ArrayList<_Utilisateurs>();
		this.followed = new ArrayList<_Utilisateurs>();
		this.follow = new ArrayList<_Utilisateurs>();
	}

	public String getName() throws RemoteException {
		return this.pseudo;
	}

	public String getPassword() throws RemoteException {
		return this.password;
	}

	public void setPhotoDeProfile(Photo photoDeProfile) {
		this.photoDeProfile = photoDeProfile;
		update();
	}

	public Photo getPhotoDeProfile() {
		return this.photoDeProfile;
	}

	public void setName(String name) throws RemoteException {
		this.pseudo = name;
		update();
	}

	public ArrayList<Contenu> getPartages() {
		return this.partages;
	}

	public void publier(Contenu c) {
		this.partages.add(c);
		update();
	}

	public void suprimer(Contenu contenu) {
		this.reactions.remove(contenu);
	}

	public void liker(Contenu c) {
		Like r = new Like(this, c);
		reactions.add(r);
		update();
	}

	public void disliker(Contenu c) {
		Dislike r = new Dislike(this, c);
		reactions.add(r);
		update();
	}

	public void commenter(Contenu c, String s) throws OperationNotSupportedException {
		// si le contenu est privée
		Utilisateurs owner;
		owner = (Utilisateurs) c.getUser();
		if (c.getPartage().getClass().toString().equals("services.Privee")) {
			if (owner.isFriend(this)) {
				Commentaire com = new Commentaire(this, c, s);
				c.addComment(com);
			} else {
				throw new OperationNotSupportedException();

			}
		} else {
			Commentaire com = new Commentaire(this, c, s);
			c.addComment(com);
		}
		update();
	}

	/*
	 * private void enregistrerPersonne() { try { new Serialization(FriendsBD,this);
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	/*
	 * @SuppressWarnings({ "unused" }) private _Utilisateurs lireBD() { try {
	 * Deserialization dsz =new Deserialization(FriendsBD); return (_Utilisateurs)
	 * dsz.ObjectLu(); } catch (ClassNotFoundException | IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } return null; }
	 */

	public void beFriend(_Utilisateurs u) {
		this.friends.add(u);
		// enregistrerPersonne();
		update();
	}

	public void printFriend() throws RemoteException {
		for (_Utilisateurs u : this.friends) {
			System.out.println(u.getName());
		}
	}

	public boolean isFriend(_Utilisateurs friend) {
		return this.friends.contains(friend);
	}

	public void follow(_Utilisateurs user) {
		this.follow.add(user);
		Utilisateurs u2 = (Utilisateurs) user;
		u2.followed(this);
		update();
	}

	public void unFollow(_Utilisateurs user) {
		this.follow.remove(user);
		Utilisateurs u2 = (Utilisateurs) user;
		u2.unfollowed(this);
		update();
	}

	public void followed(_Utilisateurs user) {
		this.followed.add(user);
		update();
	}

	public void unfollowed(_Utilisateurs user) {
		followed.remove(user);
		update();
	}

	public void update() {
		String url = "rmi://" + Serveur.listen + "/Gnaouas";
		try {
			_Users serv = (_Users) Naming.lookup(url);
			serv.updateUser(this);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* renvoi le plus vieux contenue d'une liste */
	static public Contenu getYouger(ArrayList<Contenu> list) {
		Contenu older;
		ArrayList<Contenu> timeline = new ArrayList();

		older = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (older.getDate().compareTo(list.get(i).getDate()) < 0) {
				older = list.get(i);
			}

		}
		return older;
	}

	public ArrayList<Contenu> cleanTimeLine(ArrayList<Contenu> list) {
		ArrayList<Contenu> timeline = list;
		ArrayList<Contenu> timeline2 = new ArrayList();
		Contenu c;
		int taille = list.size();
		for (int i = 0; i < taille; i++) {
			c = getYouger(list);
			timeline2.add(c);
			timeline.remove(c);
		}
		update();
		return timeline2;
	}

	public ArrayList<Contenu> getTimeline() {
		ArrayList<Contenu> timeline = new ArrayList<Contenu>();
		Utilisateurs u2 = null;
		for (_Utilisateurs u : this.friends) {
			u2 = (Utilisateurs) u;
			for (Contenu c : u2.getPartages()) {
				timeline.add(c);
			}
		}
		return timeline;
	}

	public void setPassword(String password) {
		this.password = password;
		update();
	}

	public void delContenu(Contenu contenu) {
		this.partages.remove(contenu);
		update();
	}

	public Utilisateurs searchUser(String login) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://" + Serveur.listen + "/Gnaouas";
		_Users server = (_Users) Naming.lookup(url);
		return server.getUser(login);
	}

	public void publierENPublique(Contenu P) throws MalformedURLException, RemoteException, NotBoundException {
		String url = "rmi://" + Serveur.listen + "/Gnaouas";
		Publications server = (Publications) Naming.lookup(url);
		server.publier(P);
	}

}
