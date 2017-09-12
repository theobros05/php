 int col_num = -1;
 
        for(int i=0; i < row.getLastCellNum(); i++)
        {
            if(row.getCell(i).getStringCellValue().trim().equals("UserName"))
                col_num = i;
        }
 
        row = sheet.getRow(1);
        XSSFCell cell = row.getCell(col_num);
 
        String value = cell.getStringCellValue();
        System.out.println("Value of the Excel Cell is - "+ value);