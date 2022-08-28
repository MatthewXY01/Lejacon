package edu.lejacon.services;
import com.alibaba.druid.DbType;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;
public class APPSQLParser {
    static int serviceFuncNum = 3;

    public void run(){
        System.out.println("run app-sqlparser.");
        String sql = "sELECT * FROM JJJ WHERE LI=1 And moile='13261' And id In(selecT jj_id from jk where l=1 group by j having count(jj_id)>1) LIMIT 10,33\n";
        parseSqlService("select user from emp_table", "MySQL");
        boolean ok = verifySqlService(sql);
        String result = formatSqlService(sql);
        System.out.println("verify result is: " + String.valueOf(ok));
        System.out.println("format result is:\n" + result);
        System.out.println("finish app-sqlparser.");
    }
    public int getServiceFuncNum(){return serviceFuncNum;}
    public void parseSqlService(String sql, String dbType) {
        DbType dbDruidType = null;
        if ("MySQL".equals(dbType)) {
            dbDruidType = JdbcConstants.MYSQL;
        }
        String result = SQLUtils.format(sql, dbDruidType);
        System.out.println(result);
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, dbDruidType);
        for (int i = 0; i < stmtList.size(); i++) {
            SQLStatement stmt = stmtList.get(i);
            MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
            stmt.accept(visitor);
            System.out.println("Manipulation : " + visitor.getTables());
            System.out.println("fields : " + visitor.getColumns());
        }
    }

    public boolean verifySqlService(String sql) {
        MySqlStatementParser parser = new MySqlStatementParser(sql);
        boolean flag = true;
        try {
            List<SQLStatement> smtList = parser.parseStatementList();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

    public String formatSqlService(String sql) {
        verifySqlService(sql);
        String formatSql = SQLUtils.formatMySql(sql);
        if (!sql.equals(formatSql)) {
            return formatSql;
        }
        return null;
    }

    public static void main(String[] args) {
        APPSQLParser appsqlParser = new APPSQLParser();
        appsqlParser.run();
    }
}
