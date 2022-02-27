package com.mirena.covid19;

public class Municipio {

    private int id;
    private int codigo_municipio;
    private String municipio;
    private long casos_pcr;
    private float incidencia_acumulada;
    private long casos_pcr_14_dias;
    private float incidencia_acumulada_14_dias;
    private int defunciones;
    private float tasa_defuncion;

    public Municipio(int id, long casos_pcr) {
        this.id = id;
        this.casos_pcr = casos_pcr;
    }

    public Municipio(int id) {
        this.id = id;

    }

    public Municipio(int id, int codigo_municipio, String municipio, long casos_pcr, float incidencia_acumulada, long casos_pcr_14_dias, float incidencia_acumulada_14_dias, int defunciones, float tasa_defuncion) {
        this.id = id;
        this.codigo_municipio = codigo_municipio;
        this.municipio = municipio;
        this.casos_pcr = casos_pcr;
        this.incidencia_acumulada = incidencia_acumulada;
        this.casos_pcr_14_dias = casos_pcr_14_dias;
        this.incidencia_acumulada_14_dias = incidencia_acumulada_14_dias;
        this.defunciones = defunciones;
        this.tasa_defuncion = tasa_defuncion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_municipio() {
        return codigo_municipio;
    }

    public void setCodigo_municipio(int codigo_municipio) {
        this.codigo_municipio = codigo_municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public long getCasos_pcr() {
        return casos_pcr;
    }

    public void setCasos_pcr(long casos_pcr) {
        this.casos_pcr = casos_pcr;
    }

    public float getIncidencia_acumulada() {
        return incidencia_acumulada;
    }

    public void setIncidencia_acumulada(float incidencia_acumulada) {
        this.incidencia_acumulada = incidencia_acumulada;
    }

    public long getCasos_pcr_14_dias() {
        return casos_pcr_14_dias;
    }

    public void setCasos_pcr_14_dias(long casos_pcr_14_dias) {
        this.casos_pcr_14_dias = casos_pcr_14_dias;
    }

    public float getIncidencia_acumulada_14_dias() {
        return incidencia_acumulada_14_dias;
    }

    public void setIncidencia_acumulada_14_dias(float incidencia_acumulada_14_dias) {
        this.incidencia_acumulada_14_dias = incidencia_acumulada_14_dias;
    }

    public int getDefunciones() {
        return defunciones;
    }

    public void setDefunciones(int defunciones) {
        this.defunciones = defunciones;
    }

    public float getTasa_defuncion() {
        return tasa_defuncion;
    }

    public void setTasa_defuncion(float tasa_defuncion) {
        this.tasa_defuncion = tasa_defuncion;
    }
}
