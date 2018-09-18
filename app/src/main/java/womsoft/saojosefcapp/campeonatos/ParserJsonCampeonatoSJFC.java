package womsoft.saojosefcapp.campeonatos;

import java.util.ArrayList;

import womsoft.saojosefcapp.jogos.BeanJogosSJFC;

/**
 * Created by Willian.Matos on 04/02/2018.
 */

public class ParserJsonCampeonatoSJFC {

    private ArrayList<BeanCampeonatoSJFC> campeonato;

    public ArrayList<BeanCampeonatoSJFC> getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(ArrayList<BeanCampeonatoSJFC> campeonato) {
        this.campeonato = campeonato;
    }
}
