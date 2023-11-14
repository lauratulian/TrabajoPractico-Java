package logic;

import java.util.LinkedList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import data.DataPersona;
import entities.Persona;

public class Login {
	private DataPersona dataPersona=new DataPersona();
	
    public LinkedList<Persona> getAll()
    {
        return this.dataPersona.getAll();
    }
    
	public void add(Persona persona) {
		persona.setContrasenia(this.convertirSHA256(persona.getContrasenia()));
		this.dataPersona.add(persona);
	}
	
	public void delete(Persona persona)
     {
        this.dataPersona.remove(persona);
     }
	
	public String convertirSHA256(String password) 
	{
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} 
		catch (NoSuchAlgorithmException e) {		
			e.printStackTrace();
			return null;
		}
		    
		byte[] hash = md.digest(password.getBytes());
		StringBuffer sb = new StringBuffer();
		    
		for(byte b : hash) {        
			sb.append(String.format("%02x", b));
		}
		    
		return sb.toString();
		}
	
	public Persona validate(Persona persona) 
	{
		return dataPersona.getByUser(persona);
	}
	
}

