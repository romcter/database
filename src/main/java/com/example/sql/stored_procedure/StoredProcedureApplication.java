package com.example.sql.stored_procedure;

import com.example.sql.app.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class StoredProcedureApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(StoredProcedureApplication.class, args);

        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);

        jdbcTemplate.update(
                "DROP FUNCTION SelectAllPersons();" +

                        "CREATE OR REPLACE FUNCTION SelectAllPersons()\n" +
                        "    RETURNS TABLE\n" +
                        "            (\n" +
                        "                id      bigint,\n" +
                        "                created timestamp(6),\n" +
                        "                deleted timestamp(6),\n" +
                        "                name    VARCHAR(255),\n" +
                        "                updated timestamp(6)\n" +
                        "            )\n" +
                        "    LANGUAGE plpgsql\n" +
                        "AS\n" +
                        "$$\n" +
                        "BEGIN\n" +
                        "    RETURN QUERY SELECT * FROM person;\n" +
                        "END;\n" +
                        "$$;");

//                "CREATE PROCEDURE SelectAllPerson AS SELECT * FROM person GO;");

        List<Person> persons = jdbcTemplate.query(
                "SELECT * FROM SelectAllPersons();", new PersonRowMapper());

        System.out.println();
        System.out.println("==========================================\n" + persons.stream().map((it)-> "\n" + it.toString()).toList() + "\n==========================================");
//        System.out.println("==========================================");
    }
}
