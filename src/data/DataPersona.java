package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Persona;

public class DataPersona {
	
	public LinkedList<Persona> getAll(){
		DataRol dr=new DataRol();
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Persona> personas= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT id_persona, dni,nombre, mail, telefono, direccion, adicional FROM persona");
			if(rs!=null) {
				while(rs.next()) {
					Persona persona=new Persona();
					persona.setId(rs.getInt("id_persona"));
					persona.setDni(rs.getString("dni"));
					persona.setNombre(rs.getString("nombre"));
					persona.setMail(rs.getString("mail"));
					persona.setTelefono(rs.getString("telefono"));
					persona.setDireccion(rs.getString("direccion"));
					persona.setAdicional(rs.getString("adicional"));
					
					//dr.setRoles(persona);
					
					personas.add(persona);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return personas;
	}
	
	public Persona getByUser(Persona per) {
		//DataRol dr=new DataRol();
		Persona persona= new Persona();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id_persona, dni, nombre, mail, telefono, direccion, adicional FROM persona WHERE mail=? and contrasenia=?"
					);
			stmt.setString(1, per.getMail());
			stmt.setString(2, per.getContrasenia());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				persona=new Persona();
				persona.setId(rs.getInt("id_persona"));
				persona.setDni(rs.getString("dni"));
				persona.setNombre(rs.getString("nombre"));
				persona.setMail(rs.getString("mail"));
				persona.setTelefono(rs.getString("telefono"));
				persona.setDireccion(rs.getString("direccion"));
				persona.setAdicional(rs.getString("adicional"));
				//dr.setRoles(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return persona;
	}
	
	
	public Persona getById(Persona per) {
		//DataRol dr=new DataRol();
		Persona persona= new Persona();
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT id_persona, dni, nombre, mail, telefono, direccion, adicional FROM persona WHERE id_persona=?"
					);
			stmt.setInt(1, per.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				persona=new Persona();
				persona.setId(rs.getInt("id_persona"));
				persona.setDni(rs.getString("dni"));
				persona.setNombre(rs.getString("nombre"));
				persona.setMail(rs.getString("mail"));
				persona.setTelefono(rs.getString("telefono"));
				persona.setDireccion(rs.getString("direccion"));
				persona.setAdicional(rs.getString("adicional"));
				//dr.setRoles(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return persona;
	}
	
	public void add(Persona p) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT into persona(dni, nombre, mail, contrasenia, telefono, direccion, adicional) values(?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getMail());
			stmt.setString(4, p.getContrasenia());
			stmt.setString(5, p.getTelefono());
			stmt.setString(6, p.getDireccion());
			stmt.setString(7, p.getAdicional());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                p.setId(keyResultSet.getInt(1));
            }
            
            //DataRol dr = new DataRol();
            //dr.setRolesDePersona(p);

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}
	
	public void update(Persona p) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE libro set dni = ?, nombre = ?, mail = ?, telefono = ?, direccion = ?, adicional = ? WHERE id_persona=?");
			
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getMail());
			stmt.setString(4, p.getTelefono());
			stmt.setString(5, p.getDireccion());
			stmt.setString(6, p.getAdicional());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	}

	
	public void remove(Persona persona) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE from persona WHERE id_persona=?");
			stmt.setInt(1, persona.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
			}
		}
}
