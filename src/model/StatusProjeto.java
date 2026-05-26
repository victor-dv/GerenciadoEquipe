package model;

public enum StatusProjeto {
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em Andamento"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private String descricao;

    StatusProjeto(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusProjeto fromString(String text) {
        for (StatusProjeto s : StatusProjeto.values()) {
            if (s.descricao.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return PLANEJADO;
    }
}
