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

package club.javafamily.echarts.factory.dataset;

import club.javafamily.commons.enums.ChartType;
import club.javafamily.echarts.model.EChartDataSet;
import club.javafamily.echarts.info.ObjectInfo;
import club.javafamily.echarts.chart.ChartHelper;
import club.javafamily.echarts.factory.ChartObjectFactory;

public abstract class ChartDataSetFactory implements ChartObjectFactory<EChartDataSet> {

   @Override
   public boolean isAccept(ChartType type, ObjectInfo bindingInfo, ChartHelper chartHelper) {
      return chartHelper.isAccept(type, bindingInfo);
   }

}
