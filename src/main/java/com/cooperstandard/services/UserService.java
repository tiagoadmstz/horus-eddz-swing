package com.cooperstandard.services;

import com.cooperstandard.model.ModelPermissaousuario;
import com.cooperstandard.model.ModelUsuario;
import com.cooperstandard.services.rest.UserRestService;
import com.cooperstandard.views.principal.ViewUsuario;
import org.springframework.web.client.RestClientException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {

    private final Map<String, JCheckBox> permissions = new HashMap<>(1);
    private final UserRestService userRestService;

    public UserService(final ViewUsuario viewUsuario) {
        this.userRestService = new UserRestService();
        this.permissions.put("PainelAlteracaoAC", viewUsuario.getJbcPainelAlteracaoAC());
        this.permissions.put("PainelAlteracaoEX", viewUsuario.getJbcPainelAlteracaoEX());
        this.permissions.put("PainelAlteracaoQU", viewUsuario.getJbcPainelAlteracaoQU());
        this.permissions.put("PainelAlteracaoAT", viewUsuario.getJbcPainelAlteracaoAT());
        this.permissions.put("PainelAlteracaoInsp", viewUsuario.getJbcPainelAlteracaoInsp());
        this.permissions.put("CadastroFichaAC", viewUsuario.getJcbCadastroFichaAC());
        this.permissions.put("CadastroFichaEX", viewUsuario.getJcbCadastroFichaEX());
        this.permissions.put("CadastroFichaInsp", viewUsuario.getJcbCadastroFichaInsp());
        this.permissions.put("EntradaDadosAC", viewUsuario.getJcbEntradaDadosAC());
        this.permissions.put("EntradaDadosEX", viewUsuario.getJcbEntradaDadosEX());
        this.permissions.put("EntradaDadosSuperV", viewUsuario.getJcbEntradaDadosSuperV());
        this.permissions.put("EntradaDadosInsp", viewUsuario.getJcbEntradaDadosInspeção());
        this.permissions.put("AlteracaoDados", viewUsuario.getJcbAlteracaoDados());
        this.permissions.put("Validacao", viewUsuario.getJcbValidacao());
        this.permissions.put("MenuRelatorio", viewUsuario.getJcbRelatorio());
        this.permissions.put("MenuUsuario", viewUsuario.getJcbUsuario());
    }

    public void carregarUsuarios(final JTable tbUsuario) {
        final List<ModelUsuario> userList = userRestService.findAll();
        final DefaultTableModel tableModel = (DefaultTableModel) tbUsuario.getModel();
        tableModel.setNumRows(0);
        userList.forEach(user ->
                tableModel.addRow(new Object[]{
                        user.getCodigo(),
                        user.getNome(),
                        user.getLogin(),
                        user.getSetor(),
                        user.getPlanta(),
                        user.getEmail()
                })
        );
    }

    public boolean recuperarUsuario(final ViewUsuario viewUsuario, final JTable userTable) {
        try {
            final int selectedLine = userTable.getSelectedRow();
            final int selectedUserId = (Integer) userTable.getValueAt(selectedLine, 0);
            final ModelUsuario modelUsuario = userRestService.findUserById(selectedUserId);
            viewUsuario.getJtfCodigo().setText(String.valueOf(modelUsuario.getCodigo()));
            viewUsuario.getJtfNome().setText(modelUsuario.getNome());
            viewUsuario.getJtfLogin().setText(modelUsuario.getLogin());
            viewUsuario.getJtfSenha().setText(modelUsuario.getSenha());
            viewUsuario.getJtfConfirmarSenha().setText(modelUsuario.getSenha());
            viewUsuario.getCbSetor().setSelectedItem(modelUsuario.getSetor());
            viewUsuario.getJtfNome1().setText(modelUsuario.getSobrenome());
            viewUsuario.getJComboBox1().setSelectedItem(modelUsuario.getPlanta());
            viewUsuario.getTxtEmail().setText(modelUsuario.getEmail());
            modelUsuario.getPermissions().forEach(permission -> {
                if (permissions.containsKey(permission.getPermissao()))
                    permissions.get(permission.getPermissao()).setSelected(true);
            });
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(viewUsuario, "Código inválido ou nenhum registro selecionado", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public boolean saveUser(final ModelUsuario userDto) {
        final List<ModelPermissaousuario> permissaousuarioList = permissions.entrySet().stream()
                .filter(entry -> entry.getValue().isSelected())
                .map(entry -> new ModelPermissaousuario(entry.getKey()))
                .collect(Collectors.toList());
        userDto.setPermissions(permissaousuarioList);
        return userRestService.saveUser(userDto).getCodigo() > 0;
    }

    public boolean updateUser(final ModelUsuario userDto) {
        try {
            userRestService.saveUser(userDto);
            return true;
        } catch (RestClientException restClientException) {
            return false;
        }
    }

    public boolean deleteUser(final int userId) {
        userRestService.deleteUser(userId);
        return true;
    }

    public List<ModelPermissaousuario> setardadosPermissaoUsuario(int pCodigoUsuario) {
        return permissions.entrySet().stream()
                .filter(permission -> permission.getValue().isSelected())
                .map(entry -> new ModelPermissaousuario(pCodigoUsuario, entry.getKey()))
                .collect(Collectors.toList());
    }

    public void deletePermissionByUserId(final int userId) {
        userRestService.deletePermissionByUserId(userId);
    }
}
