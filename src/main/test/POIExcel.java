

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkpal.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;


public class POIExcel {

    private int totalRows = 0;// 总行数
    private int totalCells = 0;// 总列数

    public Map<String, List<List<String>>> read(String fileName) {
        Map<String, List<List<String>>> maps = new HashMap<String, List<List<String>>>();
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$"))
            return maps;
        File file = new File(fileName);
        if (file == null || !file.exists())
            return maps;
        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(file));
            maps = read(wb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    private Map<String, List<List<String>>> read(Workbook wb) {
        Map<String, List<List<String>>> maps = new HashMap<String, List<List<String>>>();
        int number = wb.getNumberOfSheets();
        if (number > 0) {
            for (int i = 0; i < number; i++) { // 循环每个工作表
                List<List<String>> list = new ArrayList<List<String>>();
                int delnumber = 0;// 第一页去除行数
                Sheet sheet = wb.getSheetAt(i);
                this.totalRows = sheet.getPhysicalNumberOfRows() - delnumber; // 获取工作表中行数
                if (this.totalRows >= 1 && sheet.getRow(delnumber) != null) {
                    this.totalCells = sheet.getRow(0)
                            .getPhysicalNumberOfCells(); // 得到当前行的所有单元格
                    for (int j = 0; j < totalRows; j++) {
                        List<String> rowLst = new ArrayList<String>();
                        Row row=sheet.getRow(j);
                        for (int f = 0; f < totalCells; f++) {
                            if (totalCells > 0) {

                              //  Cell cell=row.getCell(f);
                               try {
                                   String value="";
                                   if(row==null)
                                   {
                                       value="";
                                   }
                                   else
                                   {
                                       value=getCell(row.getCell(f));
                                   }

                                //   System.out.println(value);
                                   rowLst.add(value);
                               }
                               catch(Exception e)
                               {
                                   e.printStackTrace();
                               }
                            }
                        }
                        list.add(rowLst);
                    }
                }
                maps.put(sheet.getSheetName(), list);
            }
        }
        return maps;
    }

    /*
     * private String getRightStr(String sNum) { DecimalFormat decimalFormat =
     * new DecimalFormat("##.00"); String resultStr = decimalFormat.format(new
     * Double(sNum)); if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) { resultStr =
     * resultStr.substring(0, sNum.indexOf(".")); } return resultStr; }
     */

    public String getCell(Cell cell) {
        String cellValue = null;
        /*
         * if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) { if
         * (HSSFDateUtil.isCellDateFormatted(cell)) { cellValue =
         * getRightStr(cell.getDateCellValue() + ""); } else {
         *
         * cellValue = getRightStr(cell.getNumericCellValue() + ""); } } else if
         * (Cell.CELL_TYPE_STRING == cell.getCellType()) { cellValue =
         * cell.getStringCellValue(); } else if (Cell.CELL_TYPE_BOOLEAN ==
         * cell.getCellType()) { cellValue = cell.getBooleanCellValue() + ""; }
         * else { cellValue = cell.getStringCellValue(); }
         */
        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
        cellValue = hSSFDataFormatter.formatCellValue(cell); // 使用EXCEL原来格式的方式取得值
        return cellValue;
    }

    public static void main(String[] args) {
       /* try {
            Map<String, List<List<String>>> map = new POIExcel()
                    .read("d:\\123.xls");
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        List<List<Object>> listob=null;
       File file=new File("d:\\\\123.xls");
        try {
            FileInputStream in=new FileInputStream(file);
            listob= ExcelUtil.getListByExcel(in,file.getName());
            System.out.println(listob);
            List colname=new ArrayList<>();
            //List coldata=new ArrayList<>();
            int x=0;
            int y=0;
            int row=0;
            for(int i=0;i<listob.size();i++)
            {
                if( listob.get(i).contains("供应商/供应工厂")&& listob.get(i).contains("物料"))
                {
                    for(int j=0;j<listob.get(i).size();j++)
                    {
                        if(listob.get(i).get(j).toString().equals("供应商/供应工厂"))
                    {
                        x=j;
                    }
                        if(listob.get(i).get(j).toString().equals("物料"))
                        {
                            y=j;
                        }
                    }
                    row=i;
                    colname.addAll(listob.get(i));
                    break;
                }

               // System.out.println( );
            }
            List<Map<String,Object>> list=new ArrayList<>();
            for(int i=row+1;i<listob.size();i++)
            {
                if(!(listob.get(i).contains("供应商/供应工厂")&& listob.get(i).contains("物料")))
                {
                    if(listob.get(i).get(x)!=null&&listob.get(i).get(y)!=null&&!(listob.get(i).get(x).toString().equals("*")))
                    {
                        Map map=new HashMap();
                        for(int j=0;j<listob.get(i).size();j++)
                        {

                            map.put(colname.get(j).toString().trim(),listob.get(i).get(j));
                        }
                        list.add(map);
                    }
                }
            }


            System.out.println(list);
            //System.out.println(coldata);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}