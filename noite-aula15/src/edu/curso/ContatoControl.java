package edu.curso;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContatoControl {
	private ObservableList<Contato> lista = FXCollections.observableArrayList();
	
	private LongProperty idProperty = new SimpleLongProperty(0);
	private StringProperty nomeProperty = new SimpleStringProperty("Jo?o");
	private StringProperty telefoneProperty = new SimpleStringProperty("(11)    -    ");
	private StringProperty emailProperty = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> nascimentoProperty = new SimpleObjectProperty<>(LocalDate.now());
	private ContatoDAO contatoDAO = new ContatoDAOImpl();
	
	public Contato getContato() { 
		Contato c = new Contato();
		c.setId(idProperty.get());
		c.setNome(nomeProperty.get());
		c.setTelefone(telefoneProperty.get());
		c.setEmail(emailProperty.get());
		c.setNascimento(nascimentoProperty.get());
		return c;
	}
	
	public void setContato(Contato c) { 
		if (c != null)  { 
			idProperty.set(c.getId());
			nomeProperty.set(c.getNome());
			telefoneProperty.set(c.getTelefone());
			emailProperty.set(c.getEmail());
			nascimentoProperty.set(c.getNascimento());
		}
	}
	
	public void adicionar() throws ContatoException { 
		contatoDAO.adicionar(getContato());
	}
	
	public void pesquisarPorNome() throws ContatoException {
		List<Contato> contatos = contatoDAO.pesquisarPorNome(this.getNomeProperty().get());
		this.lista.clear();
		this.lista.addAll(contatos);
	}
	
	public LongProperty getIdProperty() {
		return idProperty;
	}
	public StringProperty getNomeProperty() {
		return nomeProperty;
	}
	public StringProperty getTelefoneProperty() {
		return telefoneProperty;
	}
	public StringProperty getEmailProperty() {
		return emailProperty;
	}
	public ObjectProperty<LocalDate> getNascimentoProperty() {
		return nascimentoProperty;
	}

	public ObservableList<Contato> getLista() {
		return lista;
	}
}
