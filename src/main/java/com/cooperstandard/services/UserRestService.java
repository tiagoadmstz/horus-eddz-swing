package com.cooperstandard.services;

import com.cooperstandard.model.ModelSessaoUsuario;
import com.cooperstandard.views.extrusao.ViewExtrusao;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRestService extends AbstractRestService {

    private final Map<String, JMenuItem> permissions = new HashMap<>(1);

    public UserRestService(final ViewExtrusao viewExtrusao) {
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
    }

    public String configureLine() {
        final ResponseEntity<String> response = restTemplate.getForEntity(
                String.format("%s/user/line/{1}", BASE_URL),
                String.class,
                ModelSessaoUsuario.nome
        );
        return response.getBody();
    }

    public void liberarModulos() {
        final ResponseEntity<List<String>> response = restTemplate.exchange(
                String.format("%s/user/permissions/{1}", BASE_URL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                },
                ModelSessaoUsuario.codigo
        );
        response.getBody().forEach(permission -> {
            if (permissions.containsKey(permission)) permissions.get(permission).setEnabled(true);
        });
    }
}
