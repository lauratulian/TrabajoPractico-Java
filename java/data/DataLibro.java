package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import entities.*;

public class DataLibro {
	
	public LinkedList<Libro> getAll(){
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Libro> libros= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("SELECT libro.* FROM libro");
			if(rs!=null) {
				while(rs.next()) {
					Libro libro=new Libro();
					libro.setId(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setDescripcion(rs.getString("descripcion"));
					libro.setIsbn(rs.getString("isbn"));
					libro.setPeso(rs.getString("peso"));
					libro.setIdioma(rs.getString("idioma"));
					libro.setPrecio(rs.getDouble("precio"));
					libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
					libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
					libro.setStock(rs.getInt("stock"));
				 
					Categoria categoriaToSearch = new Categoria();
					DataCategoria dataCategoria = new DataCategoria();
					categoriaToSearch.setId(rs.getInt("categoria"));
					libro.setCategoria(dataCategoria.getById(categoriaToSearch));
					
					Autor autorToSearch = new Autor();
					DataAutor dataAutor = new DataAutor();
					autorToSearch.setId(rs.getInt("autor"));
					libro.setAutor(dataAutor.getById(autorToSearch));
					
					
					Editorial editorialToSearch = new Editorial();
					DataEditorial dataEditorial = new DataEditorial();
					editorialToSearch.setId(rs.getInt("editorial"));
					libro.setEditorial(dataEditorial.getById(editorialToSearch));
					
					libros.add(libro);
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
		
		
		return libros;
	}
	
	public Libro getById(Libro libroToSearch) {
		Libro libro=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM libro WHERE id_libro=?"
					);
			stmt.setInt(1, libroToSearch.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				libro=new Libro();
				libro.setTitulo(rs.getString("titulo"));
				libro.setDescripcion(rs.getString("descripcion"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setPeso(rs.getString("peso"));
				libro.setIdioma(rs.getString("idioma"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
				libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
				libro.setStock(rs.getInt("stock"));
			 
				Categoria categoriaToSearch = new Categoria();
				DataCategoria dataCategoria = new DataCategoria();
				categoriaToSearch.setId(rs.getInt("categoria"));
				libro.setCategoria(dataCategoria.getById(categoriaToSearch));
				
				Autor autorToSearch = new Autor();
				DataAutor dataAutor = new DataAutor();
				autorToSearch.setId(rs.getInt("autor"));
				libro.setAutor(dataAutor.getById(autorToSearch));
				
				
				Editorial editorialToSearch = new Editorial();
				DataEditorial dataEditorial = new DataEditorial();
				editorialToSearch.setId(rs.getInt("editorial"));
				libro.setEditorial(dataEditorial.getById(editorialToSearch));
				
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
		
		return libro;
	}
	
	
	public Libro getByTitulo(Libro libroToSearch) {
		Libro libro=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM libro WHERE titulo=?"
					);
			stmt.setString(1, libroToSearch.getDescripcion());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				libro=new Libro();
				libro.setId(rs.getInt("id_libro"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setDescripcion(rs.getString("descripcion"));
				libro.setIsbn(rs.getString("isbn"));
				libro.setPeso(rs.getString("peso"));
				libro.setIdioma(rs.getString("idioma"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
				libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
				libro.setStock(rs.getInt("stock"));
			 
				Categoria categoriaToSearch = new Categoria();
				DataCategoria dataCategoria = new DataCategoria();
				categoriaToSearch.setId(rs.getInt("categoria"));
				libro.setCategoria(dataCategoria.getById(categoriaToSearch));
				
				Autor autorToSearch = new Autor();
				DataAutor dataAutor = new DataAutor();
				autorToSearch.setId(rs.getInt("autor"));
				libro.setAutor(dataAutor.getById(autorToSearch));
				
				
				Editorial editorialToSearch = new Editorial();
				DataEditorial dataEditorial = new DataEditorial();
				editorialToSearch.setId(rs.getInt("editorial"));
				libro.setEditorial(dataEditorial.getById(editorialToSearch));
				
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
		
		return libro;
	}
	
	public LinkedList<Libro> getByCategoria(Categoria categoria) {
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    LinkedList<Libro> libros = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT libro.* FROM libro INNER JOIN categoria ON libro.categoria = categoria.id_categoria WHERE categoria.id_categoria = ?;"
					);
			stmt.setInt(1, categoria.getId());
		    rs= stmt.executeQuery();
		    while (rs != null && rs.next()) {
				 Libro libro = new Libro();
		            libro.setId(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setDescripcion(rs.getString("descripcion"));
					libro.setIsbn(rs.getString("isbn"));
					libro.setPeso(rs.getString("peso"));
					libro.setIdioma(rs.getString("idioma"));
					libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
					libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
					libro.setStock(rs.getInt("stock"));
					libro.setPrecio(rs.getDouble("precio"));

					categoria.setId(rs.getInt("categoria")); // 
					libro.setCategoria(categoria);
					
					Autor autorToSearch = new Autor();
					autorToSearch.setId(rs.getInt("autor"));
					libro.setAutor(autorToSearch);
					
					
					Editorial editorialToSearch = new Editorial();
					editorialToSearch.setId(rs.getInt("editorial"));
					libro.setEditorial(editorialToSearch);
		            
		            libros.add(libro);
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
		
		return libros;
	}
	
	
	public LinkedList<Libro> getByEditorial(Editorial editorial) {
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    LinkedList<Libro> libros = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT libro.* FROM libro INNER JOIN editorial ON libro.editorial = editorial.id_editorial WHERE editorial.id_editorial = ?"
					);
			stmt.setInt(1, editorial.getId());
		    rs= stmt.executeQuery();
			if(rs!=null && rs.next()) {
				 Libro libro = new Libro();
		            
		            libro.setId(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setDescripcion(rs.getString("descripcion"));
					libro.setIsbn(rs.getString("isbn"));
					libro.setPeso(rs.getString("peso"));
					libro.setIdioma(rs.getString("idioma"));
					libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
					libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
					libro.setStock(rs.getInt("stock"));
					libro.setPrecio(rs.getDouble("precio"));
					
					Categoria categoriaToSearch = new Categoria();
					categoriaToSearch.setId(rs.getInt("categoria"));
					libro.setCategoria(categoriaToSearch);
					
					Autor autorToSearch = new Autor();
					autorToSearch.setId(rs.getInt("autor"));
					libro.setAutor(autorToSearch);
					
					editorial.setId(rs.getInt("editorial"));  
					libro.setEditorial(editorial);
	
					libros.add(libro);
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
		
		return libros;
	}
	
	public LinkedList<Libro> getByAutor(Autor autor) {
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	    LinkedList<Libro> libros = new LinkedList<>();
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT libro.* FROM libro INNER JOIN autor ON libro.autor = autor.id_autor WHERE autor.id_autor = ?"
					);
			stmt.setInt(1, autor.getId());
		    rs= stmt.executeQuery();
			if(rs!=null && rs.next()) {
				 Libro libro = new Libro();
		            
		            libro.setId(rs.getInt("id_libro"));
					libro.setTitulo(rs.getString("titulo"));
					libro.setDescripcion(rs.getString("descripcion"));
					libro.setIsbn(rs.getString("isbn"));
					libro.setPeso(rs.getString("peso"));
					libro.setIdioma(rs.getString("idioma"));
					libro.setFecha_publicacion(rs.getObject("fecha_publicacion", LocalDate.class));
					libro.setCantidad_paginas(rs.getInt("cantidad_paginas"));
					libro.setStock(rs.getInt("stock"));
					libro.setPrecio(rs.getDouble("precio"));
				
					Categoria categoriaToSearch = new Categoria();
					categoriaToSearch.setId(rs.getInt("categoria"));
					libro.setCategoria(categoriaToSearch);
					
					autor.setId(rs.getInt("autor"));  
					libro.setAutor(autor);
					
					Editorial editorialToSearch = new Editorial();
					editorialToSearch.setId(rs.getInt("editorial"));
					libro.setEditorial(editorialToSearch);
					
					
					libros.add(libro);
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
		
		return libros;
	}
	
	public void add(Libro libro) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT into LIBRO(titulo, descripcion, isbn, peso, idioma, fecha_publicacion, cantidad_paginas, stock, precio, categoria, autor, editorial) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, libro.getTitulo());
			stmt.setString(2, libro.getDescripcion());
			stmt.setString(3, libro.getIsbn());
			stmt.setString(4, libro.getPeso());
			stmt.setString(5, libro.getIdioma());
			stmt.setObject(6, libro.getFecha_publicacion());;
			stmt.setInt(7, libro.getCantidad_paginas());
			stmt.setInt(8, libro.getStock());
			stmt.setDouble(9, libro.getPrecio());
			stmt.setInt(10, libro.getCategoria().getId());
		    stmt.setInt(11, libro.getAutor().getId());
		    stmt.setInt(12, libro.getEditorial().getId());
			
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                libro.setId(keyResultSet.getInt(1));
            }
            
            DataAutor dataAutor= new DataAutor();
			dataAutor.setAutor(libro);
			
			DataEditorial dataEditorial= new DataEditorial();
			dataEditorial.setEditorial(libro);
			
			DataCategoria dataCategoria= new DataCategoria();
			dataCategoria.setCategoria(libro);

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
	
	public void update(Libro libro) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"UPDATE libro set titulo = ?, descripcion = ?, isbn = ?, peso = ?, idioma = ?, fecha_publicacion = ?, cantidad_paginas = ?, stock = ?, precio = ?, categoria = ?, autor = ?, editorial = ? WHERE id_libro=?");
			stmt.setString(1, libro.getTitulo());
			stmt.setString(2, libro.getDescripcion());
			stmt.setString(3, libro.getIsbn());
			stmt.setString(4, libro.getPeso());
			stmt.setString(5, libro.getIdioma());
			stmt.setObject(6, libro.getFecha_publicacion());;
			stmt.setInt(7, libro.getCantidad_paginas());
			stmt.setInt(8, libro.getStock());
			stmt.setDouble(9, libro.getPrecio());
			stmt.setInt(10, libro.getCategoria().getId());
			stmt.setInt(11, libro.getAutor().getId());
			stmt.setInt(12, libro.getEditorial().getId());
			stmt.setInt(13, libro.getId());
			
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

	public void remove(Libro libro) {
		PreparedStatement stmt= null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE from libro WHERE id_libro=?");
			stmt.setInt(1, libro.getId());
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
	
	public void actualizarStock(Libro libroToSearch, int cantidad) {
	    Libro libro = this.getById(libroToSearch);
	    
	    if (libro != null) {
	        int stockActual = libro.getStock();
	        int nuevoStock = stockActual - cantidad;
	        
	        try {
	            PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(
	                    "UPDATE libro SET stock = ? WHERE id_libro = ?"
	            );
	            stmt.setInt(1, nuevoStock);
	            stmt.setInt(2, libroToSearch.getId());
	            stmt.executeUpdate();
	            stmt.close();
	            DbConnector.getInstancia().releaseConn();
	            
	            libro.setStock(nuevoStock);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}
