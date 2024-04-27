package com.cooperstandard.services;

import com.cooperstandard.services.rest.UserRestService;
import com.cooperstandard.views.extrusao.ViewExtrusao;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class ExtrusionService {

    private final Map<String, JMenuItem> permissions = new HashMap<>(1);
    private final UserRestService userRestService;

    public ExtrusionService(final ViewExtrusao viewExtrusao) {
        this.permissions.put("MenuRelatorio", viewExtrusao.getJMenuItem18());
        this.permissions.put("Validacao", viewExtrusao.getJMenuItem10());
        this.permissions.put("AlteracaoDados", viewExtrusao.getAlteracaoDados());
        this.permissions.put("EntradaDadosEX", viewExtrusao.getEntradaDadosEX());
        this.permissions.put("EntradaDadosAC", viewExtrusao.getEntradaDadosAC());
        this.permissions.put("EntradaDadosSuperV", viewExtrusao.getEntradaDadosSuperV());
        this.permissions.put("CadastroFichaAC", viewExtrusao.getCadastroFichaAC());
        this.permissions.put("CadastroFichaEX", viewExtrusao.getCadastroFichaEX());
        this.permissions.put("PainelAlteracaoAC", viewExtrusao.getPainelAlteracaoAC());
        this.permissions.put("PainelAlteracaoEX", viewExtrusao.getPainelAlteracaoEX());
        this.permissions.put("PainelAlteracaoQU", viewExtrusao.getPainelAlteracaoQU());
        this.permissions.put("PainelAlteracaoAT", viewExtrusao.getPainelAlteracaoAT());
        this.permissions.put("MenuUsuario", viewExtrusao.getJMenuItem40());
        this.permissions.put("AcompanhamentoDDZ", viewExtrusao.getJMenuItem23());
        this.userRestService = new UserRestService();
    }

    public String getLine() {
        return userRestService.findLineByUser();
    }

    public void liberarModulos() {
        userRestService.findPermissionsByUser().forEach(permission -> {
            if (permissions.containsKey(permission)) permissions.get(permission).setEnabled(true);
        });
    }
}
