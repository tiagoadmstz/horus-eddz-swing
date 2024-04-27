package com.cooperstandard.reports.factorys;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author rsouza10
 */
@Data
@NoArgsConstructor
public class SelfLifeBean implements Serializable {

    private Integer dias = 0;
    private String DATA, HORA, RCPERFIL, BPCS, N_ETIQUETA, LINHA, TIPOTESTE,
            TMV, EMV_MIN, EMV_MAX, TT5, ET5_MIN, ET5_MAX, TTS2, ETS2_MIN, ETS2_MAX, TT90, ET90_MIN, ET90_MAX,
            TDENS, EDENS_MIN, EDENS_MAX, TML, EML_MIN, EML_MAX, TMH, EMH_MIN, EMH_MAX, EC_CHART, EBLOOMING, OBS, USUARIO, PLANTA;

    public SelfLifeBean(String DATA, String HORA, String RCPERFIL, String BPCS, String N_ETIQUETA, String LINHA, String TIPOTESTE, String TMV, String EMV_MIN, String EMV_MAX, String TT5, String ET5_MIN, String ET5_MAX, String TTS2, String ETS2_MIN, String ETS2_MAX, String TT90, String ET90_MIN, String ET90_MAX, String TDENS, String EDENS_MIN, String EDENS_MAX, String TML, String EML_MIN, String EML_MAX, String TMH, String EMH_MIN, String EMH_MAX, String EC_CHART, String EBLOOMING, String OBS, String USUARIO, String PLANTA) {
        this.DATA = DATA;
        this.HORA = HORA;
        this.RCPERFIL = RCPERFIL;
        this.BPCS = BPCS;
        this.N_ETIQUETA = N_ETIQUETA;
        this.LINHA = LINHA;
        this.TIPOTESTE = TIPOTESTE;
        this.TMV = TMV;
        this.EMV_MIN = EMV_MIN;
        this.EMV_MAX = EMV_MAX;
        this.TT5 = TT5;
        this.ET5_MIN = ET5_MIN;
        this.ET5_MAX = ET5_MAX;
        this.TTS2 = TTS2;
        this.ETS2_MIN = ETS2_MIN;
        this.ETS2_MAX = ETS2_MAX;
        this.TT90 = TT90;
        this.ET90_MIN = ET90_MIN;
        this.ET90_MAX = ET90_MAX;
        this.TDENS = TDENS;
        this.EDENS_MIN = EDENS_MIN;
        this.EDENS_MAX = EDENS_MAX;
        this.TML = TML;
        this.EML_MIN = EML_MIN;
        this.EML_MAX = EML_MAX;
        this.TMH = TMH;
        this.EMH_MIN = EMH_MIN;
        this.EMH_MAX = EMH_MAX;
        this.EC_CHART = EC_CHART;
        this.EBLOOMING = EBLOOMING;
        this.OBS = OBS;
        this.USUARIO = USUARIO;
        this.PLANTA = PLANTA;
    }

}
