package excel;


import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrgDescription;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import util.ObjectMapperSingle;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dell on 2016/9/19.
 */
public class ExcelLoad {
    public static void main(String[] args) {
        System.out.println( (int) ((new Random().nextDouble() * 1000) + 50 ));
        //makeExcel4();
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

    public static void makeByExcelV3(){
        String url="jdbc:mysql://192.168.20.250:3306/yqb?user=xlingmao&password=xlingmao&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ObjectMapper objectMapper = ObjectMapperSingle.getInstance();
            Connection conn = DriverManager.getConnection(url);
            String sql = "select id,org_name,category_id from YQB_ORG";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            List<String> headers =  new ArrayList<String>();
            headers.add("组织名");
            headers.add("分类1-尊老,2-爱幼,3-助残,4-其他");
            String fileName = new String("org.xls".getBytes(),"utf-8");
            List<List<String>> data = new ArrayList<List<String>>();
            while (res.next()){
                List<String> innerList = new ArrayList<>();
                int id = res.getInt("id");
                String orgName = res.getString("org_name");
                int cateId = res.getInt("category_id");

                innerList.add(Integer.toString(id));
                innerList.add(orgName);
                innerList.add(Integer.toString(cateId));
                data.add(innerList);
            }
            fileName = new String(fileName.getBytes(),"iso8859-1");
            HSSFWorkbook workbook = exportExcel(headers, data);
            BufferedOutputStream ouputStream = new BufferedOutputStream(new FileOutputStream(fileName));
            workbook.write(ouputStream);
            ouputStream.flush();
            ouputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void makeExcel4(){
        String url="jdbc:mysql://192.168.20.250:3306/yqb?user=xlingmao&password=xlingmao&characterEncoding=utf8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url);
            URL file = ExcelLoad.class.getClassLoader().getResource("org-catalog.xls");
            File files = new File(file.getPath());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(files));

            Workbook wb = WorkbookFactory.create(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();

            for(int i =1 ;i <= rowNum ;i++){
                Row eachRow = sheet.getRow(i);
                int orgId = Integer.parseInt(eachRow.getCell(0).getStringCellValue());
                int cateId;
                try {
                    cateId = Integer.parseInt(eachRow.getCell(2).getStringCellValue());
                }catch (Exception e){
                    cateId = (int) eachRow.getCell(2).getNumericCellValue();
                }
                String sql = "update YQB_ORG set category_id = " + cateId + " where id = "+ orgId;
                PreparedStatement pst = conn.prepareStatement(sql);
                boolean r = pst.execute();
                System.out.println(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }






    //写入excel
    public static HSSFWorkbook exportExcel(List<String> headers, List<List<String>> values) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        sheet.autoSizeColumn(0, true);
        if (CollectionUtils.isNotEmpty(headers)) {
            int index = 0;
            for (String header : headers) {
                createCell(wb, row, index++, header);
            }
        }

        Row rowRecord;
        if (CollectionUtils.isNotEmpty(values)) {
            int count = 1;
            for (List<String> value : values) {
                rowRecord = sheet.createRow(count++);
                int index = 0;
                for (String v : value) {
                    createCell(wb, rowRecord, index++, v);
                }
            }
        }
        if (CollectionUtils.isNotEmpty(headers)) {
            for (int index = 0, size = headers.size(); index < size; index++) {
                sheet.autoSizeColumn(index, true);
            }
        }
        return wb;
    }

    //填充cell
    private static void createCell(HSSFWorkbook wb, Row row, int column, String value) {
        if (StringUtils.isNotBlank(value)) {
            Cell cell = row.createCell(column);
            cell.setCellValue(value);
        } else {
            Cell cell = row.createCell(column, Cell.CELL_TYPE_BLANK);
            cell.setCellValue("");
        }
    }

}
