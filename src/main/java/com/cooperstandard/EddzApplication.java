package com.cooperstandard;

import com.cooperstandard.config.DataSourceConfiguration;
import com.cooperstandard.dbs.ConexaoSql;
import com.cooperstandard.enumerated.LOOKANDFEEL;
import com.cooperstandard.views.principal.ViewLogin;
import org.flywaydb.core.Flyway;

import javax.swing.UIManager;

public class EddzApplication {

    public static void main(String[] args) {
        new EddzApplication().start();
    }

    void start() {
        changeLoolAndFeel();
        //runMigrations();
        new ViewLogin().setVisible(true);
    }

    private void changeLoolAndFeel() {
        try {
            UIManager.setLookAndFeel(LOOKANDFEEL.WINDOWS.getValor());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void runMigrations() {
        final DataSourceConfiguration dataSource = new ConexaoSql().getDatasource();
        final Flyway flyway = Flyway.configure()
                .dataSource(
                        dataSource.getUrl(),
                        dataSource.getUsername(),
                        dataSource.getPassword()
                )
                .locations("classpath:/db/migration")
                .load();
        flyway.migrate();
    }
}
