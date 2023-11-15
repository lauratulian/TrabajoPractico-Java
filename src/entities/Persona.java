package entities;

import java.util.Date;
import java.util.HashMap;

public class Persona {
	private int id;
	private String dni;
	private String nombre;
	private String mail;
	private String contrasenia;
	private Date fecha_nacimiento;
	private String telefono;
	private String direccion;
	private String adicional;
	private HashMap<Integer, Rol> roles;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getAdicional() {
		return adicional;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	public HashMap<Integer, Rol> getRoles() {
		return roles;
	}
	public void setRoles(HashMap<Integer, Rol> roles) {
		this.roles = roles;
	}
	
	public Persona() {
		this.roles=new HashMap<>();
	}
	
	public void addRol(Rol rolToBeAdded) {
		this.roles.put(rolToBeAdded.getId(), rolToBeAdded);
	}
	
	public void removeRol(Rol rolToBeRemoved) {
		this.roles.remove(rolToBeRemoved.getId());
	}
	
	public boolean hasRol(Rol rolToCheck) {
		return this.roles.containsKey(rolToCheck.getId());
	}
	
	public HashMap<Integer, Rol> getAllRoles(){
		return this.roles;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", mail=" + mail + ", contrasenia=" + contrasenia
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", adicional=" + adicional + ", roles=" + roles + "]";
	}
	
	

}
