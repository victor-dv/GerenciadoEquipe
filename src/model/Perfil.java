package model;

public enum Perfil {
    ADMINISTRADOR("Administrador"),
    GERENTE("Gerente"),
    COLABORADOR("Colaborador");

    private String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil fromString(String text) {
        for (Perfil p : Perfil.values()) {
            if (p.descricao.equalsIgnoreCase(text)) {
                return p;
            }
        }
        return COLABORADOR;
    }
}
