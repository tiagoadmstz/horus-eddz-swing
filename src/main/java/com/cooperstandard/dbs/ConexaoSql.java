package com.cooperstandard.dbs;

import com.cooperstandard.config.DataSourceConfiguration;
import com.cooperstandard.config.EddzConfiguration;
import lombok.Getter;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import static com.cooperstandard.config.SpringContext.getContext;

/**
 * @author Rafael
 */
public class ConexaoSql {

    @Getter
    private final DataSourceConfiguration datasource;
    private boolean status = false;
    private Connection con = null;  //variavel para conexao
    private Statement statement;
    private ResultSet resultSet;

    public ConexaoSql() {
        this("ficha-controle");
    }

    public ConexaoSql(final String datasourceName) {
        final EddzConfiguration configuration = getContext().getBean(EddzConfiguration.class);
        datasource = configuration.getDatasource().get(datasourceName);
    }

    public Connection conectar() {
        try {
            Class.forName(datasource.getDriver()).newInstance();
            this.setCon(DriverManager.getConnection(
                    datasource.getUrl(),
                    datasource.getUsername(),
                    datasource.getPassword()
            ));
            this.status = true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.getCon();
    }

    public boolean executarSQL(String pSQL) {
        try {
            this.setStatement(getCon().createStatement());
            this.setResultSet(getStatement().executeQuery(pSQL));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean executarUpdateDeleteSQL(String pSQL) {
        try {
            this.setStatement(getCon().createStatement());
            getStatement().executeUpdate(pSQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public int insertSQL(String pSQL) {
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);

            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT SCOPE_IDENTITY();"));

            //recupera o ultimo id inserido
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }

            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    public boolean fecharConexao() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public boolean isStatus() {
        return this.status;
    }

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public Connection getCon() {
        if (Objects.isNull(con)) {
            con = conectar();
        }
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public String getUsuario() {
        return datasource.getUsername();
    }

    public void setUsuario(String usuario) {
        //no content
    }
}
