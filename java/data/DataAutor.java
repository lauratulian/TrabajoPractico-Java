package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Libro;
import entities.Autor;

public class DataAutor {
	
	public LinkedList<Autor> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Autor> autores= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT * FROM autor");
			if(rs!=null) {
				while(rs.next()) {
					Autor autor =new Autor();
					autor.setId(rs.getInt("id_autor"));
					autor.setDescripcion(rs.getString("descripcion"));
					autores.add(autor);
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
		
		
		return autores;
	}
	
	public Autor getById(Autor autorToSearcg) {
		Autor autor=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM autor WHERE id_autor=?"
					);
			stmt.setInt(1, autorToSearcg.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				autor=new Autor();
				autor.setId(rs.getInt("id_autor"));
				autor.setDescripcion(rs.getString("descripcion"));
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
		
		return autor;
	}
	
	public Autor getByDesc(Autor autorToSearch) {
		Autor autor=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM autor WHERE descripcion=?"
					);
			stmt.setString(1, autorToSearch.getDescripcion());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				autor=new Autor();
				autor.setId(rs.getInt("id_autor"));
				autor.setDescripcion(rs.getString("descripcion"));
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
		
		return autor;
	}
	
	public void setAutor(Libro lib) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT autor.* FROM autor INNER JOIN libro ON autor.id = libro.autor_id WHERE libro.id_libro = ?"
					);
			stmt.setInt(1, lib.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Autor autor=new Autor();
					autor.setId(rs.getInt("id_autor"));
					autor.setDescripcion(rs.getString("descripcion"));
					lib.setAutor(autor);
				}
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
	}
	
	public void add(Autor autor) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT into autor(descripcion) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, autor.getDescripcion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                autor.setId(keyResultSet.getInt(1));
            }

			
		} catch (SQLException e) {
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
	
	public void update(Autor autor) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE autor set descripcion=? WHERE id_autor=?");
			stmt.setString(1, autor.getDescripcion());
			stmt.setInt(2, autor.getId());
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
	
	public void remove(Autor autor) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE from autor where id_autor=?");
			stmt.setInt(1, autor.getId());
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
