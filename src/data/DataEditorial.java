package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Editorial;
import entities.Libro;

public class DataEditorial {
	
	public LinkedList<Editorial> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Editorial> editoriales= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT * FROM editorial");
			if(rs!=null) {
				while(rs.next()) {
					Editorial editorial =new Editorial();
					editorial.setId(rs.getInt("id_editorial"));
					editorial.setDescripcion(rs.getString("descripcion"));
					editoriales.add(editorial);
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
		
		
		return editoriales;
	}
	
	public Editorial getById(Editorial editorialToSearch) {
		Editorial editorial=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM editorial WHERE id_editorial=?"
					);
			stmt.setInt(1, editorialToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				editorial=new Editorial();
				editorial.setId(rs.getInt("id_editorial"));
				editorial.setDescripcion(rs.getString("descripcion"));
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
		
		return editorial;
	}
	
	public Editorial getByDesc(String descripcion) {
		Editorial editorial=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM editorial WHERE descripcion=?"
					);
			stmt.setString(1, descripcion);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				editorial=new Editorial();
				editorial.setId(rs.getInt("id_editorial"));
				editorial.setDescripcion(rs.getString("descripcion"));
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
		
		return editorial;
	}
	
	public void setEditorialLibro(Editorial editorial, Libro lib) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "SELECT editorial.* FROM editorial INNER JOIN libro ON editorial.id_editorial = libro.editorial WHERE libro.id_libro = ?"
					);
			stmt.setInt(1, lib.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					editorial.setId(rs.getInt("id"));
					editorial.setDescripcion(rs.getString("descripcion"));
					lib.setEditorial(editorial);
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
	
	public void add(Editorial editorial) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT into editorial(descripcion) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, editorial.getDescripcion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                editorial.setId(keyResultSet.getInt(1));
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
	
	public void update(Editorial editorial) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE editorial set descripcion=? WHERE id_editorial=?");
			stmt.setString(1, editorial.getDescripcion());
			stmt.setInt(2, editorial.getId());
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
	
	public void remove(Editorial editorial) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE from editorial WHERE id_editorial=?");
			stmt.setInt(1, editorial.getId());
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
