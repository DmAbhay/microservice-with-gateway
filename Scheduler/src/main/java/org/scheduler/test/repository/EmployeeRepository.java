package org.scheduler.test.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    @Autowired
    private NamedParameterJdbcTemplate npjt;


    public List<Map<String, Object>> getEmployeesWithTodayBirthday() {
        String sql = """
                SELECT *
                FROM employeeBirthDay
                WHERE FORMAT(birthday, 'MMM-dd') = FORMAT(GETDATE(), 'MMM-dd')
                """;

        return npjt.queryForList(sql, Map.of());
    }

    public String getBirthDayTemplate() {
        String sql = "SELECT message FROM template WHERE template_name = 'Birthday Wish'";
        return npjt.queryForObject(sql, Map.of(), String.class);
    }

    public String getCronTimeFromDatabase() {
        String sql = "SELECT scheduled_time FROM template WHERE template_name = 'Birthday Wish'";
        return npjt.queryForObject(sql, Map.of(), String.class);  // Example: "15:19"
    }


    public String getCronCronExpressionFromDatabase() {
        String sql = "SELECT cron_expression FROM template WHERE template_name = 'Birthday Wish'";
        return npjt.queryForObject(sql, Map.of(), String.class);  // Example: "15:19"
    }



}
