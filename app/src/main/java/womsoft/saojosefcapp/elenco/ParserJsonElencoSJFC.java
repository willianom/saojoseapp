package womsoft.saojosefcapp.elenco;

import java.util.ArrayList;

import womsoft.saojosefcapp.jogos.BeanJogosSJFC;

/**
 * Created by Willian.Matos on 09/02/2018.
 */

public class ParserJsonElencoSJFC {

    private ArrayList<BeanElencoSJFC> elenco;

    public ArrayList<BeanElencoSJFC> getElenco() {
        return elenco;
    }

    public void setElenco(ArrayList<BeanElencoSJFC> elenco) {
        this.elenco = elenco;
    }
}
