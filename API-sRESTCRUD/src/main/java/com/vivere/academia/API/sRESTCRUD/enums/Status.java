//package com.vivere.academia.API.sRESTCRUD.enums;
//
//import javax.persistence.Column;
//
//public enum Status {
//
//    A("A","A"),
//    C("C","Cancelado");
//
//    private String descricao;
//    private String tipo;
//
//    private Status(String tipo, String descricao) {
//        this.tipo = tipo;
//        this.descricao = descricao;
//    }
//
//
//
//
//    public String getTipo() {
//        return tipo;
//    }
//
//
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
//
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//
//    public static Status toEnum(String tipo) {
//        if (tipo == null) {
//            return null;
//        }
//
//        for(Status x : Status.values()) {
//            if(tipo.equals(x.getTipo())) {
//                return x;
//            }
//        }
//
//        throw new IllegalArgumentException("Acesso inválido");
//    }
//
//}
