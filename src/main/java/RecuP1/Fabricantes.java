package RecuP1;
// Generated 20 abr 2024 13:25:01 by Hibernate Tools 5.6.15.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Fabricantes generated by hbm2java
 */
public class Fabricantes implements java.io.Serializable {

	private String codFab;
	private String nombre;
	private String pais;
	private Set programases = new HashSet(0);

	public Fabricantes() {
	}

	public Fabricantes(String codFab) {
		this.codFab = codFab;
	}

	public Fabricantes(String codFab, String nombre, String pais, Set programases) {
		this.codFab = codFab;
		this.nombre = nombre;
		this.pais = pais;
		this.programases = programases;
	}

	public String getCodFab() {
		return this.codFab;
	}

	public void setCodFab(String codFab) {
		this.codFab = codFab;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set getProgramases() {
		return this.programases;
	}

	public void setProgramases(Set programases) {
		this.programases = programases;
	}

}
