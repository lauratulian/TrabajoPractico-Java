package entities;

import java.time.LocalDate;

public class Libro {
	private int id;
	private String titulo;
	private String descripcion;
	private String isbn;
	private String peso;
	private String idioma;
	private LocalDate fecha_publicacion;
	private int cantidad_paginas;
	private int stock;
	private double precio;
	private Categoria categoria;
	private Editorial editorial;
	private Autor autor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public LocalDate getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(LocalDate fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public int getCantidad_paginas() {
		return cantidad_paginas;
	}
	public void setCantidad_paginas(int cantidad_paginas) {
		this.cantidad_paginas = cantidad_paginas;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", isbn=" + isbn + ", peso="
				+ peso + ", idioma=" + idioma + ", fecha_publicacion=" + fecha_publicacion + ", cantidad_paginas="
				+ cantidad_paginas + ", stock=" + stock + ", precio=" + precio + ", categoria=" + categoria
				+ ", editorial=" + editorial + ", autor=" + autor + "]\n";
	}
}
