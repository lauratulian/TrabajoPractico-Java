package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Categoria;
import entities.Libro;

public class DataCategoria {
	
	public LinkedList<Categoria> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Categoria> categorias= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT * FROM categoria");
			if(rs!=null) {
				while(rs.next()) {
					Categoria categoria =new Categoria();
					categoria.setId(rs.getInt("id_categoria"));
					categoria.setDescripcion(rs.getString("descripcion"));
					categorias.add(categoria);
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
		
		
		return categorias;
	}
	
	public Categoria getById(Categoria cat) {
		Categoria categoria=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM categoria WHERE id_categoria=?"
					);
			stmt.setInt(1, cat.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				categoria=new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setDescripcion(rs.getString("descripcion"));
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
		
		return categoria;
	}
	
	public Categoria getByDesc(String descripcion) {
		Categoria categoria=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM categoria WHERE descripcion=?"
					);
			stmt.setString(1, descripcion);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				categoria=new Categoria();
				categoria.setId(rs.getInt("id_categoria"));
				categoria.setDescripcion(rs.getString("descripcion"));
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
		
		return categoria;
	}
	public void setCategoriaLibro(Categoria cat, Libro lib) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT categoria.* FROM categoria INNER JOIN libro ON categoria.id_categoria = libro.categoria WHERE libro.id_libro= ?"
					);
			stmt.setInt(1, lib.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					cat.setId(rs.getInt("id_categoria"));
					cat.setDescripcion(rs.getString("descripcion"));
					lib.setCategoria(cat);
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
	
	public void add(Categoria categoria) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT into categoria(descripcion) values(?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, categoria.getDescripcion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                categoria.setId(keyResultSet.getInt(1));
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
	
	public void update(Categoria categoria) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE categoria set descripcion=? WHERE id_categoria=?");
			stmt.setString(1, categoria.getDescripcion());
			stmt.setInt(2, categoria.getId());
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
	
	public void remove(Categoria categoria) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE from categoria WHERE id_categoria=?");
			stmt.setInt(1, categoria.getId());
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
