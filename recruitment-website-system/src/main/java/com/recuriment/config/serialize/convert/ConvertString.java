package com.recuriment.config.serialize.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Author lqp
 * @Date 2020/11/18 15:05
 **/
public class ConvertString implements Converter<Long> {

    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里是读的时候会调用
     *
     * @param cellData
     *            NotNull
     * @param contentProperty
     *            Nullable
     * @param globalConfiguration
     *            NotNull
     * @return
     */
    @Override
    public Long convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                      GlobalConfiguration globalConfiguration) {
        return Long.valueOf(cellData.getStringValue());
    }

    /**
     * 这里是写的时候会调用
     *
     * @param value
     *            NotNull
     * @param contentProperty
     *            Nullable
     * @param globalConfiguration
     *            NotNull
     * @return
     */
    @Override
    public CellData convertToExcelData(Long value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {

        return new CellData(value.toString());
    }

}
