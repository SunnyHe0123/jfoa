/*
 * Copyright (c) 2020, JavaFamily Technology Corp, All Rights Reserved.
 *
 * The software and information contained herein are copyrighted and
 * proprietary to JavaFamily Technology Corp. This software is furnished
 * pursuant to a written license agreement and may be used, copied,
 * transmitted, and stored only in accordance with the terms of such
 * license and with the inclusion of the above copyright notice. Please
 * refer to the file "COPYRIGHT" for further copyright and licensing
 * information. This software and information or any other copies
 * thereof may not be provided or otherwise made available to any other
 * person.
 */
package club.javafamily.runner.common.table.lens;

import club.javafamily.runner.common.table.cell.Cell;

public class DefaultTableLens implements TableLens {

   public DefaultTableLens() {
      this(0, 0);
   }

   public DefaultTableLens(int rowCount, int colCount) {
      this.rowCount = rowCount;
      this.colCount = colCount;
      this.data = new Cell[rowCount][colCount];
   }

   @Override
   public Cell getObject(int row, int col) {
      return data[row][col];
   }

   @Override
   public void setObject(int row, int col, Cell cell) {
      data[row][col] = cell;
   }

   @Override
   public int getRowCount() {
      return rowCount;
   }

   @Override
   public int getColCount() {
      return colCount;
   }

   @Override
   public String getTableName() {
      return tableName;
   }

   public void setTableName(String tableName) {
      this.tableName = tableName;
   }

   @Override
   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   private Cell[][] data;
   private int rowCount;
   private int colCount;
   private String tableName;
   private String description;
}
