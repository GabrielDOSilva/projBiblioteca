package biblioteca.model;

import java.io.Serializable;

public class ModelLivro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String titulo;
	private String autor;
	private String genero;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String editora;

	public boolean isNovo() {
		if (this.id == null) {
			return true;
		} else if (this.id != null && this.id > 0) {
			return false;
		}
		return id == null;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
