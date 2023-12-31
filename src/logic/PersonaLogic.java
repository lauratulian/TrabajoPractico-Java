package logic;

import java.util.LinkedList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import data.DataPersona;
import entities.Persona;

public class PersonaLogic {
	private DataPersona dataPersona=new DataPersona();
	
    public LinkedList<Persona> getAll()
    {
        return this.dataPersona.getAll();
    }
    
	public void add(Persona persona) {
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
	
	public void update(Persona persona) 
	{
		this.dataPersona.update(persona);
	}
	
	public Persona validate(Persona persona) 
	{
	Persona per = dataPersona.getByUser(persona);

    if (per != null && per.getId() != 0) {
        return per;
    	}
    else {
        return null;}
	}
	
	public Persona getById(int id) 
	{
		return dataPersona.getById(id);
	}
}

