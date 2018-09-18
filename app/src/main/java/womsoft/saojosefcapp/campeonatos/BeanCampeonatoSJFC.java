package womsoft.saojosefcapp.campeonatos;

/**
 * Created by Willian.Matos on 04/02/2018.
 */

public class BeanCampeonatoSJFC {

    private String nome_campeonato;
    private String id_campeonato;
    private String data_inicio;
    private String atual_campeao;

    public String getNome_campeonato() {
        return nome_campeonato;
    }

    public void setNome_campeonato(String nome_campeonato) {
        this.nome_campeonato = nome_campeonato;
    }

    public String getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(String id_campeonato) {
        this.id_campeonato = id_campeonato;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getAtual_campeao() {
        return atual_campeao;
    }

    public void setAtual_campeao(String atual_campeao) {
        this.atual_campeao = atual_campeao;
    }
}
