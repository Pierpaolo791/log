package com.olimpia.registro.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="iscritti")
public class Iscritto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name="cognome")
    private String cognome;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="nascita")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nascita;
    
    @Column(name="genere")
    private char genere;
    
    @Column(name="email")
    private String email;
    
    @Column(name="cellulare")
    private String cellulare;
    
    @Column(name="iscrizione")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date iscrizione;
    
    @Column(name="scadenza")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date scadenza;
    
    @Column(name="foto")
    private String foto;
    
    @Column(name="note")
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascita() {
        return nascita;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public char getGenere() {
        return genere;
    }

    public void setGenere(char genere) {
        this.genere = genere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public Date getIscrizione() {
        return iscrizione;
    }

    public void setIscrizione(Date iscrizione) {
        this.iscrizione = iscrizione;
    }

    public Date getScadenza() {
        return scadenza;
    }
    
    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    private boolean isStatus() {
        return !(new Date().after(scadenza));
    }
    
    public String getStatus() {
        String x = "<font color=\"red\">Scaduto</font>"; // FF2E02 color
        if (isStatus()) x = "Attivo"; // 
        return x;
    }
    public void update(Iscritto x) {
        cognome = x.getCognome(); 
    }

    
}
