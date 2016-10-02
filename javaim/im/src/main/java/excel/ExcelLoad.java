package excel;


import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrgDescription;
import org.apache.poi.ss.usermodel.*;
import util.ObjectMapperSingle;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;

/**
 * Created by dell on 2016/9/19.
 */
public class ExcelLoad {
    public static void main(String[] args) {
        makeByExcelV2();
    }

    public static void makeByExcelV2(){
        try {
            String url="jdbc:mysql://192.168.20.250:3306/yqb?user=xlingmao&password=xlingmao&characterEncoding=utf8";
            Class.forName("com.mysql.jdbc.Driver");
            ObjectMapper objectMapper = ObjectMapperSingle.getInstance();
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into YQB_ORG (org_name, member_id,category_id, province_id, region_id,address, sort, `status`,phone, contact_name, descriptions,create_time, update_time, creator, updater, `version`)values";


            URL file = ExcelLoad.class.getClassLoader().getResource("org.xlsx");
            File files = new File(file.getPath());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(files));

            Workbook wb = WorkbookFactory.create(inputStream);

            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.getRow(0);
            for(int i =1 ;i <= rowNum ;i++){
                String sqlString = "(";
                Row eachRow = sheet.getRow(i);
                if(eachRow.getCell(1) == null ) continue;
                String orgName = eachRow.getCell(1).getStringCellValue();
                String memberId = "0";
                String categoryId = "0";
                String pid = String.valueOf(eachRow.getCell(0).getNumericCellValue());
                String rid = "0";
                if(eachRow.getCell(0).getNumericCellValue() == 1){
                    rid = "1";
                }else if(eachRow.getCell(0).getNumericCellValue() == 9){
                    rid = "123";
                }
                String address = eachRow.getCell(5).getStringCellValue();
                String sort = "0";
                String status = "A";
                String phone = "";
                String webUrl = "无";
                try {
                    phone = String.valueOf(new BigDecimal(String.valueOf(eachRow.getCell(3).getNumericCellValue())).longValue());
                }catch (Exception e){
                    phone = eachRow.getCell(3) == null ? "无" :String.valueOf(eachRow.getCell(3).getStringCellValue());
                }

                OrgDescription orgDescription = new OrgDescription();
                orgDescription.setFundType("非公募");
                orgDescription.setLogNumber("无");
                orgDescription.setManagerOrgans("");
                orgDescription.setPhone(phone);
                orgDescription.setWebUrl(webUrl);
                String descriptions = objectMapper.writeValueAsString(orgDescription);
                descriptions = descriptions.replaceAll("\"","\\\\\"");
                String createTime = String.valueOf(System.currentTimeMillis());
                String upTime = String.valueOf(System.currentTimeMillis());
                String creator = "system";
                String updater = "system";
                String version = "0";
                String conName = eachRow.getCell(2).getStringCellValue();
                sqlString  +=
                        "\'"+ orgName + "\','"
                                + memberId + "\','"
                                + categoryId
                                + "\','"
                                + pid + "\','"
                                + rid + "\','"
                                + address + "\','"
                                + sort + "\','"
                                + status + "\','"
                                + phone + "\','"
                                + conName +"\','"
                                + descriptions + "\','"
                                + createTime + "\','"
                                + upTime + "\','"
                                + creator + "\','"
                                + updater + "\','"
                                + version + "\'";
                sqlString += "),";

                sql += sqlString;
            }

            sql = sql.substring(0,sql.length() - 1);
            System.out.println(sql);
            PreparedStatement pst = conn.prepareStatement(sql);

            boolean res = pst.execute();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void makeByExcelV1(){
        try {
            String url="jdbc:mysql://192.168.20.250:3306/yqb?user=xlingmao&password=xlingmao&characterEncoding=utf8";
            Class.forName("com.mysql.jdbc.Driver");
            ObjectMapper objectMapper = ObjectMapperSingle.getInstance();
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into YQB_ORG (org_name, member_id,category_id, province_id, region_id,address, sort, `status`,phone, contact_name, descriptions,create_time, update_time, creator, updater, `version`)values";


            URL file = ExcelLoad.class.getClassLoader().getResource("org.xlsx");
            File files = new File(file.getPath());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(files));

            Workbook wb = WorkbookFactory.create(inputStream);

            Sheet sheet = wb.getSheetAt(33);//32青海
            int rowNum = sheet.getLastRowNum();
            Row row = sheet.getRow(0);
            for(int i =1 ;i <= rowNum ;i++){
                String sqlString = "(";
                Row eachRow = sheet.getRow(i);
                if(eachRow.getCell(1) == null ) continue;
                String orgName = eachRow.getCell(1).getStringCellValue();
                String memberId = "0";
                String categoryId = "0";
                String pid = "31";
                String rid = "0";
                String address = "";
                String sort = "0";
                String status = "A";
                String phone = "";
                String webUrl = "";
                try {
                    phone = String.valueOf(new BigDecimal(String.valueOf(eachRow.getCell(6).getNumericCellValue())).longValue());
                    webUrl = eachRow.getCell(7).getStringCellValue();
                }catch (Exception e){
                    phone = eachRow.getCell(6) == null ? "无" :String.valueOf(eachRow.getCell(6).getStringCellValue());
                }

                OrgDescription orgDescription = new OrgDescription();
                orgDescription.setFundType(eachRow.getCell(5) == null ? "非公募":eachRow.getCell(5).getStringCellValue());
                try {
                    orgDescription.setLogNumber(String.valueOf((int)eachRow.getCell(4).getNumericCellValue()));
                }catch (Exception e){
                    orgDescription.setLogNumber(eachRow.getCell(4) == null ? "无":eachRow.getCell(4).getStringCellValue());
                }
                orgDescription.setManagerOrgans(eachRow.getCell(2) == null ? "无" : eachRow.getCell(2).getStringCellValue()+ ";" + eachRow.getCell(3).getStringCellValue());
                orgDescription.setPhone(phone);
                orgDescription.setWebUrl(webUrl);
                String descriptions = objectMapper.writeValueAsString(orgDescription);
                descriptions = descriptions.replaceAll("\"","\\\\\"");
                String createTime = String.valueOf(System.currentTimeMillis());
                String upTime = String.valueOf(System.currentTimeMillis());
                String creator = "system";
                String updater = "system";
                String version = "0";
                sqlString  +=
                        "\'"+ orgName + "\','"
                                + memberId + "\','"
                                + categoryId
                                + "\','"
                                + pid + "\','"
                                + rid + "\','"
                                + address + "\','"
                                + sort + "\','"
                                + status + "\','"
                                + phone + "\','"
                                + "无" +    "\','"
                                + descriptions + "\','"
                                + createTime + "\','"
                                + upTime + "\','"
                                + creator + "\','"
                                + updater + "\','"
                                + version + "\'";
                sqlString += "),";

                sql += sqlString;
            }

            sql = sql.substring(0,sql.length() - 1);
            System.out.println(sql);
            PreparedStatement pst = conn.prepareStatement(sql);

            boolean res = pst.execute();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
