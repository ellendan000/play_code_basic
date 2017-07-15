package net.shadow.with_spring.configuration;

import net.shadow.with_spring.Application;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import java.net.ConnectException;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleLiquibaseApplicationTest {
    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testDefaultSettings() throws Exception {
        try {
            Application.main(new String[]{"--server.port=0"});
        } catch (IllegalStateException ex) {
            if (serverNotRunning(ex)) {
                return;
            }
        }
        String output = this.outputCapture.toString();
        assertThat(output).contains("Successfully acquired change log lock")
                .contains("Creating database history "
                        + "table with name: PUBLIC.DATABASECHANGELOG")
                .contains("Table user created")
                .contains("ChangeSet classpath:/db/"
                        + "changelog/1.0/Create_table_user.yaml::1::"
                        + "elledan ran successfully")
                .contains("New row inserted into user")
                .contains("ChangeSet classpath:/db/changelog/"
                        + "1.0/Insert_initial_data_into_table_user.yaml::2::"
                        + "ellendan ran successfully")
                .contains("Successfully released change log lock");
    }

    @SuppressWarnings("serial")
    private boolean serverNotRunning(IllegalStateException ex) {
        NestedCheckedException nested = new NestedCheckedException("failed", ex) {
        };
        if (nested.contains(ConnectException.class)) {
            Throwable root = nested.getRootCause();
            if (root.getMessage().contains("Connection refused")) {
                return true;
            }
        }
        return false;
    }
}
